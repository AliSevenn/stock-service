package com.alis.stockservice.model.response;

import java.util.List;

import com.alis.stockservice.model.Region;

public class RegionQueryResponse {
	private List<Region> regions;

	public List<Region> getRegions() {
		return regions;
	}

	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}

	public RegionQueryResponse(List<Region> regions) {
		this.regions = regions;
	}

	public RegionQueryResponse() {
	}
}
