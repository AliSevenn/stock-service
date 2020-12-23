package com.alis.stockservice.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alis.stockservice.entity.CategoryEntity;
import com.alis.stockservice.model.Category;
import com.alis.stockservice.repo.CategoryRepository;
import com.alis.stockservice.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ModelMapper modelMapper;

	public List<CategoryEntity> query(List<Long> categoryIds, List<String> names) {

		return categoryRepository.findByCategoryIdInAndNameIn(categoryIds, names);
	}

	public Category findById(Long id) {

		return modelMapper.map(categoryRepository.findById(id), Category.class);
	}

	@Transactional
	public Category save(Category category) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		CategoryEntity categoryEntity = categoryRepository.save(modelMapper.map(category, CategoryEntity.class));
		return modelMapper.map(categoryEntity, Category.class);
	}
}
