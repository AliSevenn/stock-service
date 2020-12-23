package com.alis.stockservice.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alis.stockservice.model.request.CategoryQueryRequest;
import com.alis.stockservice.model.response.CategoryQueryResponse;
import com.alis.stockservice.rest.service.CategoryBusinessService;

@RequestMapping(value = "category", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
		MediaType.APPLICATION_JSON_VALUE })
@RestController
public class CategoryController {

	@Autowired
	CategoryBusinessService categoryService;

	@PostMapping("/query")

	public ResponseEntity<CategoryQueryResponse> query(@RequestBody CategoryQueryRequest request) {
		return new ResponseEntity<CategoryQueryResponse>(categoryService.query(request), HttpStatus.OK);
	}

}
