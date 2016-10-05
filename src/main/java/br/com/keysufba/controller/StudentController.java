package br.com.keysufba.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.keysufba.entity.Student;
import br.com.keysufba.service.StudentService;


@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
	  
	  @Autowired
	  private StudentService studentService;

	  @RequestMapping(method = RequestMethod.GET)
	  public HttpEntity<List<Student>> getStudents() {
	    final List<Student> students = studentService.findAll();
	    return new ResponseEntity<>(students, HttpStatus.OK);
	  }

	  @RequestMapping(path = "/{id}", method = RequestMethod.GET)
	  public HttpEntity<Student> getStudent(@PathVariable("id") Integer id) {
	    if (id == null) {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    final Student Student = studentService.findById(id);
	    if (Student == null) {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<>(Student, HttpStatus.OK);
	  }

	  @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	  public HttpEntity<Student> createStudent(@RequestBody Student Student) throws DataIntegrityViolationException {
	    if (Student == null) {
	      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }

	    try {
	      final Student createdStudent = studentService.create(Student);
	      return new ResponseEntity<>(createdStudent, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
	  }

	  @RequestMapping(path = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	  public HttpEntity<Student> updateStudent(@PathVariable("id") Integer id, @RequestBody Student Student) {
	    if (id == null || Student == null) {
	      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }

	    try {
	      Student.setId(id);
	      final Student updatedStudent = studentService.update(Student);
	      if (updatedStudent == null) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	      return new ResponseEntity<>(Student, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
	  }

	  @RequestMapping(path = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	  public HttpEntity<Student> deleteStudent(@PathVariable("id") Integer id) {
	    if (id == null) {
	      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }

	    try {
	      final Integer deletedId = studentService.delete(id);
	      return new ResponseEntity<>(new Student(deletedId), HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
	  }
}
