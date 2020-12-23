package com.alis.stockservice.rest.service;

import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alis.stockservice.entity.AddressEntity;
import com.alis.stockservice.entity.UserEntity;
import com.alis.stockservice.entity.UserType;
import com.alis.stockservice.exception.BusinessException;
import com.alis.stockservice.model.Address;
import com.alis.stockservice.model.request.UserAddressSaveRequest;
import com.alis.stockservice.model.request.UserQueryRequest;
import com.alis.stockservice.model.request.UserSaveRequest;
import com.alis.stockservice.model.response.UserAddressSaveResponse;
import com.alis.stockservice.model.response.UserQueryResponse;
import com.alis.stockservice.model.response.UserSaveResponse;
import com.alis.stockservice.service.AddressService;
import com.alis.stockservice.service.RegionService;
import com.alis.stockservice.service.UserService;

@Component
public class UserBusinessService {

	@Autowired
	UserService userService;

	@Autowired
	AddressService addressService;

	@Autowired
	RegionService regionService;

	@Autowired
	ModelMapper modelMapper;

	public UserQueryResponse query(UserQueryRequest request) {
		var users = userService.query(request.getUserIds(), request.getPhoneNumbers());
		UserQueryResponse userQueryResponse = modelMapper.map(users, UserQueryResponse.class);
		return userQueryResponse;
	}

	public UserSaveResponse save(UserSaveRequest request) {
		var user = userService.findByPhoneNumber(request.getPhoneNumber());
		if (Objects.isNull(user)) {
			throw new BusinessException("ERROR_PHONE_NUMBER_ALREADY_REGISTERED");
		}
		var userEntity = new UserEntity();
		userEntity.setName(request.getName());
		userEntity.setPassword(request.getPassword());
		userEntity.setModifyUser("");
		userEntity.setPhoneCode(request.getPhoneCode());
		userEntity.setPhoneNumber(request.getPhoneNumber());
		userEntity.setUserType(UserType.valueOf(request.getUserType()));
		userService.save(userEntity);
		return modelMapper.map(userEntity, UserSaveResponse.class);
	}

	public UserAddressSaveResponse saveAddress(UserAddressSaveRequest request) {
		var user = userService.findByPhoneNumber(request.getPhoneNumber());
		if (Objects.isNull(user)) {
			var region = regionService.findById(request.getRegionId());
			if (Objects.isNull(region)) {
				throw new BusinessException("ERROR_REGION_NOT_FOUND");
			}
			AddressEntity address = new AddressEntity();
			address.setRegion(regionService.findByRegionId(region.getRegionId()));
			address.setDescription(request.getDescription());
			address.setCountry(request.getCountry());
			var userEntity = userService.findByUserId(user.getUserId());
			userEntity.setAddress(addressService.save(address));
			userEntity = userService.save(userEntity);
			return null;
		}
		throw new BusinessException("ERROR_USER_NOT_FOUND");
	}

}
