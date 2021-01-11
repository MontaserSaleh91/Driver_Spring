package com.mvc.drive.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mvc.drive.models.Licenses;

public interface LicenRepository extends CrudRepository <Licenses, Long> {
	List<Licenses> findAll();
}
