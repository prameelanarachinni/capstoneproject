package com.model;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="patient")
public class Patient {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="patient_id")
	private Integer patientId;
	
		

	 
	


	

	@Column(name="patient_name")
	@NotEmpty(message="name  is missing")
	private String patient_name;
	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Patient(Integer patient_Id, @NotEmpty(message = "name  is missing") String patient_name,
			@NotEmpty(message = "gender  is manadatory") String gender,
			@NotNull(message = "date_of_birth is missing") @NotNull(message = "date_of_birth is missing") LocalDate date_of_birth,
			@NotEmpty(message = "address  is missing") String address,
			@NotEmpty(message = "email  is missing") String email,
			@NotEmpty(message = "password  is manadatory") String password) {
		super();
		this.patientId = patient_Id;
		this.patient_name = patient_name;
		this.gender = gender;
		this.date_of_birth = date_of_birth;
		this.address = address;
		this.email = email;
		this.password = password;
	}


	public Integer getPatient_Id() {
		return patientId;
	}


	public void setPatient_Id(Integer patient_Id) {
		this.patientId = patient_Id;
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


	public @NotNull(message = "date_of_birth is missing") LocalDate getDate_of_birth() {
		return date_of_birth;
	}


	public void setDate_of_birth(@NotNull(message = "date_of_birth is missing") LocalDate date_of_birth) {
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


	@Column(name="gender")
	@NotEmpty(message="gender  is manadatory")
	private String gender;
	
	@Column(name="date_of_birth")
    @NotNull(message="date_of_birth is missing")
	private LocalDate date_of_birth;
	

	@Column(name="address")
	@NotEmpty(message="address  is missing")
	private String address;
	

	@Column(name="email")
	@NotEmpty(message="email  is missing")
	private String email;
	

	@Column(name="password")
	@NotEmpty(message="password  is manadatory")
	private String password;
}
	

	




	


	
	




