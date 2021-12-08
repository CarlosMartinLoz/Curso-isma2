package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonDAO;
import com.example.demo.model.PaginatedSearchRequest;
import com.example.demo.model.PaginatedSearchResponse;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{
	
	@Autowired
	private PersonDAO personDAO;
	
	@Override
	public List<Person> findPersonByGroup(String string) {
		List<Person> people = personDAO.findAll();
		people = this.filterByGroup(people).toList();
		return people;
	}

	@Override
	public PaginatedSearchResponse<Person> paginatedSearch(PaginatedSearchRequest paginatedSearchRequest) {
		List<Person> people = personDAO.findAll();
		PaginatedSearchResponse<Person> response = new PaginatedSearchResponse<Person>();
		
		if(people.size()>paginatedSearchRequest.getLimit()+1) response.setMore(true);
		
		List<Person> filteredPeople = this.filterByGroup(people).limit(paginatedSearchRequest.getLimit()).toList();
		response.setResults(filteredPeople);
		return response;
	}
	
	@Override
	public Person pagtedSearch(Person a) {
		a.setGroup("PODEMOS");
		a = null;
		return a;
	}
}
