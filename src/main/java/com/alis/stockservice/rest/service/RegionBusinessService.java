package com.alis.stockservice.rest.service;

import com.alis.stockservice.model.Region;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alis.stockservice.model.request.RegionQueryRequest;
import com.alis.stockservice.model.response.RegionQueryResponse;
import com.alis.stockservice.service.RegionService;

import java.util.ArrayList;

@Component
public class RegionBusinessService {

	@Autowired
	RegionService regionService;


	public RegionQueryResponse query(RegionQueryRequest request) {
		var regions = regionService.query(request.getRegionIds(), request.getRegionTypes());
		var response = new RegionQueryResponse(new ArrayList<Region>());
		regions.forEach(c->{
			var region = new Region();
			region.setName(c.getName());
			region.setPostalCode(c.getPostalCode());
			region.setRegionId(c.getRegionId());
			region.setRegionType(c.getRegionType().toString());
			response.getRegions().add(region);
		});

		return response;
	}

}
