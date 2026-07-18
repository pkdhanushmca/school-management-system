package com.educore.school.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.educore.school.enums.BloodGroup;
import com.educore.school.enums.Gender;
import com.educore.school.enums.StudentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Builder
@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, length = 20)
	private String admissionNumber;
	
	@Column(nullable = false, length = 50)
	private String firstName;
	
	@Column(length = 50)
	private String lastName;
	
	@Column(name="date_of_birth", nullable = false)
	private LocalDate dateOfBirth;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 10)
	private Gender gender;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private BloodGroup bloodGroup;

	@Column(unique = true, length = 100)
	private String email;

	@Column(length = 15)
	private String studentMobile;
	
	
	@Column(nullable = false, length = 100)
	private String fatherName;

	@Column(length = 100)
	private String fatherOccupation;

	@Column(nullable = false, length = 100)
	private String motherName;

	@Column(length = 100)
	private String motherOccupation;

	@Column(nullable = false, length = 15)
	private String parentMobile;

	@Column(length = 100)
	private String parentEmail;
	
	
	@Column(length = 20)
	private String doorNo;

	@Column(length = 150)
	private String street;

	@Column(nullable = false, length = 100)
	private String city;

	@Column(nullable = false, length = 100)
	private String district;

	@Column(nullable = false, length = 100)
	private String state;

	@Column(nullable = false, length = 10)
	private String pincode;
	
	
	@Column(length = 200)
	private String previousSchool;
	
	@Column(nullable = false)
	private LocalDate admissionDate;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private StudentStatus status;
	
	
	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@Column(nullable = false)
	private LocalDateTime updatedAt;
	
	@PrePersist
	public void onCreate() {
	    this.createdAt = LocalDateTime.now();
	    this.updatedAt = LocalDateTime.now();
	}
	
	@PreUpdate
	public void onUpdate() {
	    this.updatedAt = LocalDateTime.now();
	}

}
