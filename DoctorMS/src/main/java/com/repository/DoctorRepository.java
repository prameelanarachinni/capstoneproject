package com.repository;




import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.Doctor;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
	
	public List<Doctor> findAll();

    public List <Doctor> findAllByspecialization(String specialization);

	

	
	public Doctor findByDoctorId(Integer doctorid);
}

















	









