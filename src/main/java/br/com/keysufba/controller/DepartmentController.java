package br.com.keysufba.controller;

import br.com.keysufba.entity.Department;
import br.com.keysufba.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ian on 28/08/16.
 */

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity<List<Department>> getDepartments() {
        final List<Department> departments = departmentService.findAll();
        if(departments.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public HttpEntity<Department> getDepartment(@PathVariable("id") Integer id) {
        final Department department = departmentService.findById(id);
        if (department == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        if (department == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        departmentService.create(department);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }


    @RequestMapping(method=RequestMethod.PUT)
    public HttpEntity<Department> updateDepartment(@RequestBody Department department) throws DataIntegrityViolationException {
        if (department == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        departmentService.update(department);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.DELETE)
    public HttpEntity<Department> deleteDepartment(@RequestBody Department department) throws DataIntegrityViolationException {
        if (department == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        departmentService.delete(department);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }
}
