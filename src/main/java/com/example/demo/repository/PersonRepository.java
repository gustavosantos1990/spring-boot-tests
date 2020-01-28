package com.example.demo.repository;


import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Person;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findByName(String name);
    
}