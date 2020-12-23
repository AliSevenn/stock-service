package com.alis.stockservice.model.response;

import java.math.BigDecimal;
import java.util.List;

import com.alis.stockservice.model.CartItem;

public class CartItemAddResponse {

	private Long cartId;

	private BigDecimal discount;

	private BigDecimal deliveryPrice;

	private BigDecimal totalPrice;

	private BigDecimal totalFinalPrice;

	private List<CartItem> cartItems;

	private Long userId;

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getDeliveryPrice() {
		return deliveryPrice;
	}

	public void setDeliveryPrice(BigDecimal deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public BigDecimal getTotalFinalPrice() {
		return totalFinalPrice;
	}

	public void setTotalFinalPrice(BigDecimal totalFinalPrice) {
		this.totalFinalPrice = totalFinalPrice;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public CartItemAddResponse(Long cartId, BigDecimal discount, BigDecimal deliveryPrice, BigDecimal totalPrice, BigDecimal totalFinalPrice, List<CartItem> cartItems, Long userId) {
		this.cartId = cartId;
		this.discount = discount;
		this.deliveryPrice = deliveryPrice;
		this.totalPrice = totalPrice;
		this.totalFinalPrice = totalFinalPrice;
		this.cartItems = cartItems;
		this.userId = userId;
	}

	public CartItemAddResponse() {
	}
}
