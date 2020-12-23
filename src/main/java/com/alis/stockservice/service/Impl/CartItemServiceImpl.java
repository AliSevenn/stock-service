package com.alis.stockservice.service.Impl;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alis.stockservice.entity.CartItemEntity;
import com.alis.stockservice.model.CartItem;
import com.alis.stockservice.repo.CartItemRepository;
import com.alis.stockservice.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CartItemRepository cartItemRepository;



    @Transactional
    public CartItemEntity save(CartItemEntity cartItem) {

       return cartItemRepository.save(cartItem);

    }

    public CartItem findById(Long id) {


        return modelMapper.map(cartItemRepository.findById(id), CartItem.class);

    }
}