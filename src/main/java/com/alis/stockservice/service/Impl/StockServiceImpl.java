package com.alis.stockservice.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alis.stockservice.entity.StockEntity;
import com.alis.stockservice.model.Stock;
import com.alis.stockservice.repo.StockRepository;
import com.alis.stockservice.service.StockService;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	StockRepository stockRepository;
	@Autowired
	ModelMapper modelMapper;

	public List<StockEntity> query(List<Long> productIds, List<Long> storeIds) {

		return stockRepository.findByProductInAndStoreIn(productIds, storeIds);
	}

	public Stock findById(Long id) {

		return modelMapper.map(stockRepository.findByStockId(id), Stock.class);
	}

	public Stock findByStoreIdAndProductId(Long storeId, Long productId) {
		return modelMapper.map(stockRepository.findByStoreIdAndProductId(storeId, productId), Stock.class);
	}

	@Transactional
	public StockEntity save(StockEntity stock) {
		return stockRepository.save(stock);
	}
}
