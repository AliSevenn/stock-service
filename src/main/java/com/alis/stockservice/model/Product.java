package com.alis.stockservice.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class Product extends Base {

    private String name;
    private BigDecimal price;
    private Category category;
    private Long productId;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }



    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
