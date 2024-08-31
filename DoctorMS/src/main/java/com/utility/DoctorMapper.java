package com.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dto.DoctorDto;
import com.model.Doctor;

public class DoctorMapper {
	static Logger logger = LoggerFactory.getLogger(DoctorMapper.class);
	public static DoctorDto toDto(Doctor doctor) {
		logger.debug("entity instance of doctorclas to dto instance");
		return new DoctorDto(doctor.getDoctorId(), doctor.getDoctorName(),doctor.getSpecialization(),doctor.getExpertise());
	}
	public static Doctor toEntity(DoctorDto doctor_) {
		logger.debug("entity instance of doctorclas to Entity instance");
		return new Doctor(doctor_.getDoctor_name(),doctor_.getSpecialization(),doctor_.getExpertise());
	}
		
	}


