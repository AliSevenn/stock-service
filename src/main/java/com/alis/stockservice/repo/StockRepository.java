package com.alis.stockservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alis.stockservice.entity.StockEntity;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, Long> {

	StockEntity findByStockId(Long id);

	@Query("select m from StockEntity m where m.product.productId = :productId  and m.store.storeId= :storeId")
	StockEntity findByStoreIdAndProductId(Long storeId, Long productId);

	@Query("select m from StockEntity m where m.product.productId in( :productIds)  and m.store.storeId in ( :storeIds)")
	List<StockEntity> findByProductInAndStoreIn(List<Long> productIds, List<Long> storeIds);

}
