package br.com.keysufba.controller;

import java.util.List;

import br.com.keysufba.entity.Pavilion;
import br.com.keysufba.service.PavilionService;
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
@RequestMapping("/api/v1")
public class PavilionController {

  @Autowired
  private PavilionService pavilionService;

  @RequestMapping("/pavilions")
  public HttpEntity<List<Pavilion>> getPavilions() {
    final List<Pavilion> pavilions = pavilionService.findAll();
    return new ResponseEntity<>(pavilions, HttpStatus.OK);
  }

  @RequestMapping("/pavilions/{id}")
  public HttpEntity<Pavilion> getPavilion(@PathVariable("id") Integer id) {
    final Pavilion pavilion = pavilionService.findById(id);
    if (pavilion == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(pavilion, HttpStatus.OK);
  }

  @RequestMapping(path = "/pavilions", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<Pavilion> createPavilion(@RequestBody Pavilion pavilion) throws DataIntegrityViolationException {
    if (pavilion == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    try {
      pavilionService.create(pavilion);
      return new ResponseEntity<>(pavilion, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(path = "/pavilions", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<Pavilion> updatePavilion(@RequestBody Pavilion pavilion) {
    if (pavilion == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    try {
      pavilionService.update(pavilion);
      return new ResponseEntity<>(pavilion, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(path = "/pavilions", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<Pavilion> deletePavilion(@RequestBody Pavilion pavilion) throws DataIntegrityViolationException {
    if (pavilion == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    try {
      pavilionService.delete(pavilion);
      return new ResponseEntity<>(pavilion, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }
}
