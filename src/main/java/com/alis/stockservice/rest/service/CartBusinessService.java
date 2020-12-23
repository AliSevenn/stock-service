package com.alis.stockservice.rest.service;

import com.alis.stockservice.entity.CartEntity;
import com.alis.stockservice.entity.CartItemEntity;
import com.alis.stockservice.entity.ProductEntity;
import com.alis.stockservice.exception.BusinessException;
import com.alis.stockservice.model.Cart;
import com.alis.stockservice.model.CartItem;
import com.alis.stockservice.model.Product;
import com.alis.stockservice.model.request.CartItemAddRequest;
import com.alis.stockservice.model.response.CartUpdateResponse;
import com.alis.stockservice.service.*;
import com.alis.stockservice.utility.CartUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

@Component
@Transactional
public class CartBusinessService {

	@Autowired
	CategoryService categoryService;

	@Autowired
	ProductService productService;

	@Autowired
	CartService cartService;

	@Autowired
	CartItemService cartItemService;

	@Autowired
	CartItemBusinessService cartItemBusinessService;

	@Autowired
	StockService stockService;

	@Autowired
	UserService userService;

	@Autowired
	AddressService addressService;

	@Autowired
	StoreService storeService;
	@Autowired
	ModelMapper modelMapper;

	@Transactional
	public CartUpdateResponse addItem(CartItemAddRequest request) {

		var product = Optional.of(productService.findByProductId(request.getProductId()))
				.orElseThrow(() -> new BusinessException("ERROR_PRODUCT_NOT_FOUND"));

		validateStock(request, product);

		var user = userService.findById(request.getUserId());
		Cart cart = cartService.findByUserIdAndActive(request.getUserId(), true);
		CartEntity cartEntity = new CartEntity();

		if (cart == null) {
			cart = new Cart();
			cart.setTotalPrice(BigDecimal.ZERO);
			cart.setTotalFinalPrice(BigDecimal.ZERO);
			cart.setModifyUser(user.getName());
			cart.setUserId(user.getUserId());

			cartEntity = cartService.save(modelMapper.map(cart, CartEntity.class));
		} else {
			cartEntity = modelMapper.map(cart, CartEntity.class);
			cartEntity = cartService.save(modelMapper.map(cart, CartEntity.class));

		}
		/*
		 * Cart cart =
		 * Optional.ofNullable(cartService.findByUserIdAndActive(user.getUser().
		 * getUserId(), true)).orElse(
		 * cartService.save(Cart.builder().totalPrice(BigDecimal.ZERO).totalFinalPrice(
		 * BigDecimal.ZERO)
		 * .modifyUser(user.getUsername()).userId(user.getUser().getUserId()).build()));
		 */

		Optional<CartItemEntity> optionalCartItem = Objects.nonNull(cartEntity.getCartItems())
				? cartEntity.getCartItems().stream().filter(item -> CartUtil.isCartItemExists(product, item)).findAny()
				: Optional.empty();

		var quantity = request.getQuantity();
		if (optionalCartItem.isPresent()) {
			cart.getCartItems().remove(optionalCartItem.get());
			cartEntity = updateCart(cartEntity,
					cartItemBusinessService.updateCartItem(optionalCartItem.get(), quantity, user.getName()),
					user.getName());
		} else {
			cartEntity = updateCart(cartEntity,
					cartItemBusinessService.createCartItem(cartEntity, product, quantity, user.getName()),
					user.getName());
		}

		List<CartItem> cartItems =
				Arrays.asList(modelMapper.map(cartEntity.getCartItems(),CartItem[].class));




		var response = new CartUpdateResponse();
		response.setCartId(cartEntity.getCartId());
		response.setTotalPrice(cartEntity.getTotalPrice());
		response.setUserId(cartEntity.getUserId());


		return response;
	}

	private void validateStock(CartItemAddRequest request, ProductEntity product) {
		var address = Optional.of(addressService.findById(request.getAddressId()))
				.orElseThrow(() -> new BusinessException("ERROR_ADDRESS_NOT_FOUND"));

		var store = Optional.of(storeService.findByRegionId(address.getRegion().getRegionId()))
				.orElseThrow(() -> new BusinessException("ERROR_STORE_NOT_FOUND"));

		var stock = Optional.of(stockService.findByStoreIdAndProductId(store.getStoreId(), product.getProductId()))
				.orElseThrow(() -> new BusinessException("ERROR_PRODUCT_NOT_FOUND"));

	}

	@Transactional
	public CartEntity updateCart(CartEntity cart, CartItemEntity cartItem, String userName) {
		var items = Optional.ofNullable(cart.getCartItems()).orElse(new ArrayList<>());
		items.add(cartItem);
		BigDecimal totalPrice = items.stream().filter(item -> item.isActive() == true).map(p -> p.getTotalPrice())
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		cart.setTotalPrice(totalPrice);
		cart.setModifyUser(userName);
		cart.setCartItems(items);
		return cartService.save(cart);
	}

	public CartUpdateResponse queryCart(Long userId) {
		var cart = Optional.ofNullable(cartService.findByUserIdAndActive(userId, true))
				.orElseThrow(() -> new BusinessException("ERROR_CART_NOT_FOUND"));
		return new CartUpdateResponse(cart.getCartId(), cart.getDeliveryPrice(), cart.getTotalPrice(),
				cart.getTotalFinalPrice(), cart.getCartItems(), cart.getUserId());

	}

}
