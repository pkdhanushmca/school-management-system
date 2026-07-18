package com.educore.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educore.school.dto.ApiResponse;
import com.educore.school.dto.request.StudentRequestDto;
import com.educore.school.dto.response.StudentResponseDto;
import com.educore.school.service.StudentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

	private final StudentService studentService;

	@PostMapping
	public ResponseEntity<ApiResponse<StudentResponseDto>> createStudent(
			@Valid @RequestBody StudentRequestDto request) {

		StudentResponseDto response = studentService.createStudent(request);
		ApiResponse<StudentResponseDto> apiResponse = new ApiResponse<>(true, "Student created successfully", response);

		return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
	}

}
