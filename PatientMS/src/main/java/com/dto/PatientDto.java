package com.dto;

import java.time.LocalDate;

public class PatientDto {
	private Integer patient_Id;
	private String patient_name;
	private String gender;
	private LocalDate date_of_birth;
	private String address;
	public PatientDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PatientDto(Integer patient_Id, String patient_name, String gender, LocalDate date_of_birth, String address,
			String email, String password) {
		super();
		this.patient_Id = patient_Id;
		this.patient_name = patient_name;
		this.gender = gender;
		this.date_of_birth = date_of_birth;
		this.address = address;
		this.email = email;
		this.password = password;
	}
	public Integer getPatient_Id() {
		return patient_Id;
	}
	public void setPatient_Id(Integer patient_Id) {
		this.patient_Id = patient_Id;
	}
	public String getPatient_name() {
		return patient_name;
	}
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(LocalDate date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String email;
	private String password;
}
	