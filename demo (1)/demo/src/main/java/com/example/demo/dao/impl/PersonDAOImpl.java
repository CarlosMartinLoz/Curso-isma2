package com.example.demo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.dao.PersonDAO;
import com.example.demo.model.Person;

@Repository
public class PersonDAOImpl implements PersonDAO{
	
	@Override
	public List<Person> findAll(){
		List<Person> people = new ArrayList<>();
		for(int i = 0; i<8;i++) {
			Person person = new Person();
			person.setGroup("PP");
			people.add(person);
		}
		Person person = new Person();
		person.setGroup("ddd");
		people.add(person);
		
		return people;
	}
}
