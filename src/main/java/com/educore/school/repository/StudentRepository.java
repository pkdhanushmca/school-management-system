package com.educore.school.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educore.school.entity.Student;
import com.educore.school.enums.StudentStatus;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	boolean existsByAdmissionNumber(String admissionNumber);

	boolean existsByEmail(String email);

	List<Student> findByStatus(StudentStatus status);

	boolean existsByEmailAndIdNot(String email, Long id);

	Page<Student> findByStatus(StudentStatus status, Pageable pageable);

	Page<Student> findByStatusAndFirstNameContainingIgnoreCase(StudentStatus status, String firstName,
			Pageable pageable);

}
