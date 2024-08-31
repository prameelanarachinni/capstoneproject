package com.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static  Logger logger = LoggerFactory.getLogger(DoctorController.class);
	
	
	@GetMapping("/")
	public List<Doctor> showAllDoctors(){
		List<Doctor> doctorList=doctorService.listAllDoctors();
		return doctorList;
	}
	
	@GetMapping
    public ResponseEntity<?> getDoctorsBySpecialization(@RequestParam String specialization) throws CustomException {
        logger.info("Received request to get doctors with specialization: {}", specialization);

        List<Doctor> doctors;
        try {
            doctors = doctorService.listDoctorsBySpecialization(specialization);
        } catch (Exception e) {
            logger.error("Error occurred while fetching doctors: {}", e.getMessage(), e);
            throw new CustomException("Error occurred while fetching doctors for specialization: " + specialization);
        }

        if (doctors == null || doctors.isEmpty()) {
            logger.warn("No doctors found for specialization: {}", specialization);
            throw new CustomException("No doctors found for specialization: " + specialization);
        }

        logger.info("Found {} doctors for specialization: {}", doctors.size(), specialization);
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }
	
	@GetMapping("/{doctorid}")
    public ResponseEntity<?> showDoctorByDoctorId(@PathVariable("doctorid") Integer doctorid) throws CustomException {
        logger.info("Received request to get doctor with ID: {}", doctorid);

        Doctor doctor;
        try {
            doctor = doctorService.DoctorBydoctorId(doctorid);
        } catch (Exception e) {
            logger.error("Error occurred while fetching doctor with ID {}: {}", doctorid, e.getMessage(), e);
            throw new CustomException("Error occurred while fetching doctor with ID: " + doctorid);
        }

        if (doctor == null) {
            logger.warn("No record found for doctor ID: {}", doctorid);
            throw new CustomException("No record found for doctor ID: " + doctorid);
        }

        logger.info("Found doctor with ID: {}", doctorid);
        return new ResponseEntity<>(doctor, HttpStatus.OK);
    }
}


















/* @GetMapping
public ResponseEntity<?> getDoctorsBySpecialization(@RequestParam String specialization) throws CustomException {
    List<Doctor> doctors = doctorService.listDoctorsBySpecialization(specialization);
    if (doctors == null || doctors.isEmpty()) {
        
       
                             
    	throw new CustomException("No doctors found for specialization "+ specialization);
    }
    return new ResponseEntity<>(doctors,HttpStatus.OK);
}*/
	
	
   /*@GetMapping("/{doctorid}")
	public ResponseEntity<?> showDoctorByDoctorId(@PathVariable("doctorid") Integer doctorid) throws CustomException{
		Doctor doctor=doctorService.DoctorBydoctorId(doctorid);	
		if(doctor==null  ) {
			throw new CustomException("No record found from doctorid "+doctorid);
		}
		return new ResponseEntity<>(doctor,HttpStatus.OK);
	}*/

	
	