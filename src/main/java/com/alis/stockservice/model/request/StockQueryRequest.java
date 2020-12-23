package com.alis.stockservice.model.request;

import java.util.List;

public class StockQueryRequest {
	private List<Long> productIds;
	private List<Long> storeIds;

	public List<Long> getProductIds() {
		return productIds;
	}

	public void setProductIds(List<Long> productIds) {
		this.productIds = productIds;
	}

	public List<Long> getStoreIds() {
		return storeIds;
	}

	public void setStoreIds(List<Long> storeIds) {
		this.storeIds = storeIds;
	}

	public StockQueryRequest(List<Long> productIds, List<Long> storeIds) {
		this.productIds = productIds;
		this.storeIds = storeIds;
	}

	public StockQueryRequest() {
	}
}