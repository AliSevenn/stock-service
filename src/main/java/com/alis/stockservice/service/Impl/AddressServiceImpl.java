package com.alis.stockservice.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alis.stockservice.entity.AddressEntity;
import com.alis.stockservice.model.Address;
import com.alis.stockservice.repo.AddressRepository;
import com.alis.stockservice.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	AddressRepository addressRepository;
	@Autowired
	ModelMapper modelMapper;

	public List<AddressEntity> query(List<Long> regionIds) {
		return addressRepository.findByRegionIn(regionIds);
	}

	public Address findById(Long id) {
		return modelMapper.map(addressRepository.findById(id).get(), Address.class);

	}

	@Transactional
	public AddressEntity save(AddressEntity address) {
		return addressRepository.save(address);
	}


}
