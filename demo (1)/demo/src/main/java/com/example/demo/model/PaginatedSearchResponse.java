package com.example.demo.model;

import java.util.List;

public class PaginatedSearchResponse<A> {
	
	
	private List<A> results;
	
	private boolean isMore;

	public List<A> getResults() {
		return results;
	}

	public void setResults(List<A> results) {
		this.results = results;
	}

	public boolean isMore() {
		return isMore;
	}

	public void setMore(boolean isMore) {
		this.isMore = isMore;
	}
}
