package com.alis.stockservice.service.Impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alis.stockservice.entity.RegionEntity;
import com.alis.stockservice.entity.RegionType;
import com.alis.stockservice.model.Region;
import com.alis.stockservice.repo.RegionRepository;
import com.alis.stockservice.service.RegionService;

@Service
public class RegionServiceImpl implements RegionService {

	@Autowired
	RegionRepository regionRepository;
	@Autowired
	ModelMapper modelMapper;

	public List<RegionEntity> query(List<Long> regionIds, List<RegionType> regionTypes) {
		return regionRepository.findByRegionTypeInAndRegionIdIn(regionTypes, regionIds);
	}

	public Region findById(Long id) {

		return modelMapper.map(regionRepository.findById(id), Region.class);
	}

	public RegionEntity save(RegionEntity region) {
		return regionRepository.save(region);
	}

	@Override
	public RegionEntity findByRegionId(Long regionId) {
		// TODO Auto-generated method stub
		return regionRepository.findByRegionId(regionId);
	}
}
