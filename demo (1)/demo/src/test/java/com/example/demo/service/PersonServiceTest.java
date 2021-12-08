package com.example.demo.service;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.PaginatedSearchRequest;
import com.example.demo.model.PaginatedSearchResponse;
import com.example.demo.model.Person;

@SpringBootTest
public class PersonServiceTest {
	
	@Autowired
	private PersonService personService;
	
	@Test
	public void allPersonHaveGroupPP() {
		List<Person> persons = personService.findPersonByGroup("PP");
		persons.forEach(person -> assertEquals("PP", person.getGroup()));
	}
	
	@Test
	public void paginatedSearchTest() {
		int limit = 1;
		
		PaginatedSearchRequest paginatedSearchRequest = new PaginatedSearchRequest();
		paginatedSearchRequest.setFilter("PP");
		paginatedSearchRequest.setLimit(limit);
		
		PaginatedSearchResponse<Person> personPaginatedSearch = personService.paginatedSearch(paginatedSearchRequest);
		assertEquals(personPaginatedSearch.getResults().size(), limit);
		assertEquals(personPaginatedSearch.isMore(), true);
		
		personPaginatedSearch.getResults().forEach(person -> assertEquals(person.getGroup(), "PP"));
	}
	
	
	@Test
	public void paginatedSearchTestWithoutFilter() {
		int limit = 1;
		
		PaginatedSearchRequest paginatedSearchRequest = new PaginatedSearchRequest();
		paginatedSearchRequest.setLimit(limit);
		
		PaginatedSearchResponse<Person> personPaginatedSearch = personService.paginatedSearch(paginatedSearchRequest);
		assertEquals(personPaginatedSearch.getResults().size(), 0);
		assertEquals(personPaginatedSearch.isMore(), true);
		
		personPaginatedSearch.getResults().forEach(person -> assertEquals(person.getGroup(), "PP"));
	}
	
	@Test
	public void paginatedSearchTestWithoutFilter2() {
		Person person = new Person();
		Person person2 = personService.pagtedSearch(person);
		
		assertEquals(person, person2);
	}
	
	
}
