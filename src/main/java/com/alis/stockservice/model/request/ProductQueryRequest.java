package com.alis.stockservice.model.request;

import java.util.List;

public class ProductQueryRequest {
	public List<Long> getProductIds() {
		return productIds;
	}

	public void setProductIds(List<Long> productIds) {
		this.productIds = productIds;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	private List<Long> productIds;

	private List<String> names;

	public ProductQueryRequest(List<Long> productIds, List<String> names) {
		this.productIds = productIds;
		this.names = names;
	}
}
