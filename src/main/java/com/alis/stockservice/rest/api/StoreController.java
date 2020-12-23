package com.alis.stockservice.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alis.stockservice.model.request.StoreQueryRequest;
import com.alis.stockservice.model.response.StoreQueryResponse;
import com.alis.stockservice.rest.service.StoreBusinessService;

@RequestMapping(value = "store", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
		MediaType.APPLICATION_JSON_VALUE })
@RestController
public class StoreController {

	@Autowired
	StoreBusinessService storeBusinessService;

	@PostMapping("/query")
	public ResponseEntity<StoreQueryResponse> query(@RequestBody StoreQueryRequest request) {
		return new ResponseEntity<StoreQueryResponse>(storeBusinessService.query(request), HttpStatus.OK);

	}

}
