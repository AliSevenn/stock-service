package com.alis.stockservice.rest.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alis.stockservice.model.Category;
import com.alis.stockservice.model.request.CategoryQueryRequest;
import com.alis.stockservice.model.response.CategoryQueryResponse;
import com.alis.stockservice.service.CategoryService;
import org.springframework.ui.ModelMap;

@Component
public class CategoryBusinessService {

	@Autowired
	CategoryService categoryService;
	@Autowired
	ModelMapper modelMapper;

	public CategoryQueryResponse query(CategoryQueryRequest request) {
		var categories = categoryService.query(request.getCategoryIds(), request.getNames());
		var response = new CategoryQueryResponse(new ArrayList<Category>());
		categories.forEach(c -> {
			var category = new Category();
			category.setName(c.getName());
			category.setCategoryId(c.getCategoryId());
			response.getCategories().add(category);
		});
		return response;
	}
}
