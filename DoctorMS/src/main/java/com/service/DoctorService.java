 package com.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Doctor;
import com.repository.DoctorRepository;

@Service
public class DoctorService {
	
	@Autowired
	DoctorRepository doctorRepository;

	public List<Doctor> listAllDoctors() {
		// TODO Auto-generated method stub
		return doctorRepository.findAll();
	}
	

	public List<Doctor> listDoctorsBySpecialization(String specialization) {
		// TODO Auto-generated method stub
		return doctorRepository.findAllByspecialization(specialization);
	}


	public Doctor DoctorBydoctorId(Integer doctorid) {
		// TODO Auto-generated method stub
		return doctorRepository.findByDoctorId(doctorid);
	}
	
}

	

	







	
	







	








