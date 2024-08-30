package com.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exceptions.CustomException;
import com.model.Doctor;
import com.service.DoctorService;

@RestController
@Validated
@RequestMapping("/doctors")
public class DoctorController {
	
	@Autowired
	DoctorService doctorService;
	
	/*@GetMapping("/")
	public String showAllDoctors() {
		return "Doctor information coming up...";
	}*/
	@GetMapping("/")
	public List<Doctor> showAllDoctors(){
		List<Doctor> doctorList=doctorService.listAllDoctors();
		return doctorList;
	}
	 @GetMapping
	    public ResponseEntity<?> getDoctorsBySpecialization(@RequestParam String specialization) throws CustomException {
	        List<Doctor> doctors = doctorService.listDoctorsBySpecialization(specialization);
	        if (doctors == null || doctors.isEmpty()) {
	            
	           
	                                 
	        	throw new CustomException("No doctors found for specialization "+ specialization);
	        }
	        return new ResponseEntity<>(doctors,HttpStatus.OK);
	    }
	
	
	
   @GetMapping("/{doctorid}")
	public ResponseEntity<?> showDoctorByDoctorId(@PathVariable("doctorid") Integer doctorid) throws CustomException{
		Doctor doctor=doctorService.DoctorBydoctorId(doctorid);	
		if(doctor==null  ) {
			throw new CustomException("No record found from doctorid "+doctorid);
		}
		return new ResponseEntity<>(doctor,HttpStatus.OK);
	}
}
	
	