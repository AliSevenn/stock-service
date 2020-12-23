package com.alis.stockservice.service;

import com.alis.stockservice.TestMain;
import com.alis.stockservice.entity.CartEntity;
import com.alis.stockservice.model.response.UserSaveResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = TestMain.class)
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CartServiceTest {

	@Autowired
	CartService cartService;

	@Autowired
	UserService userService;

	UserSaveResponse customer;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@DisplayName("Test save cart")
	@Test
	@Transactional
	void testSaveCart() {

		CartEntity cart = new CartEntity();
		cart.setTotalPrice(BigDecimal.ZERO);
		cart.setModifyUser("alis");

		assertTrue(cartService.save(cart).getCartId() > 0);
	}

	@DisplayName("Test find cart")
	@Test
	@Transactional
	void testFindCart() {

		CartEntity cart = new CartEntity();
		cart.setTotalPrice(BigDecimal.ONE);
		cart.setModifyUser("alis");
		Long cartId = cartService.save(cart).getCartId();

		assertTrue(Optional.of(cartService.findById(cartId)).isPresent());
	}

}
