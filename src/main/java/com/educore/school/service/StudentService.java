package com.educore.school.service;

import com.educore.school.dto.request.StudentRequestDto;
import com.educore.school.dto.response.StudentResponseDto;

public interface StudentService {

	StudentResponseDto createStudent(StudentRequestDto request);
	
}
