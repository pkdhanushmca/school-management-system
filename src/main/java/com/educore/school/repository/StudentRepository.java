package com.educore.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educore.school.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	boolean existsByAdmissionNumber(String admissionNumber);

	boolean existsByEmail(String email);

}
