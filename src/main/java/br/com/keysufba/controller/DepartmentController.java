package br.com.keysufba.controller;

import java.util.List;

import br.com.keysufba.entity.Department;
import br.com.keysufba.service.DepartmentService;
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

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

  @Autowired
  private DepartmentService departmentService;

  @RequestMapping(method = RequestMethod.GET)
  public HttpEntity<List<Department>> getDepartments() {
    final List<Department> departments = departmentService.findAll();
    return new ResponseEntity<>(departments, HttpStatus.OK);
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.GET)
  public HttpEntity<Department> getDepartment(@PathVariable("id") Integer id) {
    if (id == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    final Department department = departmentService.findById(id);
    if (department == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(department, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<Department> createDepartment(@RequestBody Department department) {
    if (department == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    try {
      departmentService.create(department);
      return new ResponseEntity<>(department, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<Department> updateDepartment(@PathVariable("id") Integer id, @RequestBody Department department) {
    if (id == null || department == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    try {
      department.setId(id);
      final Department updatedDepartment = departmentService.update(department);
      if (updatedDepartment == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<Department> deleteDepartment(@PathVariable("id") Integer id) {
    if (id == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    try {
      final Integer deletedId = departmentService.delete(id);
      return new ResponseEntity<>(new Department(deletedId), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

}
