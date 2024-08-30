package com.model;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name="appointment")
public class Appointment  {
	
	 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="app_id")
	private Integer appId;
	
	
	
	@Column(name="patient_id")
	private Integer patientId;
	
	
	@Column(name="doctor_id")
	private Integer doctorId;
	
	
	@Column(name="appointment_date")
    
	private LocalDate appointmentDate;


	public Integer getAppId() {
		return appId;
	}


	public void setAppId(Integer appId) {
		this.appId = appId;
	}



	


	public Integer getDoctorId() {
		return doctorId;
	}


	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}


	


	public Appointment(Integer patientId, Integer doctorId,
			@NotNull(message = " appointment_date is missing") LocalDate appointmentDate) {
		super();
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.appointmentDate = appointmentDate;
	}


	public Integer getPatientId() {
		return patientId;
	}


	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}


	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}



	public void setAppointmentDate(LocalDate localDate) {
		this.appointmentDate = localDate;
	}


	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	


	
}
	
	
	
	
	
	
	


