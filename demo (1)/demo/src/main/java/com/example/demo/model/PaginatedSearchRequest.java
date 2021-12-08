package com.example.demo.model;

import java.util.Optional;

public class PaginatedSearchRequest {
	
	private Integer limit;
	
	private Optional<String> filter = Optional.empty();

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public String getFilter() {
		return filter.orElse("");
	}

	public void setFilter(String filter) {
		this.filter = Optional.ofNullable(filter);
	}
}
