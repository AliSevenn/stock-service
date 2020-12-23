package com.alis.stockservice.model.request;

import java.util.List;

public class CategoryQueryRequest {
	private List<Long> categoryIds;

	private List<String> names;

	public List<Long> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(List<Long> categoryIds) {
		this.categoryIds = categoryIds;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public CategoryQueryRequest(List<Long> categoryIds, List<String> names) {
		this.categoryIds = categoryIds;
		this.names = names;
	}

}
