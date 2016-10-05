package br.com.keysufba.controller;

import java.util.List;

import br.com.keysufba.entity.Institute;
import br.com.keysufba.service.InstituteService;
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

@RestController
@RequestMapping("/api/v1/institutes")
public class InstituteController {

  @Autowired
  private InstituteService instituteService;

  @RequestMapping(method = RequestMethod.GET)
  public HttpEntity<List<Institute>> getInstitutes() {
    final List<Institute> rooms = instituteService.findAll();
    return new ResponseEntity<>(rooms, HttpStatus.OK);
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.GET)
  public HttpEntity<Institute> getInstitute(@PathVariable("id") Integer id) {
    if (id == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    final Institute room = instituteService.findById(id);
    if (room == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(room, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<Institute> createInstitute(@RequestBody Institute room) throws DataIntegrityViolationException {
    if (room == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    try {
      final Institute createdInstitute = instituteService.create(room);
      return new ResponseEntity<>(createdInstitute, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<Institute> updateInstitute(@PathVariable("id") Integer id, @RequestBody Institute room) {
    if (id == null || room == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    try {
      room.setId(id);
      final Institute updatedInstitute = instituteService.update(room);
      if (updatedInstitute == null) {
        new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(updatedInstitute, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<Institute> deleteInstitute(@PathVariable("id") Integer id) {
    if (id == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    try {
      final Integer deletedId = instituteService.delete(id);
      return new ResponseEntity<>(new Institute(deletedId), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }
}
