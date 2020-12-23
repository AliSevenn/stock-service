package com.alis.stockservice.model.request;

import java.util.List;

import com.alis.stockservice.entity.RegionType;

public class RegionQueryRequest {
	private List<Long> regionIds;
	private List<RegionType> regionTypes;

	public List<Long> getRegionIds() {
		return regionIds;
	}

	public void setRegionIds(List<Long> regionIds) {
		this.regionIds = regionIds;
	}

	public List<RegionType> getRegionTypes() {
		return regionTypes;
	}

	public void setRegionTypes(List<RegionType> regionTypes) {
		this.regionTypes = regionTypes;
	}

	public RegionQueryRequest(List<Long> regionIds, List<RegionType> regionTypes) {
		this.regionIds = regionIds;
		this.regionTypes = regionTypes;
	}
}