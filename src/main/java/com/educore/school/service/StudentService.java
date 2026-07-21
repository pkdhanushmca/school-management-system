package com.educore.school.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.educore.school.dto.request.StudentRequestDto;
import com.educore.school.dto.response.StudentResponseDto;
import com.educore.school.specification.StudentFilterDto;

public interface StudentService {

	StudentResponseDto createStudent(StudentRequestDto request);

	List<StudentResponseDto> getAllStudents();

	StudentResponseDto getStudentById(Long id);

	StudentResponseDto updateStudent(Long id, StudentRequestDto request);

	void deleteStudent(Long id);

	Page<StudentResponseDto> getAllStudents(Pageable pageable);

	Page<StudentResponseDto> searchStudents(String keyword, Pageable pageable);

	Page<StudentResponseDto> filterStudents(StudentFilterDto filter, Pageable pageable);

}
