package com.alis.stockservice.service;



import javax.transaction.Transactional;

import com.alis.stockservice.entity.CartItemEntity;
import org.springframework.stereotype.Component;

import com.alis.stockservice.model.CartItem;

@Component
@Transactional
public interface CartItemService {

	public CartItemEntity save(CartItemEntity entity) ;

	public CartItem findById(Long id) ;
}
