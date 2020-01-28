package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.BookDAO;
import com.example.demo.model.Book;

@RestController
@RequestMapping(value = "/book")
public class BookController {
	
	Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private BookDAO bookDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Book> loadAll() {
		return bookDAO.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Book loadById(@PathVariable("id") Long id) {
		try {
			return bookDAO.findById(id);
		}catch(Exception ex) {
			logger.error(ex.getMessage());
			return new Book();
		}
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Book save(@RequestBody Book book) {
		return bookDAO.save(book);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Book update(@RequestBody Book book) {
		return bookDAO.update(book);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Long delete (@PathVariable("id") Long id) {
		return bookDAO.delete(id);
	}
	
}
