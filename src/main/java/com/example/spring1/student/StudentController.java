package com.example.spring1.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

	private final StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping("/")
	public List<Student> hello() {
		return studentService.getStudents();
	}

	@PostMapping("/")
	public void resigterStudent(@RequestBody Student student) {
		studentService.add(student);
	}

	@DeleteMapping("{studentId}")
	public void deleteStudent(@PathVariable("studentId") Long studentId) {
		studentService.delete(studentId);
	}

	@PutMapping("{studentId}")
	public void updateStudent(
		@PathVariable("studentId") Long studentId,
		@RequestParam(required = false) String name,
		@RequestParam(required = false) String email
		) {
		studentService.update(studentId, name, email);
	}
}
