package com.alis.stockservice.service;



import java.util.List;

import com.alis.stockservice.entity.RegionEntity;
import com.alis.stockservice.entity.RegionType;
import com.alis.stockservice.model.Region;


public interface RegionService {


	public List<RegionEntity> query(List<Long> regionIds, List<RegionType> regionTypes);

	public Region findById(Long id);

	public RegionEntity save(RegionEntity entity);

	public RegionEntity findByRegionId(Long regionId);

}
