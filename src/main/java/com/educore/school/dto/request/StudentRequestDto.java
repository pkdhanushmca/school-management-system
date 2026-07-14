package com.educore.school.dto.request;

import java.time.LocalDate;

import com.educore.school.enums.BloodGroup;
import com.educore.school.enums.Gender;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDto {

	@NotBlank(message = "First name is required")
	@Size(min = 3, max = 50, message = "First name must be between 3 and 50 characters")
	private String firstName;

	@Size(max = 50, message = "Last name cannot exceed 50 characters")
	private String lastName;

	@NotNull(message = "Date of birth is required")
	@Past(message = "Date of birth must be in the past")
	private LocalDate dateOfBirth;

	@NotNull(message = "Gender is required")
	private Gender gender;

	@NotNull(message = "Blood group is required")
	private BloodGroup bloodGroup;

	@Email(message = "Invalid email format")
	private String email;

	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid student mobile number")
	private String studentMobile;

	@NotBlank(message = "Father name is required")
	@Size(max = 100)
	private String fatherName;

	private String fatherOccupation;

	@NotBlank(message = "Mother name is required")
	@Size(max = 100)
	private String motherName;

	private String motherOccupation;

	@NotBlank(message = "Parent mobile is required")
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid parent mobile number")
	private String parentMobile;

	@Email(message = "Invalid parent email")
	private String parentEmail;

	private String doorNo;

	private String street;

	@NotBlank(message = "City is required")
	private String city;

	@NotBlank(message = "District is required")
	private String district;

	@NotBlank(message = "State is required")
	private String state;

	@NotBlank(message = "Pincode is required")
	@Pattern(regexp = "^[1-9][0-9]{5}$", message = "Invalid pincode")
	private String pincode;

	private String previousSchool;

	@NotNull(message = "Admission date is required")
	private LocalDate admissionDate;
}
