package com.alis.stockservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alis.stockservice.entity.RegionEntity;
import com.alis.stockservice.entity.RegionType;

@Repository
public interface RegionRepository extends JpaRepository<RegionEntity, Long> {

	RegionEntity findByRegionId(Long id);

	List<RegionEntity> findByRegionTypeInAndRegionIdIn(List<RegionType> regionTypes, List<Long> regionIds);

}
