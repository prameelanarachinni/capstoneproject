package com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.model.Appointment;
import com.model.Patient;

public interface AppointmentRepository extends CrudRepository<Patient, Integer> {

public	void save(Appointment appointment);





	

	
}
