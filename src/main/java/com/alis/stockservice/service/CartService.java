package com.alis.stockservice.service;



import com.alis.stockservice.entity.CartEntity;
import com.alis.stockservice.model.Cart;



public interface CartService {



	public Cart findById(Long id);

	public Cart findByUserIdAndActive(Long id, boolean isActive);

	public Cart findByUserId(Long id);

	public CartEntity save(CartEntity cart);

	public CartEntity findByCartId(Long cartId);
}
