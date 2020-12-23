package com.alis.stockservice.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alis.stockservice.model.request.StockQueryRequest;
import com.alis.stockservice.model.response.StockQueryResponse;
import com.alis.stockservice.rest.service.StockBusinessService;

@RequestMapping(value = "stock", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
		MediaType.APPLICATION_JSON_VALUE })
@RestController
public class StockController {

	@Autowired
	StockBusinessService stockBusinessService;

	@PostMapping("/query")
	public ResponseEntity<StockQueryResponse> query(@RequestBody StockQueryRequest request) {
		return new ResponseEntity<StockQueryResponse>(stockBusinessService.query(request), HttpStatus.OK);

	}

}
