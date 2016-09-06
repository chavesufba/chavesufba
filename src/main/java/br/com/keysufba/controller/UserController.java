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
import br.com.keysufba.entity.User;
import br.com.keysufba.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	  @Autowired
	  private UserService userService;

	  @RequestMapping(method = RequestMethod.GET)
	  public HttpEntity<List<User>> getUsers() {
	    final List<User> users = userService.findAll();
	    return new ResponseEntity<>(users, HttpStatus.OK);
	  }

	  @RequestMapping(path = "/{id}", method = RequestMethod.GET)
	  public HttpEntity<User> getUser(@PathVariable("id") Integer id) {
	    if (id == null) {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    final User user = userService.findById(id);
	    if (user == null) {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<>(user, HttpStatus.OK);
	  }

	  @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	  public HttpEntity<User> createUser(@RequestBody User user) {
	    if (user == null) {
	      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }

	    try {
	      final User createdUser = userService.create(user);
	      return new ResponseEntity<>(createdUser, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
	  }

	  @RequestMapping(path = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	  public HttpEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
	    if (id == null || user == null) {
	      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }

	    try {
	      user.setId(id);
	      final User updatedUser = userService.update(user);
	      if (updatedUser == null) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	      return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
	  }

	  @RequestMapping(path = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	  public HttpEntity<User> deleteUser(@PathVariable("id") Integer id) {
	    if (id == null) {
	      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }

	    try {
	      final Integer deletedId = userService.delete(id);
	      return new ResponseEntity<>(new User(deletedId), HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
	  }

}