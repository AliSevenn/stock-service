package com.alis.stockservice.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alis.stockservice.model.request.RegionQueryRequest;
import com.alis.stockservice.model.response.RegionQueryResponse;
import com.alis.stockservice.rest.service.RegionBusinessService;

@RequestMapping(value = "region", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
		MediaType.APPLICATION_JSON_VALUE })
@RestController
public class RegionController {

	@Autowired
	RegionBusinessService regionBusinessService;

	@PostMapping("/query")
	public ResponseEntity<RegionQueryResponse> query(@RequestBody RegionQueryRequest request) {
		return new ResponseEntity<RegionQueryResponse>(regionBusinessService.query(request), HttpStatus.OK);

	}
}
