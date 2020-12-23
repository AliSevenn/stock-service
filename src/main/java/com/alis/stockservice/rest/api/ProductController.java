package com.alis.stockservice.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alis.stockservice.model.request.ProductQueryRequest;
import com.alis.stockservice.model.response.ProductQueryResponse;
import com.alis.stockservice.rest.service.ProductBusinessService;

@RequestMapping(value = "product", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
		MediaType.APPLICATION_JSON_VALUE })
@RestController
public class ProductController {

	@Autowired
	ProductBusinessService productService;

	@PostMapping("/query")
	public ResponseEntity<ProductQueryResponse> query(@RequestBody ProductQueryRequest request) {
		return new ResponseEntity<ProductQueryResponse>(productService.query(request), HttpStatus.OK);
	}

}
