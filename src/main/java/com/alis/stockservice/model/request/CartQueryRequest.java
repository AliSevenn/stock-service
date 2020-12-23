package com.alis.stockservice.model.request;

public class CartQueryRequest {
	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public CartQueryRequest(Long userId) {
		this.userId = userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
