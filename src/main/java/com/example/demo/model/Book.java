package com.example.demo.model;

import org.springframework.jdbc.core.PreparedStatementSetter;

public class Book {

    private Long id;
    private String name;

    public Book() {
    }

    public Book(String name) {
        this.name = name;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + "]";
	}

	public Object[] loadSaveParameters() {
		return new Object[] {this.name}; 
	}
	
	public Object[] loadUpdateParameters() {
		return new Object[] {this.name, this.id}; 
	}

}
