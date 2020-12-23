package com.alis.stockservice.service;

import com.alis.stockservice.TestMain;
import com.alis.stockservice.entity.*;
import com.alis.stockservice.model.Category;
import com.alis.stockservice.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = TestMain.class)
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CartItemServiceTest {

	@Autowired
	UserService userService;
	@Autowired
	CartItemService cartItemService;
	@Autowired
	CartService cartService;
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	AddressService addressService;
	@Autowired
	RegionService regionService;
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	StoreService storeService;
	@Autowired
	StockService stockService;
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;

	@DisplayName("Test save cart item")
	@Test
	@Transactional
	void testSaveCartItem() throws Exception {

		RegionEntity region = new RegionEntity();
		region.setName("kadikoy");
		region.setPostalCode(3400);
		region.setRegionType(RegionType.CITY);
		region = regionService.save(region);

		Category category = new Category();
		category.setModifyUser("alis");
		category.setName("book");
		category.setModifyTime(LocalDateTime.now());
		category = categoryService.save(category);

		AddressEntity address = new AddressEntity();
		address.setCountry("izmir");
		address.setDescription("nees");
		address.setRegion(region);
		address = addressService.save(address);

		UserEntity user = new UserEntity();
		user.setAddress(address);
		user.setName("Ali");
		user.setPassword("1234");
		user.setPhoneNumber(5446223539l);
		user.setPhoneCode("+90");
		user.setRoles(Set.of("update-roles"));
		user.setUserType(UserType.CUSTOMER);
		user.setModifyUser("adadsa");
		user.setModifyTime(LocalDateTime.now());
		user = userService.save(user);

		Product product = new Product();
		product.setModifyUser("alis");
		product.setPrice(BigDecimal.TEN);
		product.setCategory(category);
		product.setName("1984");
		product.setCreateTime(LocalDateTime.now());

		product = productService.save(product);

		StoreEntity store = new StoreEntity();
		store.setAddress(address);
		store.setRegion(region);
		store.setName("kadikoy");
		store = storeService.save(store);

		StockEntity stock = new StockEntity();
		stock.setProduct(productService.findByProductId(product.getProductId()));
		stock.setName("stock1");
		stock.setStore(store);
		stock = stockService.save(stock);

		CartEntity cart = new CartEntity();
		cart.setUserId(user.getUserId());
		cart.setTotalPrice(BigDecimal.valueOf(25));

		CartItemEntity cartItem = new CartItemEntity();
		cartItem.setTotalPrice(BigDecimal.valueOf(40));
		cartItem.setProduct(modelMapper.map(product, ProductEntity.class));
		cartItem.setQuantity(4);
		cart.setCartItems(List.of(cartItem));
		cartItem.setCart(cart);
		cart = cartService.save(cart);

		assertTrue(cartItem.getCartItemId() > 0);

	}

}
