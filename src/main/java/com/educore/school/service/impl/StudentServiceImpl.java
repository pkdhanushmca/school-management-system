package com.educore.school.service.impl;

import org.springframework.stereotype.Service;

import com.educore.school.dto.request.StudentRequestDto;
import com.educore.school.dto.response.StudentResponseDto;
import com.educore.school.mapper.StudentMapper;
import com.educore.school.repository.StudentRepository;
import com.educore.school.service.StudentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

	private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

	@Override
	public StudentResponseDto createStudent(StudentRequestDto request) {
		return null;
	}

}
