package com.student.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.student.entity.Student;
import com.student.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/saveStd")
	public Student saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}

	@GetMapping("/getAllStd")
	public List<Student> getAllStudent() {
		return studentService.getAllStudent();
	}

	@GetMapping("/getStdInsId/{instituteId}")
	public List<Student> getByInstituteId(@PathVariable("instituteId") Integer instituteId) {
		return studentService.findByInstituteId(instituteId);
	}

	@GetMapping("/getStdId/{studentId}")
	public Student getByStudentId(@PathVariable("studentId") Long id) {
		return studentService.findByStudentId(id);
	}

	@DeleteMapping("/deleteStdId/{studentId}")
	public String deleteByStudentId(@PathVariable("studentId") Long id) {
		return studentService.deleteByStudentId(id);
	}

	@PutMapping("updateStdId/{studentId}")
	public Student updateStdByStudentId(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}

}
