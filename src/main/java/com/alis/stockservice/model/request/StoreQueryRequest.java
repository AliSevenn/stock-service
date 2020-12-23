package com.alis.stockservice.model.request;

import java.util.List;

public class StoreQueryRequest {
	private List<Long> storeIds;
	private List<Long> regionIds;

	public List<Long> getStoreIds() {
		return storeIds;
	}

	public void setStoreIds(List<Long> storeIds) {
		this.storeIds = storeIds;
	}

	public List<Long> getRegionIds() {
		return regionIds;
	}

	public void setRegionIds(List<Long> regionIds) {
		this.regionIds = regionIds;
	}

	public StoreQueryRequest(List<Long> storeIds, List<Long> regionIds) {
		this.storeIds = storeIds;
		this.regionIds = regionIds;
	}
}