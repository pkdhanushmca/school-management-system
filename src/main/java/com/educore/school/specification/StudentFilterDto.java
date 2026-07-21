package com.educore.school.specification;

import com.educore.school.enums.BloodGroup;
import com.educore.school.enums.Gender;
import com.educore.school.enums.StudentStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentFilterDto {

	private Gender gender;

	private BloodGroup bloodGroup;

	private StudentStatus status;

	private String city;

	private String firstName;

}
