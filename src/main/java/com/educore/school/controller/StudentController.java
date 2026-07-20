package com.educore.school.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

//	@GetMapping
//	public ResponseEntity<ApiResponse<List<StudentResponseDto>>> getAllStudents() {
//
//		List<StudentResponseDto> students = studentService.getAllStudents();
//
//		ApiResponse<List<StudentResponseDto>> response = new ApiResponse<>(true, "Students retrieved successfully",
//				students);
//
//		return ResponseEntity.ok(response);
//	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<StudentResponseDto>> getStudentById(@PathVariable Long id) {

		StudentResponseDto response = studentService.getStudentById(id);

		ApiResponse<StudentResponseDto> apiResponse = new ApiResponse<>(true, "Student retrieved successfully",
				response);

		return ResponseEntity.ok(apiResponse);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse<StudentResponseDto>> updateStudent(@PathVariable Long id,
			@Valid @RequestBody StudentRequestDto request) {

		StudentResponseDto response = studentService.updateStudent(id, request);

		ApiResponse<StudentResponseDto> apiResponse = new ApiResponse<>(true, "Student updated successfully", response);

		return ResponseEntity.ok(apiResponse);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<Void>> deleteStudent(@PathVariable Long id) {

		studentService.deleteStudent(id);

		ApiResponse<Void> response = new ApiResponse<>(true, "Student deleted successfully", null);

		return ResponseEntity.ok(response);
	}

	@GetMapping
	public ResponseEntity<ApiResponse<Page<StudentResponseDto>>> getAllStudents(
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "firstName") String sortBy,
			@RequestParam(defaultValue = "asc") String direction) {

		Sort sort = direction.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

		Pageable pageable = PageRequest.of(page, size, sort);

		Page<StudentResponseDto> response = studentService.getAllStudents(pageable);

		ApiResponse<Page<StudentResponseDto>> apiResponse = new ApiResponse<>(true, "Students retrieved successfully",
				response);

		return ResponseEntity.ok(apiResponse);
	}

	@GetMapping("/search")
	public ResponseEntity<ApiResponse<Page<StudentResponseDto>>> searchStudents(@RequestParam String keyword,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "firstName") String sortBy,
			@RequestParam(defaultValue = "asc") String direction) {

		Sort sort = direction.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

		Pageable pageable = PageRequest.of(page, size, sort);

		Page<StudentResponseDto> response = studentService.searchStudents(keyword, pageable);

		ApiResponse<Page<StudentResponseDto>> apiResponse = new ApiResponse<>(true, "Students retrieved successfully",
				response);

		return ResponseEntity.ok(apiResponse);
	}

}
