package com.alis.stockservice.model.response;

import java.util.List;

import com.alis.stockservice.model.Category;

public class CategoryQueryResponse {
	private List<Category> categories;

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public CategoryQueryResponse(List<Category> categories) {
		this.categories = categories;

	}

	public CategoryQueryResponse(){

	}
}
