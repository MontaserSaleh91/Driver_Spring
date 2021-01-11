package com.mvc.drive.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mvc.drive.models.Licenses;
import com.mvc.drive.models.Persons;
import com.mvc.drive.repositories.PersonRepository;

@Service
public class PersonService {
	private LiceService liceService;
	  private final PersonRepository personRepository;
	    
	    public PersonService(PersonRepository personRepository) {
	        this.personRepository = personRepository;
	    }
	    // returns all the Persons
	    public List<Persons> findAll() {
	        return personRepository.findAll();
	    }
	    // creates a Persons
	    public Persons createPerson(Persons p) {
	        return personRepository.save(p);
	    }
	    public Persons findPerson(Long id) {
	        Optional<Persons> optionalPerson = personRepository.findById(id);
	        if(optionalPerson.isPresent()) {
	            return optionalPerson.get();
	        } else {
	            return null;
	        }
	    }
	    
	 
}
