package com.alis.stockservice.service.Impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alis.stockservice.entity.ProductEntity;
import com.alis.stockservice.model.Product;
import com.alis.stockservice.repo.ProductRepository;
import com.alis.stockservice.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	ModelMapper modelMapper;

	public List<ProductEntity> query(List<Long> productIds, List<String> names) {
		return productRepository.findByProductIdInAndNameIn(productIds, names);
	}

	public Product findById(Long id) {
		Product product = modelMapper.map(productRepository.findById(id).get(), Product.class);
		return 	product;
	}

	public ProductEntity findByProductId(Long id) {
		return productRepository.findByProductId(id);
	}

	@Transactional
	public Product save(Product product) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ProductEntity productEntity1 = modelMapper.map(product, ProductEntity.class);
		ProductEntity productEntity = productRepository.save(productEntity1);
		return modelMapper.map(productEntity, Product.class);
	}
}
