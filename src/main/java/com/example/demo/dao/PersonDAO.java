package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.dao.mapper.PersonMapper;
import com.example.demo.model.Person;

@Component
public class PersonDAO {

	@Autowired
	@Qualifier("storeJT")
	private JdbcTemplate jdbcTemplate;

	private final String QUERY_FIND_ALL = "SELECT * FROM person;";
	private final String QUERY_FIND_BY_ID = "SELECT * FROM person WHERE id = ?;";
	private final String QUERY_SAVE = "INSERT INTO person (name, birth, address, phone, email, profession) VALUES (?, ?, ?, ?, ?, ?);";
	private final String QUERY_UPDATE = "UPDATE person SET name = ?, birth = ?, address = ?, phone = ?, email = ?, profession = ? WHERE id = ?;";
	private final String QUERY_DELETE = "DELETE FROM person WHERE id = ?;";

	public List<Person> findAll() {
		return jdbcTemplate.query(QUERY_FIND_ALL, new PersonMapper());
	}

	public Person findById(Long id) {
		return jdbcTemplate.queryForObject(QUERY_FIND_BY_ID, new Object[] { id }, new PersonMapper());
	}

	public Person save(Person person) {
		jdbcTemplate.update(QUERY_SAVE, person.loadSaveParameters());
		return person;
	}
	
	public Person update(Person person) {
		jdbcTemplate.update(QUERY_UPDATE, person.loadUpdateParameters());
		return person;
	}
	
	public Long delete(Long id) {
		jdbcTemplate.update(QUERY_DELETE, new Object[] { id });
		return id;
	}

}
