package com.alis.stockservice.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alis.stockservice.model.request.UserAddressSaveRequest;
import com.alis.stockservice.model.request.UserQueryRequest;
import com.alis.stockservice.model.request.UserSaveRequest;
import com.alis.stockservice.model.response.UserAddressSaveResponse;
import com.alis.stockservice.model.response.UserQueryResponse;
import com.alis.stockservice.model.response.UserSaveResponse;
import com.alis.stockservice.rest.service.UserBusinessService;

@RequestMapping(value = "user", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
		MediaType.APPLICATION_JSON_VALUE })
@RestController
public class UserController {

	@Autowired
	UserBusinessService userBusinessService;

	@GetMapping
	public ResponseEntity<UserQueryResponse> query(@RequestBody UserQueryRequest request) {
		return new ResponseEntity<UserQueryResponse>(userBusinessService.query(request), HttpStatus.OK);
	}

	@PostMapping("register")
	public ResponseEntity<UserSaveResponse> save(@RequestBody UserSaveRequest request) {
		return new ResponseEntity<UserSaveResponse>(userBusinessService.save(request), HttpStatus.OK);
	}

	@PostMapping("address")
	public ResponseEntity<UserAddressSaveResponse> saveAddress(@RequestBody UserAddressSaveRequest request) {
		return new ResponseEntity<UserAddressSaveResponse>(userBusinessService.saveAddress(request), HttpStatus.OK);
	}
}
