package com.educore.school.service;

import java.util.List;

import com.educore.school.dto.request.StudentRequestDto;
import com.educore.school.dto.response.StudentResponseDto;

public interface StudentService {

	StudentResponseDto createStudent(StudentRequestDto request);
	
	List<StudentResponseDto> getAllStudents();
	
	StudentResponseDto getStudentById(Long id);
	
	StudentResponseDto updateStudent(Long id, StudentRequestDto request);
	
	void deleteStudent(Long id);
	
}
