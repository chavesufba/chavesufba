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
@RequestMapping("/api/v1/pavilions")
public class PavilionController {

  @Autowired
  private PavilionService pavilionService;

  @RequestMapping(method = RequestMethod.GET)
  public HttpEntity<List<Pavilion>> getPavilions() {
    final List<Pavilion> pavilions = pavilionService.findAll();
    return new ResponseEntity<>(pavilions, HttpStatus.OK);
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.GET)
  public HttpEntity<Pavilion> getPavilion(@PathVariable("id") Integer id) {
    if (id == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    final Pavilion pavilion = pavilionService.findById(id);
    if (pavilion == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(pavilion, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<Pavilion> createPavilion(@RequestBody Pavilion pavilion) throws DataIntegrityViolationException {
    if (pavilion == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    try {
      final Pavilion createdPavilion = pavilionService.create(pavilion);
      return new ResponseEntity<>(createdPavilion, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<Pavilion> updatePavilion(@PathVariable("id") Integer id, @RequestBody Pavilion pavilion) {
    if (id == null || pavilion == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    try {
      pavilion.setId(id);
      final Pavilion updatedPavilion = pavilionService.update(pavilion);
      if (updatedPavilion == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(pavilion, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<Pavilion> deletePavilion(@PathVariable("id") Integer id) {
    if (id == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    try {
      final Integer deletedId = pavilionService.delete(id);
      return new ResponseEntity<>(new Pavilion(deletedId), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }
}
