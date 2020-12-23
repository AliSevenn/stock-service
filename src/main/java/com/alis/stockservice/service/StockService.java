package com.alis.stockservice.service;



import java.util.List;

import com.alis.stockservice.entity.StockEntity;
import com.alis.stockservice.model.Stock;


public interface StockService {


	public List<StockEntity> query(List<Long> productIds, List<Long> storeIds);

	public Stock findById(Long id);

	public Stock findByStoreIdAndProductId(Long storeId, Long productId) ;

	public StockEntity save(StockEntity stock) ;

}
