package com.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;



public class AppointmentDto {
	
	private Integer appId;
	
	@NotNull(message="patientid is missing")
	private Integer patientId;
	@NotNull(message="doctorid is missing")
	private Integer doctorId;
	@NotNull(message=" appointment_date is mandatory")
	@FutureOrPresent
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate appointmentDate;
	public Integer getAppId() {
		return appId;
	}
	public void setAppId(Integer appId) {
		this.appId = appId;
	}
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public Integer getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}
	
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public AppointmentDto(Integer appId, @NotNull(message = "patientid is missing") Integer patientId,
			@NotNull(message = "doctorid is missing") Integer doctorId,
			@NotNull(message = " appointment_date is mandatory")LocalDate appointment_date) {
		super();
		this.appId = appId;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.appointmentDate = appointment_date;
	}
	public AppointmentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
