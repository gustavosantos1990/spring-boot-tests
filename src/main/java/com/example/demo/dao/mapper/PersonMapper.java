package com.example.demo.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.Person;

public class PersonMapper implements RowMapper<Person> {
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		Person person = new Person();
		person.setId(rs.getLong("id"));
		person.setName(rs.getString("name"));
		person.setBirth(rs.getDate("birth"));
		person.setAddress(rs.getString("address"));
		person.setPhone(rs.getString("phone"));
		person.setEmail(rs.getString("email"));
		person.setProfession(rs.getString("profession"));
		return person;
	}
}
