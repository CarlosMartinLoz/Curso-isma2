package com.example.demo.service;

import java.util.List;
import java.util.stream.Stream;

import com.example.demo.model.PaginatedSearchRequest;
import com.example.demo.model.PaginatedSearchResponse;
import com.example.demo.model.Person;

public interface PersonService{
	
	List<Person> findPersonByGroup(String string);

	PaginatedSearchResponse<Person> paginatedSearch(PaginatedSearchRequest paginatedSearchRequest);
	
	default Stream<Person> filterByGroup(List<Person> people) {
		return null;
	}

	Person pagtedSearch(Person a);
	
}
