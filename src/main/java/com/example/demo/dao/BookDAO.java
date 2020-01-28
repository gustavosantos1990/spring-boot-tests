package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.dao.mapper.BookMapper;
import com.example.demo.model.Book;

@Component
public class BookDAO {

	@Autowired
	@Qualifier("financialJT")
	private JdbcTemplate jdbcTemplate;

	private final String QUERY_FIND_ALL = "SELECT * FROM book;";
	private final String QUERY_FIND_BY_ID = "SELECT * FROM book WHERE id = ?;";
	private final String QUERY_SAVE = "INSERT INTO book (name) VALUES (?);";
	private final String QUERY_UPDATE = "UPDATE book SET name = ? WHERE id = ?;";
	private final String QUERY_DELETE = "DELETE FROM book WHERE id = ?;";

	public List<Book> findAll() {
		return jdbcTemplate.query(QUERY_FIND_ALL, new BookMapper());
	}

	public Book findById(Long id) {
		return jdbcTemplate.queryForObject(QUERY_FIND_BY_ID, new Object[] { id }, new BookMapper());
	}

	public Book save(Book book) {
		jdbcTemplate.update(QUERY_SAVE, book.loadSaveParameters());
		return book;
	}
	
	public Book update(Book book) {
		jdbcTemplate.update(QUERY_UPDATE, book.loadUpdateParameters());
		return book;
	}
	
	public Long delete(Long id) {
		jdbcTemplate.update(QUERY_DELETE, new Object[] { id });
		return id;
	}

}
