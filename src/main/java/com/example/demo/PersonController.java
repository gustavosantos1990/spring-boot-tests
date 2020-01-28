package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/person")
public class PersonController {
	
	Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	//@Autowired
	//private PersonRepository personRepository;
	
	@Autowired
	private PersonDAO personDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Person> loadAll() {
		return personDAO.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Person loadById(@PathVariable("id") Long id) {
		try {
			return personDAO.findById(id);
		}catch(Exception ex) {
			logger.error(ex.getMessage());
			return new Person();
		}
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Person save(@RequestBody Person person) {
		return personDAO.save(person);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Person update(@RequestBody Person person) {
		return personDAO.update(person);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Long delete (@PathVariable("id") Long id) {
		return personDAO.delete(id);
	}
	
	/*@RequestMapping(method = RequestMethod.GET)
	public Iterable<Person> loadAll() {
		return personRepository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Person loadById(@PathVariable("id") Long id) {
		try {
			return personRepository.findById(id).get();
		}catch(Exception ex) {
			logger.error(ex.getMessage());
			return new Person();
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Person save(@RequestBody Person person) {
		return personRepository.save(person);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Person update(@RequestBody Person person) {
		return personRepository.save(person);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Long delete (@PathVariable("id") Long id) {
		personRepository.deleteById(id);
		return id;
	}*/
}
