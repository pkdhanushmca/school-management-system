package com.educore.school.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.educore.school.dto.request.StudentRequestDto;
import com.educore.school.dto.response.StudentResponseDto;
import com.educore.school.entity.Student;
import com.educore.school.enums.StudentStatus;
import com.educore.school.exception.DuplicateResourceException;
import com.educore.school.exception.ResourceNotFoundException;
import com.educore.school.mapper.StudentMapper;
import com.educore.school.repository.StudentRepository;
import com.educore.school.service.StudentService;
import com.educore.school.specification.StudentFilterDto;
import com.educore.school.specification.StudentSpecification;
import com.educore.school.util.AdmissionNumberGenerator;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentServiceImpl implements StudentService {

	private final StudentRepository studentRepository;
	private final StudentMapper studentMapper;

	@Override
	public StudentResponseDto createStudent(StudentRequestDto request) {

		if (request.getEmail() != null && !request.getEmail().isBlank()
				&& studentRepository.existsByEmail(request.getEmail())) {

			throw new DuplicateResourceException("Email already exists");
		}
		Student student = studentMapper.toEntity(request);
		student.setStatus(StudentStatus.ACTIVE);

		// First Save
		Student savedStudent = studentRepository.save(student);

		// Generate Admission Number
		savedStudent.setAdmissionNumber(AdmissionNumberGenerator.generate(savedStudent.getId()));

		// Update
		savedStudent = studentRepository.save(savedStudent);

		return studentMapper.toResponse(savedStudent);
	}

	@Override
	public List<StudentResponseDto> getAllStudents() {

		return studentRepository.findByStatus(StudentStatus.ACTIVE).stream().map(studentMapper::toResponse).toList();
	}

	@Override
	public StudentResponseDto getStudentById(Long id) {

		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found with id : " + id));

		if (student.getStatus() == StudentStatus.INACTIVE) {
			throw new ResourceNotFoundException("Student not found with id : " + id);
		}

		return studentMapper.toResponse(student);
	}

	@Override
	public StudentResponseDto updateStudent(Long id, StudentRequestDto request) {

		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found with id : " + id));

		if (request.getEmail() != null && studentRepository.existsByEmailAndIdNot(request.getEmail(), id)) {

			throw new DuplicateResourceException("Email already exists");
		}

		studentMapper.updateEntity(student, request);

		Student savedStudent = studentRepository.save(student);

		return studentMapper.toResponse(savedStudent);
	}

	@Override
	public void deleteStudent(Long id) {

		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found with id : " + id));

		if (student.getStatus() == StudentStatus.INACTIVE) {
			throw new DuplicateResourceException("Student is already inactive");
		}

		student.setStatus(StudentStatus.INACTIVE);

		studentRepository.save(student);
	}

	@Override
	public Page<StudentResponseDto> getAllStudents(Pageable pageable) {

		Page<Student> students = studentRepository.findByStatus(StudentStatus.ACTIVE, pageable);

		return students.map(studentMapper::toResponse);
	}

	@Override
	public Page<StudentResponseDto> searchStudents(String keyword, Pageable pageable) {

		Page<Student> students = studentRepository.findByStatusAndFirstNameContainingIgnoreCase(StudentStatus.ACTIVE,
				keyword, pageable);

		return students.map(studentMapper::toResponse);
	}

	@Override
	public Page<StudentResponseDto> filterStudents(StudentFilterDto filter, Pageable pageable) {
		Specification<Student> specification = Specification.where(StudentSpecification.hasStatus(StudentStatus.ACTIVE))
				.and(StudentSpecification.hasGender(filter.getGender()))
				.and(StudentSpecification.hasBloodGroup(filter.getBloodGroup()))
				.and(StudentSpecification.hasCity(filter.getCity()));

		Page<Student> students = studentRepository.findAll(specification, pageable);

		return students.map(studentMapper::toResponse);
	}

}
