package com.educore.school.specification;

import org.springframework.data.jpa.domain.Specification;

import com.educore.school.entity.Student;
import com.educore.school.enums.BloodGroup;
import com.educore.school.enums.Gender;
import com.educore.school.enums.StudentStatus;

public class StudentSpecification {

	public static Specification<Student> hasGender(Gender gender) {

		return (root, query, criteriaBuilder) -> {

			if (gender == null) {
				return criteriaBuilder.conjunction();
			}

			return criteriaBuilder.equal(root.get("gender"), gender);
		};
	}
	
	public static Specification<Student> hasBloodGroup(BloodGroup bloodGroup) {

		return (root, query, criteriaBuilder) -> {

			if (bloodGroup == null) {
				return criteriaBuilder.conjunction();
			}

			return criteriaBuilder.equal(root.get("bloodGroup"), bloodGroup);
		};
	}
	
	public static Specification<Student> hasCity(String city) {

		return (root, query, criteriaBuilder) -> {

			if (city == null || city.isBlank()) {
			    return criteriaBuilder.conjunction();
			}

			return criteriaBuilder.equal(root.get("city"), city);
		};
	}
	
	
	public static Specification<Student> hasStatus(StudentStatus status) {

		return (root, query, criteriaBuilder) -> {

			if (status == null) {
				return criteriaBuilder.conjunction();
			}

			return criteriaBuilder.equal(root.get("status"), status);
		};
	}
}
