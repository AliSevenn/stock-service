package com.alis.stockservice.service;

import java.util.List;

import com.alis.stockservice.entity.AddressEntity;
import com.alis.stockservice.model.Address;

public interface AddressService {

	public List<AddressEntity> query(List<Long> regionIds);

	public Address findById(Long id);

	public AddressEntity save(AddressEntity entity);

}
