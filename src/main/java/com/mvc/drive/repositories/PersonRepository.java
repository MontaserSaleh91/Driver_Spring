package com.mvc.drive.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mvc.drive.models.Persons;

public interface PersonRepository extends CrudRepository <Persons, Long> {
	List<Persons> findAll();
}