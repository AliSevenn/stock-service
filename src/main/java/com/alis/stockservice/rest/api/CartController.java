package com.alis.stockservice.rest.api;

import com.alis.stockservice.model.request.CartItemAddRequest;
import com.alis.stockservice.model.request.CartQueryRequest;
import com.alis.stockservice.model.response.CartUpdateResponse;
import com.alis.stockservice.rest.service.CartBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "cart", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
		MediaType.APPLICATION_JSON_VALUE })
@RestController
public class CartController {

	@Autowired
	CartBusinessService cartBusinessService;

	@PostMapping("/item")

	public ResponseEntity<CartUpdateResponse> addItem(@RequestBody CartItemAddRequest request) {

		return new ResponseEntity<CartUpdateResponse>(cartBusinessService.addItem(request), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<CartUpdateResponse> queryCart(CartQueryRequest request) {

		return new ResponseEntity<CartUpdateResponse>(
				cartBusinessService.queryCart(request.getUserId()),
				HttpStatus.OK);
	}

}
