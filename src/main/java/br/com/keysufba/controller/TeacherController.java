package br.com.keysufba.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.keysufba.entity.Teacher;
import br.com.keysufba.service.TeacherService;

@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {

  @Autowired
  private TeacherService teacherService;

  @RequestMapping(method = RequestMethod.GET)
  public HttpEntity<List<Teacher>> getTeachers() {
    final List<Teacher> Teachers = teacherService.findAll();
    return new ResponseEntity<>(Teachers, HttpStatus.OK);
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.GET)
  public HttpEntity<Teacher> getTeacher(@PathVariable("id") Integer id) {
    if (id == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    final Teacher Teacher = teacherService.findById(id);
    if (Teacher == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(Teacher, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<Teacher> createTeacher(@RequestBody Teacher Teacher) {
    if (Teacher == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    try {
      final Teacher createdTeacher = teacherService.create(Teacher);
      return new ResponseEntity<>(createdTeacher, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<Teacher> updateTeacher(@PathVariable("id") Integer id, @RequestBody Teacher Teacher) {
    if (id == null || Teacher == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    try {
      Teacher.setId(id);
      final Teacher updatedTeacher = teacherService.update(Teacher);
      if (updatedTeacher == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(updatedTeacher, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<Teacher> deleteTeacher(@PathVariable("id") Integer id) {
    if (id == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    try {
      final Integer deletedId = teacherService.delete(id);
      return new ResponseEntity<>(new Teacher(deletedId), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

}
