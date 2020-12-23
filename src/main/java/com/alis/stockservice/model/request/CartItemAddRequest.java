package com.alis.stockservice.model.request;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CartItemAddRequest {
	@NotNull
	private Long productId;
	@NotNull
	private Long addressId;
	@NotNull
	private Long userId;
	@NotNull
	private int quantity;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public CartItemAddRequest(@NotNull Long productId, @NotNull Long addressId, @NotNull Long userId) {
		this.productId = productId;
		this.addressId = addressId;
		this.userId = userId;

	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}



	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}


}
