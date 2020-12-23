package com.alis.stockservice.model.response;

import java.util.List;

import com.alis.stockservice.model.Store;

public class StoreQueryResponse {
	private List<Store> stores;

	public List<Store> getStores() {
		return stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}

	public StoreQueryResponse(List<Store> stores) {
		this.stores = stores;
	}

	public StoreQueryResponse() {
	}
}
