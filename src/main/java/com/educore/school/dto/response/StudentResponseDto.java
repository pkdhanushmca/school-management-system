package com.educore.school.dto.response;

import java.time.LocalDateTime;

import com.educore.school.enums.StudentStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDto {

	private Long id;

	private String admissionNumber;

	private String firstName;

	private String lastName;

	private StudentStatus status;

	private LocalDateTime createdAt;
}
