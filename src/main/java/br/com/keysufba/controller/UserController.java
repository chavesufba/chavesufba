package br.com.keysufba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.keysufba.entity.User;
import br.com.keysufba.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping(method=RequestMethod.GET)
  public HttpEntity<List<User>> getUsers() {
    final List<User> Users = userService.findAll();
    return new ResponseEntity<>(Users, HttpStatus.OK);
  }

  @RequestMapping("/users/{id}")
  public HttpEntity<User> getUser(@PathVariable("id") Integer id) {
    final User User = userService.findById(id);
    if (User == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(User, HttpStatus.OK);
  }
  
  @RequestMapping(path="/users", method=RequestMethod.POST)
  public HttpEntity<User> createUser(@RequestBody User user) throws DataIntegrityViolationException {
	  if (user == null) {
		  return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	  }
	  userService.create(user);
	  return new ResponseEntity<>(user, HttpStatus.OK);
  }
  
  @RequestMapping(path="/users", method=RequestMethod.PUT)
  public HttpEntity<User> updateUser(@RequestBody User user) throws DataIntegrityViolationException {
	  if (user == null) {
		  return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	  }
	  userService.update(user);
	  return new ResponseEntity<>(user, HttpStatus.OK);
  }

}