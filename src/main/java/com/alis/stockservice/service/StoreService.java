package com.alis.stockservice.service;

import java.util.List;

import com.alis.stockservice.entity.StoreEntity;
import com.alis.stockservice.model.Store;

public interface StoreService {

	public List<StoreEntity> query(List<Long> storeIds, List<Long> regionIds);

	public Store findById(Long id);

	public Store findByRegionId(Long id);

	public StoreEntity save(StoreEntity entity);

}
