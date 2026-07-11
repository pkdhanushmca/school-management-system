package com.educore.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educore.school.dto.ApiResponse;

@RestController
@RequestMapping("/api/v1")
public class HealthController {

	@GetMapping("/health")
	public ResponseEntity<ApiResponse<String>> health() {
		ApiResponse<String> apiResponse = new ApiResponse<>(true, "Application is running successfully",
				"School Management API is Up");
		return ResponseEntity.ok(apiResponse);
	}

}
