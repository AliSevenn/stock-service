package com.alis.stockservice.utility;

import com.alis.stockservice.entity.CartItemEntity;
import com.alis.stockservice.entity.ProductEntity;

public class CartUtil {

	public static boolean isCartItemExists(ProductEntity product, CartItemEntity item) {
		return item.isActive() == true && item.getProduct().getProductId().equals(product.getProductId());
	}
}
