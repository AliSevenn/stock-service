package com.alis.stockservice.service.Impl;

import java.util.Objects;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alis.stockservice.entity.CartEntity;
import com.alis.stockservice.model.Cart;
import com.alis.stockservice.repo.CartRepository;
import com.alis.stockservice.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository cartRepository;
	@Autowired
	ModelMapper modelMapper;

	public Cart findById(Long id) {

		return modelMapper.map(cartRepository.findById(id), Cart.class);
	}

	public Cart findByUserIdAndActive(Long id, boolean isActive) {
		var cart = cartRepository.findByUserIdAndActive(id, isActive);
		if (Objects.nonNull(cart))
			return modelMapper.map(cart, Cart.class);
		return null;
	}

	public Cart findByUserId(Long id) {

		return modelMapper.map(cartRepository.findByUserId(id), Cart.class);
	}

	@Transactional
	public CartEntity save(CartEntity cart) {

		return cartRepository.save(cart);
	}

	@Override
	public CartEntity findByCartId(Long cartId) {
		return cartRepository.findByCartId(cartId);
	}
}
