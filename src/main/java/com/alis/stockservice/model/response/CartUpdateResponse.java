package com.alis.stockservice.model.response;

import com.alis.stockservice.model.CartItem;

import java.math.BigDecimal;
import java.util.List;

public class CartUpdateResponse {

    private Long cartId;


    private BigDecimal deliveryPrice;

    private BigDecimal totalPrice;

    private BigDecimal totalFinalPrice;

    private List<CartItem> cartItems;

    private Long userId;

    public CartUpdateResponse() {
    }

    public CartUpdateResponse(Long cartId, BigDecimal deliveryPrice, BigDecimal totalPrice, BigDecimal totalFinalPrice, List<CartItem> cartItems, Long userId) {
        this.cartId = cartId;

        this.totalPrice = totalPrice;
        this.cartItems = cartItems;
        this.userId = userId;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }


    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
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
}
