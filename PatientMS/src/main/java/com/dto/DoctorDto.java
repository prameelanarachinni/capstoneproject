package com.dto;

public class DoctorDto {
	private Integer doctorId;
	private String doctorName;
	
	
	private String specialization;
	private String expertise;
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
	public DoctorDto(String doctorName, String specialization, String expertise) {
		super();
		this.doctorName = doctorName;
		this.specialization = specialization;
		this.expertise = expertise;
	}
	public DoctorDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
