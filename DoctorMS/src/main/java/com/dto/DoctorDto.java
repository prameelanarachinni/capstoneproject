package com.dto;

public class DoctorDto {
	private Integer doctor_Id;
	private String doctor_name;
	public DoctorDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DoctorDto(Integer doctor_Id, String doctor_name, String specialization, String expertise) {
		super();
		this.doctor_Id = doctor_Id;
		this.doctor_name = doctor_name;
		this.specialization = specialization;
		this.expertise = expertise;
	}
	public Integer getDoctor_Id() {
		return doctor_Id;
	}
	public void setDoctor_Id(Integer doctor_Id) {
		this.doctor_Id = doctor_Id;
	}
	public String getDoctor_name() {
		return doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
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
	private String specialization;
	private String expertise;

}
