package com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="doctor")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="doctor_id")
	private Integer doctorId;
	
	@Column(name="doctor_name")
	@NotEmpty(message="name  is missing")
	private String doctorName;
	
	@Column(name="specialization")
	@NotEmpty(message="specialization  is manadatory")
	@Size(min=2, max=20, message="author should between 2 to 20 characters")
	private String specialization;
	
	@Column(name="expertise")
    @NotNull(message="expertise is missing")
	private String expertise;
	
	

	

	
	

	
	

	public Doctor(@NotEmpty(message = "name  is missing") String doctorName,
			@NotEmpty(message = "specialization  is manadatory") @Size(min = 2, max = 20, message = "author should between 2 to 20 characters") String specialization,
			@NotNull(message = "expertise is missing") String expertise) {
		super();
		this.doctorName = doctorName;
		this.specialization = specialization;
		this.expertise = expertise;
	}

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	

	
	
	

}



	

	





