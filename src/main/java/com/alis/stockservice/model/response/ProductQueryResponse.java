package com.alis.stockservice.model.response;

import java.util.List;

public class ProductQueryResponse {
	private List<Long> productIds;

	public List<Long> getProductIds() {
		return productIds;
	}

	public void setProductIds(List<Long> productIds) {
		this.productIds = productIds;
	}

	public ProductQueryResponse(List<Long> productIds) {
		this.productIds = productIds;
	}

	public ProductQueryResponse() {
	}
}
