package com.alis.stockservice.service;



import java.util.List;

import com.alis.stockservice.entity.CategoryEntity;
import com.alis.stockservice.model.Category;


public interface CategoryService {


	public List<CategoryEntity> query(List<Long> categoryIds, List<String> names);

	public Category findById(Long id);

	public Category save(Category category);

}
