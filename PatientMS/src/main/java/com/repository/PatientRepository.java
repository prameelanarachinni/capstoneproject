package com.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.google.common.base.Optional;
import com.model.Patient;


public interface PatientRepository extends CrudRepository<Patient, Integer> {
	public Optional<Patient> findByEmail(String email);

	

	

	
	
		
	}






	
	





		
	





