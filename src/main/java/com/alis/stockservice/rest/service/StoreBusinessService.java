package com.alis.stockservice.rest.service;

import com.alis.stockservice.model.Address;
import com.alis.stockservice.model.Region;
import com.alis.stockservice.model.Store;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alis.stockservice.model.request.StoreQueryRequest;
import com.alis.stockservice.model.response.StoreQueryResponse;
import com.alis.stockservice.service.RegionService;
import com.alis.stockservice.service.StoreService;

import java.util.ArrayList;

@Component
public class StoreBusinessService {

	@Autowired
	StoreService storeService;

	@Autowired
	RegionService regionService;
	@Autowired
	ModelMapper modelMapper;

	public StoreQueryResponse query(StoreQueryRequest request) {
		var stores = storeService.query(request.getStoreIds(), request.getRegionIds());
		var response = new StoreQueryResponse(new ArrayList<Store>());
		// response.setStores(new ArrayList<Store>());
		stores.forEach(s -> {
			var store = new Store();
			store.setStoreId(s.getStoreId());
			store.setName(s.getName());
			store.setRegion(modelMapper.map(s.getRegion(), Region.class));
			store.setAddress(modelMapper.map(s.getAddress(), Address.class));
			response.getStores().add(store);

		});

		return response;
	}

}
