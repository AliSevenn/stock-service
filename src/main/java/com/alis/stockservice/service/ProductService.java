package com.alis.stockservice.service;

import java.util.List;

import com.alis.stockservice.entity.ProductEntity;
import com.alis.stockservice.model.Product;

public interface ProductService {

	public List<ProductEntity> query(List<Long> productIds, List<String> names);

	public Product findById(Long id);

	public ProductEntity findByProductId(Long id);

	public Product save(Product entity);

}
