package com.alis.stockservice.rest.service;

import com.alis.stockservice.entity.CartEntity;
import com.alis.stockservice.entity.CartItemEntity;
import com.alis.stockservice.entity.ProductEntity;
import com.alis.stockservice.model.CartItem;
import com.alis.stockservice.model.Product;
import com.alis.stockservice.service.CartItemService;
import com.alis.stockservice.service.CartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import javax.transaction.Transactional;

@Component
public class CartItemBusinessService {

	@Autowired
	CartItemService cartItemService;
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	CartService cartService;

	@Transactional
	CartItemEntity updateCartItem(CartItemEntity cartItem, int quantity, String username) {
		BigDecimal unitPrice = cartItem.getProduct().getPrice();
		BigDecimal totalPrice = unitPrice.multiply(BigDecimal.valueOf(quantity));
		cartItem.setTotalPrice(totalPrice);
		cartItem.setQuantity(quantity);
		return cartItemService.save(cartItem);
	}

	@Transactional
	CartItemEntity createCartItem(CartEntity cart, ProductEntity product, int quantity, String userName) {

		BigDecimal unitPrice = product.getPrice();
		BigDecimal totalPrice = unitPrice.multiply(BigDecimal.valueOf(quantity));
		CartItemEntity cartItem = new CartItemEntity();
		cartItem.setProduct(product);
		cartItem.setQuantity(quantity);
		cartItem.setCart(cartService.findByCartId(cart.getCartId()));
		cartItem.setTotalPrice(totalPrice);
		cartItem.setTotalPrice(totalPrice);
		cartItem.setModifyUser(userName);
		cartItem = cartItemService.save(cartItem);
		return cartItem;

	}

}
