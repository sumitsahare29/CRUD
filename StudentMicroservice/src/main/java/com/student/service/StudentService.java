package com.student.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.student.entity.Student;
import com.student.repo.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	// Add student
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	// fetch all student
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	// fetch student by perticular instituteId
	public List<Student> findByInstituteId(Integer instituteId) {
		return studentRepository.findByInstituteId(instituteId);
	}
	
	//fetch student by studentId
	public Student findByStudentId(Long id) {
		return studentRepository.findById(id).get();
	}
	
	//delete student by studentId
	public String deleteByStudentId(Long id) {
		 studentRepository.deleteById(id);
		 return "studentId->" +id+" student deleted successfully! ";
	}
	
	//update student
	//(studentId is not present -> new student created, but studentId is present -> student is updated)
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}
	

}
