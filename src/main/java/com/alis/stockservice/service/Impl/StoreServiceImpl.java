package com.alis.stockservice.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alis.stockservice.entity.StoreEntity;
import com.alis.stockservice.model.Store;
import com.alis.stockservice.repo.StoreRepository;
import com.alis.stockservice.service.StoreService;

@Service

public class StoreServiceImpl implements StoreService {

	@Autowired
	StoreRepository storeRepository;
	@Autowired
	ModelMapper modelMapper;

	public List<StoreEntity> query(List<Long> storeIds, List<Long> regionIds) {

		return storeRepository.findByStoreIdInAndRegionIdIn(storeIds, regionIds);
	}

	public Store findById(Long id) {

		return modelMapper.map(storeRepository.findById(id), Store.class);
	}

	public Store findByRegionId(Long id) {
		return modelMapper.map(storeRepository.findByRegionId(id), Store.class);
	}

	@Transactional
	public StoreEntity save(StoreEntity store) {
//		
		return storeRepository.save(store);
	}
}
