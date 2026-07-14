package com.educore.school.mapper;

import org.springframework.stereotype.Component;

import com.educore.school.dto.request.StudentRequestDto;
import com.educore.school.dto.response.StudentResponseDto;
import com.educore.school.entity.Student;

@Component
public class StudentMapper {

	public Student toEntity(StudentRequestDto request) {

	    Student student = new Student();

	    student.setFirstName(request.getFirstName());
	    student.setLastName(request.getLastName());
	    student.setDateOfBirth(request.getDateOfBirth());
	    student.setGender(request.getGender());
	    student.setBloodGroup(request.getBloodGroup());
	    student.setEmail(request.getEmail());
	    student.setStudentMobile(request.getStudentMobile());

	    student.setFatherName(request.getFatherName());
	    student.setMotherName(request.getMotherName());
	    student.setFatherOccupation(request.getFatherOccupation());
	    student.setMotherOccupation(request.getMotherOccupation());
	    student.setParentMobile(request.getParentMobile());
	    student.setParentEmail(request.getParentEmail());

	    student.setDoorNo(request.getDoorNo());
	    student.setStreet(request.getStreet());
	    student.setCity(request.getCity());
	    student.setDistrict(request.getDistrict());
	    student.setState(request.getState());
	    student.setPincode(request.getPincode());

	    student.setPreviousSchool(request.getPreviousSchool());
	    student.setAdmissionDate(request.getAdmissionDate());

	    return student;
	}

	public StudentResponseDto toResponse(Student student) {

		StudentResponseDto response = new StudentResponseDto();

		response.setId(student.getId());
		response.setAdmissionNumber(student.getAdmissionNumber());
		response.setFirstName(student.getFirstName());
		response.setLastName(student.getLastName());
		response.setStatus(student.getStatus());
		response.setCreatedAt(student.getCreatedAt());

		return response;
	}
}
