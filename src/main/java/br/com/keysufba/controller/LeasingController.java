package br.com.keysufba.controller;

import java.util.List;

import br.com.keysufba.entity.Leasing;
import br.com.keysufba.service.LeasingService;
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
@RequestMapping("/api/v1/leasings")
public class LeasingController {

  @Autowired
  private LeasingService leasingService;

  @RequestMapping(method = RequestMethod.GET)
  public HttpEntity<List<Leasing>> getLeasings() {
    final List<Leasing> leasings = leasingService.findAll();
    return new ResponseEntity<>(leasings, HttpStatus.OK);
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.GET)
  public HttpEntity<Leasing> getLeasing(@PathVariable("id") Integer id) {
    if (id == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    final Leasing leasing = leasingService.findById(id);
    if (leasing == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(leasing, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<Leasing> createLeasing(@RequestBody Leasing leasing) {
    if (leasing == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    try {
      final Leasing createdLeasing = leasingService.create(leasing);
      return new ResponseEntity<>(createdLeasing, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<Leasing> updateLeasing(@PathVariable("id") Integer id, @RequestBody Leasing leasing) {
    if (id == null || leasing == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    try {
      leasing.setId(id);
      final Leasing updatedLeasing = leasingService.update(leasing);
      if (updatedLeasing == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(updatedLeasing, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<Leasing> deleteLeasing(@PathVariable("id") Integer id) {
    if (id == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    try {
      final Integer deletedId = leasingService.delete(id);
      return new ResponseEntity<>(new Leasing(deletedId), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

}
