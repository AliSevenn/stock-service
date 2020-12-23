package com.alis.stockservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alis.stockservice.entity.StoreEntity;

@Repository
public interface StoreRepository extends JpaRepository<StoreEntity, Long> {

	StoreEntity findByStoreId(Long id);

	@Query("select m from StoreEntity m where m.region.regionId = :id")
	StoreEntity findByRegionId(Long id);

	@Query("select m from StoreEntity m where m.region.regionId in ( :regionIds)  and m.storeId in ( :storeIds)")
	List<StoreEntity> findByStoreIdInAndRegionIdIn(List<Long> storeIds, List<Long> regionIds);

}
