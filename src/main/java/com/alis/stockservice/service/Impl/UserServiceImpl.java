package com.alis.stockservice.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alis.stockservice.entity.UserEntity;
import com.alis.stockservice.model.User;
import com.alis.stockservice.repo.UserRepository;
import com.alis.stockservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	ModelMapper modelMapper;

	public List<UserEntity> query(List<Long> userIds, List<Long> phoneNumbers) {
		return userRepository.findByUserIdInAndPhoneNumberIn(userIds, phoneNumbers);
	}

	public User findByName(String name) {

		return modelMapper.map(userRepository.findByName(name), User.class);
	}

	public User findByPhoneNumber(Long phoneNumber) {
		return modelMapper.map(userRepository.findByPhoneNumber(phoneNumber), User.class);
	}

	public User findById(Long id) {

		return modelMapper.map(userRepository.findById(id).get(), User.class);
	}

	@Transactional
	public UserEntity save(UserEntity user) {
		return userRepository.save(user);
	}

	@Override
	public UserEntity findByUserId(Long userId) {
		// TODO Auto-generated method stub
		return userRepository.findByUserId(userId);
	}

}
