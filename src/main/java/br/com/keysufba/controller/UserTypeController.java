package br.com.keysufba.controller;

import java.util.List;

import br.com.keysufba.entity.UserType;
import br.com.keysufba.service.UserTypeService;
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
@RequestMapping("/api/v1/user_types")
public class UserTypeController {

  @Autowired
  private UserTypeService userTypeService;

  @RequestMapping(method = RequestMethod.GET)
  public HttpEntity<List<UserType>> getUserTypes() {
    final List<UserType> departments = userTypeService.findAll();
    return new ResponseEntity<>(departments, HttpStatus.OK);
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.GET)
  public HttpEntity<UserType> getUserType(@PathVariable("id") Integer id) {
    if (id == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    final UserType department = userTypeService.findById(id);
    if (department == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(department, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<UserType> updateUserType(@PathVariable("id") Integer id, @RequestBody UserType department) {
    if (id == null || department == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    try {
      department.setId(id);
      final UserType updatedUserType = userTypeService.update(department);
      if (updatedUserType == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(updatedUserType, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<UserType> deleteUserType(@PathVariable("id") Integer id) {
    if (id == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    try {
      final Integer deletedId = userTypeService.delete(id);
      return new ResponseEntity<>(new UserType(deletedId), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

}
