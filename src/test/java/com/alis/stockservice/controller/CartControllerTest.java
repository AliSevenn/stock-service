package com.alis.stockservice.controller;

import com.alis.stockservice.TestMain;
import com.alis.stockservice.entity.*;
import com.alis.stockservice.model.Category;
import com.alis.stockservice.model.Product;
import com.alis.stockservice.model.request.CartItemAddRequest;
import com.alis.stockservice.service.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = TestMain.class)
@AutoConfigureMockMvc
@TestInstance(Lifecycle.PER_CLASS)
public class CartControllerTest {
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

	@Test
	@DisplayName("Test Add Item to Cart SuccessFully")
	@Transactional
	void testCartItemToCartSuccessFully() throws JsonProcessingException, Exception {

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

		var query = new CartItemAddRequest(product.getProductId(), address.getAddressId(), cart.getUserId());
		query.setQuantity(3);
		mockMvc.perform(
				post("/cart/item").contentType("application/json").content(objectMapper.writeValueAsString(query)))
				.andDo(print()).andExpect(status().isOk());

	}

}
