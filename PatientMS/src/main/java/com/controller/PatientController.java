package com.controller;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.dto.AppointmentDto;
import com.dto.PatientDto;
import com.exceptions.CustomException;
import com.model.Appointment;
import com.model.Patient;
import com.service.PatientService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@Validated
@RequestMapping("/patients")
public class PatientController {
	@Autowired
	PatientService patientService;
	@Autowired
    private RestTemplate restTemplate;
	 String baseUrl="http://doctor-service/doctors";
	
	@PostMapping("/")
    public ResponseEntity<?> saveNewregister(@Valid @RequestBody Patient patient) {
       Patient patient_= patientService.registerPatient(patient);
        return new ResponseEntity<>(patient_, HttpStatus.OK);
    }
	
	
	
	
	@PostMapping("/login")
    public ResponseEntity<String> login1(@Valid @RequestBody PatientDto patientDto) throws CustomException {
        if (patientDto.getEmail() == null || patientDto.getPassword() == null) {
            throw new CustomException("email and password must not be null.");
        }
        
        boolean isAuthenticated = patientService.authenticate(patientDto);
        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful!");
        } else {
            throw new CustomException("Invalid credentials!");
        }
    }
	@GetMapping("/doctors/{doctor_id}")
	public ResponseEntity<?> getDoctorById(@Valid @Positive @PathVariable("doctor_id") int id) {
	    String url = "http://doctor-service/doctors/" + id;

	    try {
	        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

	        if (response.getStatusCode() == HttpStatus.OK) {
	            return ResponseEntity.ok(response.getBody());
	        } else if (response.getStatusCode() == HttpStatus.NO_CONTENT) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                                 .body("No doctor found with ID " + id);
	        } else {
	            return ResponseEntity.status(response.getStatusCode())
	                                 .body(response.getBody());
	        }
	    } catch (HttpClientErrorException.NotFound e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                             .body("No doctor found with ID " + id);
	    } catch (Exception e) {
	        // Log the exception (optional)
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                             .body("An unexpected error occurred");
	    }
	}
	
	
	









	/*@GetMapping("/doctors/{doctor_id}")
	public ResponseEntity<?> getDoctorById(@Valid @Positive @PathVariable("doctor_id") int Id) {
		String url = "http://doctor-service/doctors/" + Id; 

		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

		if (response.getStatusCode().isSameCodeAs(HttpStatus.OK)) {
			return ResponseEntity.ok(response.getBody());
		} else if (response.getStatusCode().isSameCodeAs(HttpStatus.NO_CONTENT)) {
			return new ResponseEntity<String>("No Doctor found with that id ", HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
	}*/

	// new specilization
	private String buildUrl(String baseUrl, String param, String value) {
		String url = UriComponentsBuilder.fromHttpUrl(baseUrl).queryParam(param, value).toUriString();
		return url;
	}
	
	




	@GetMapping("/doctors")
    public ResponseEntity<?> showDoctorsBySpecialization(@RequestParam("specialization") String specialization) {
        try {
            String url = buildUrl(baseUrl, "specialization", specialization);
            System.out.println(url);

            ResponseEntity<List> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List>() {}
            );

            if (response.getStatusCode().is2xxSuccessful()) {
                if (response.getBody() == null || response.getBody().isEmpty()) {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                         .body("No doctor records found for specialization: " + specialization);
                }
                return ResponseEntity.ok(response.getBody());
            } else {
                return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
            }
        } catch (HttpClientErrorException.NotFound e) {
            // Handle the case where the external service responds with a 404 Not Found
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("No doctors found for specialization: " + specialization);
        } catch (RestClientException e) {
            // Handle other RestClientExceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("An error occurred while fetching doctor records. Please try again later.");
        }
    }


    @PostMapping("/appointments")
    public ResponseEntity<String> bookAppointment(@Valid @RequestBody AppointmentDto appointmentDto) throws CustomException {
        System.out.println("appointments");
    	patientService.bookAppointment(appointmentDto);
    	
    	
        return ResponseEntity.ok("Appointment booked successfully!");
    }
	
	/* @PostMapping("/appointments")
	    public ResponseEntity<String> bookAppointment(@Valid @RequestBody AppointmentDto appointmentDto) {
	        try {
	            patientService.bookAppointment(appointmentDto);
	            return ResponseEntity.ok("Appointment booked successfully!");
	        } catch (CustomException e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	        } catch (Exception e) {
	            // Log and handle other exceptions
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred.");
	        }
	    }*/
	
	
	 /*@GetMapping("/appointments/{patientid}")
	 public List<Appointment> getAppointmentsByPatientId(@PathVariable("patientid") Integer patientId) throws CustomException {
	     if (patientId == null) {
	         throw new CustomException("Patient ID cannot be null");
	     }

	     // Retrieve appointments from the repository or data source
	     List<Appointment> appointments = patientService.findAppointmentsByPatientId(patientId);

	     if (appointments == null || appointments.isEmpty()) {
	         throw new CustomException("No appointments found for patient ID: " + patientId);
	     }

	     return appointments;
	 }*/
	 
	/* @GetMapping("/appointments/{appId}")
	 public List<Appointment> getAppointmentsByAppId(@PathVariable("appId") Integer appId) throws CustomException {
	     if (appId == null) {
	         throw new CustomException("Appointment ID cannot be null");
	     }

	     // Retrieve appointments from the repository or data source
	     List<Appointment> appointments = patientService.findAppointmentsByAppId(appId);

	     if (appointments == null || appointments.isEmpty()) {
	         throw new CustomException("No appointments found for appointment ID: " + appId);
	     }

	     return appointments;
	 }*/

    
    
    
    
    
   
	 

   /* @GetMapping("/appointments/{patient_id}")
    public List<Appointment> getAppointmentsByPatientId(Integer patientId) throws CustomException {
        // Retrieve appointments from the repository or data source
        List<Appointment> appointments = patientService.findAppointmentsByPatientId(patientId);

        if (appointments == null || appointments.isEmpty()) {
            throw new CustomException("No appointments found for patient ID: " + patientId);
        }

        return appointments;
    }*/
   /* @GetMapping("/appointments/{patient_id}")
    public ResponseEntity<List<Appointment>> getAppointmentsByPatientId(@PathVariable("patient_id")int patient_id) throws CustomException{
    	List<Appointment> appointments = patientService.getAppointmentsByPatientId(patient_id);
    	if (appointments.isEmpty()) {
            
	           
            
        	throw new CustomException("No appointments found for patient ID: "+ patient_id);
        }
        return new ResponseEntity<>(appointments,HttpStatus.OK);
    }*/
    
   /* @GetMapping("/appointments")
    public ResponseEntity<List<Appointment>> getAppointments() {
        List<Appointment> appointments = patientService.getAppointmentsForCurrentMonth1();
        return ResponseEntity.ok(appointments);
    }*/
}












	
	




