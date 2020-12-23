package com.alis.stockservice.model.response;

import com.alis.stockservice.model.Address;

public class UserAddressSaveResponse extends Address {

	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public UserAddressSaveResponse(Long userId) {
		this.userId = userId;
	}

	public UserAddressSaveResponse() {
	}
}
