package com.educore.school.service.impl;

import org.springframework.stereotype.Service;

import com.educore.school.dto.request.StudentRequestDto;
import com.educore.school.dto.response.StudentResponseDto;
import com.educore.school.entity.Student;
import com.educore.school.enums.StudentStatus;
import com.educore.school.exception.DuplicateResourceException;
import com.educore.school.mapper.StudentMapper;
import com.educore.school.repository.StudentRepository;
import com.educore.school.service.StudentService;
import com.educore.school.util.AdmissionNumberGenerator;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentServiceImpl implements StudentService {

	private final StudentRepository studentRepository;
	private final StudentMapper studentMapper;

	@Override
	public StudentResponseDto createStudent(StudentRequestDto request) {

		if (request.getEmail() != null && !request.getEmail().isBlank()
				&& studentRepository.existsByEmail(request.getEmail())) {

			throw new DuplicateResourceException("Email already exists");
		}
		Student student = studentMapper.toEntity(request);
		student.setStatus(StudentStatus.ACTIVE);

		// First Save
		Student savedStudent = studentRepository.save(student);

		// Generate Admission Number
		savedStudent.setAdmissionNumber(AdmissionNumberGenerator.generate(savedStudent.getId()));
		
		// Update
		savedStudent = studentRepository.save(savedStudent);

		return studentMapper.toResponse(savedStudent);
	}
	
}
