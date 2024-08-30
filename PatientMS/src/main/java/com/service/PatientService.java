package com.service;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dto.AppointmentDto;
import com.dto.DoctorDto;
import com.dto.PatientDto;
import com.exceptions.CustomException;
import com.google.common.base.Optional;
import com.model.Appointment;
import com.model.Patient;
import com.repository.AppointmentRepository;
import com.repository.PatientRepository;

import jakarta.validation.Valid;

@Service

public class PatientService {
	@Autowired
	PatientRepository patientRepository;
	@Autowired
	AppointmentRepository appointmentRepository;
	@Autowired
    private RestTemplate restTemplate;
	
	public Patient registerPatient(@Valid Patient patient) {
		Patient patient_=patientRepository.save(patient);
		return patientRepository.save(patient_);
	}
	public boolean authenticate(PatientDto patientDto) {
        Optional<Patient> patient = patientRepository.findByEmail(patientDto.getEmail());
        return patient.isPresent() && patient.get().getPassword().equals(patientDto.getPassword());
    }
	
	 public ResponseEntity<?> getDoctorsBySpecialization(String specialization)throws CustomException {
        String url = "http://doctor-service/" + specialization;
        ResponseEntity<List> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List>() {}
        );
        if (response.getStatusCode().isSameCodeAs(HttpStatus.OK) && response.getBody() != null && !response.getBody().isEmpty()) {
            return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
        } else {
            throw new CustomException("No doctor record found for specialization: " + specialization);}}
	 /*public void bookAppointment(AppointmentDto appointmentDto) throws CustomException {
		    // Build URL for doctor service and get the response
		    String doctorUrl = "http://doctor-service/doctors/" + appointmentDto.getDoctorId();
		    ResponseEntity<DoctorDto> doctorResponse = restTemplate.getForEntity(doctorUrl, DoctorDto.class);

		    if (doctorResponse.getStatusCode() == HttpStatus.OK) {
		        DoctorDto doctor = doctorResponse.getBody();
		        if (doctor == null) {
		            throw new CustomException("No doctor found with ID " + appointmentDto.getDoctorId());
		        }

		        // Example validation for patient ID
		        boolean isPatientValid = checkPatientValidity(appointmentDto.getPatientId());
		        if (!isPatientValid) {
		            throw new CustomException("Invalid Patient ID " + appointmentDto.getPatientId());
		        }

		        // Example validation for appointment date
		        if (appointmentDto.getAppointmentDate() == null || appointmentDto.getAppointmentDate().isBefore(LocalDate.now())) {
		            throw new CustomException("Appointment date cannot be null or in the past.");
		        }

		        // Check if an appointment already exists for the patient with the same doctor and date
		        boolean isAppointmentAlreadyBooked = appointmentRepository.existsByPatientIdAndDoctorIdAndAppointmentDate(
		            appointmentDto.getPatientId(),
		            appointmentDto.getDoctorId(),
		            appointmentDto.getAppointmentDate()
		        );
		        if (isAppointmentAlreadyBooked) {
		            throw new CustomException("Appointment is already booked for this date.");
		        }

		        // Save the appointment
		        Appointment appointment = new Appointment();
		        appointment.setPatientId(appointmentDto.getPatientId());
		        appointment.setDoctorId(appointmentDto.getDoctorId());
		        appointment.setAppointmentDate(appointmentDto.getAppointmentDate());
		        appointmentRepository.save(appointment);
		    } else {
		        throw new CustomException("Invalid Doctor ID " + appointmentDto.getDoctorId());
		    }
		}
	private boolean checkPatientValidity(Integer patientId) {
		// TODO Auto-generated method stub
		return false;*/
	

    
	 public void bookAppointment(AppointmentDto appointmentDto) throws CustomException {
		    String doctorUrl = "http://doctor-service/doctors/" + appointmentDto.getDoctorId();
		    ResponseEntity<DoctorDto> doctorResponse = restTemplate.getForEntity(doctorUrl, DoctorDto.class);

		    if (doctorResponse.getStatusCode() == HttpStatus.OK) {
		        DoctorDto doctor = doctorResponse.getBody();
		        if (doctor == null) {
		            throw new CustomException("No doctor found with ID " + appointmentDto.getDoctorId());
		        }

		        // Example validation for patient ID (adjust as necessary)
		        boolean isPatientValid = checkPatientValidity(appointmentDto.getPatientId());
		        if (!isPatientValid) {
		            throw new CustomException("Invalid Patient ID " + appointmentDto.getPatientId());
		        }

		        // Example validation for appointment date
		        if (appointmentDto.getAppointmentDate() == null || appointmentDto.getAppointmentDate().isBefore(LocalDate.now())) {
		            throw new CustomException("Appointment date cannot be null or in the past.");
		        }

		        // Save the appointment
		        Appointment appointment = new Appointment();
		        appointment.setPatientId(appointmentDto.getPatientId());
		        appointment.setDoctorId(appointmentDto.getDoctorId());
		        appointment.setAppointmentDate(appointmentDto.getAppointmentDate());
		        appointmentRepository.save(appointment);
		    } else {
		        throw new CustomException("Invalid Doctor ID " + appointmentDto.getDoctorId());
		    }
		}

		// Example method for checking patient validity
		private boolean checkPatientValidity(Integer integer) {
		    // Implement the logic to validate patient ID
		    return true; // Placeholder; replace with actual logic
		}
		/*public List<Appointment> getAppointmentsByPatientId(int patient_id) {
			// TODO Auto-generated method stub
			return null;
		}*/
		public List<Appointment> findAppointmentsByPatientId(int patientId) {
			// TODO Auto-generated method stub
			return null;
		}
		


   /* public void bookAppointment(AppointmentDto appointmentDto) throws CustomException {
        
        String doctorUrl = "http://doctor-service/doctors/" + appointmentDto.getDoctorId();
       System.out.println(doctorUrl);
        ResponseEntity<DoctorDto> doctorResponse = restTemplate.getForEntity(doctorUrl, DoctorDto.class);

        if (doctorResponse.getStatusCode() == HttpStatus.OK) {
        	System.out.println("Soma");
            Appointment appointment = new Appointment();
            appointment.setPatientId(appointmentDto.getPatientId());
            appointment.setDoctorId(appointmentDto.getDoctorId());
            appointment.setAppointmentDate(appointmentDto.getAppointmentDate());
            appointmentRepository.save(appointment);
        } else {
            throw new CustomException("Invalid Doctor ID");
        }*/
    

    /*public List<Appointment> getAppointmentsForCurrentMonth1() {
       LocalDate now = LocalDate.now();
       LocalDate startOfMonth = now.withDayOfMonth(1);
       LocalDate endOfMonth = now.withDayOfMonth(now.lengthOfMonth());
       return appointmentRepository.findByAppointmentDateBetween(startOfMonth, endOfMonth);*/
        
      
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       /*  List<Appointment> appointments = appointmentRepository.findByAppointmentDateBetween(startOfMonth, endOfMonth);
        return appointments.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private AppointmentDto convertToDto(Appointment appointment) {
        AppointmentDto dto = new AppointmentDto();
        dto.setAppId(appointment.getAppId());
        dto.setPatientId(appointment.getPatientId());
        dto.setDoctorId(appointment.getDoctorId());
        dto.setAppointmentDate(appointment.getAppointmentDate());
        return dto;*/
    }
    
	/*public ResponseEntity<?> getDoctorById(String id) {
		// TODO Auto-generated method stub
		String doctorUrl = "http://doctor-service/"+ id;
        ResponseEntity<List> response = restTemplate.getForEntity(doctorUrl, List.class);
        if (response.getStatusCode().isSameCodeAs(HttpStatus.OK)) {
			return response;
	} else if (response.getStatusCode().isSameCodeAs(HttpStatus.NO_CONTENT)) {
		return new ResponseEntity<String>("No doctor record found", HttpStatus.NOT_FOUND);
		}
		return null;
	
	}*/
	
		


    
	




	
	

