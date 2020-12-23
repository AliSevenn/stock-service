package com.alis.stockservice.service;

import java.util.List;

import com.alis.stockservice.entity.UserEntity;
import com.alis.stockservice.model.User;

public interface UserService {

	public User findByName(String name);

	public User findByPhoneNumber(Long phoneNumber);

	public User findById(Long id);

	public List<UserEntity> query(List<Long> userIds, List<Long> phoneNumbers);

	public UserEntity save(UserEntity entity);

	public UserEntity findByUserId(Long userId);
}
