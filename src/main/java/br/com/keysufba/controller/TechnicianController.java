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
import br.com.keysufba.entity.Technician;
import br.com.keysufba.service.TechnicianService;

@RestController
@RequestMapping("/api/v1/technicians")
public class TechnicianController {

  @Autowired
  private TechnicianService technicianService;

  @RequestMapping(method = RequestMethod.GET)
  public HttpEntity<List<Technician>> getTechnicians() {
    final List<Technician> Technicians = technicianService.findAll();
    return new ResponseEntity<>(Technicians, HttpStatus.OK);
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.GET)
  public HttpEntity<Technician> getTechnician(@PathVariable("id") Integer id) {
    if (id == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    final Technician Technician = technicianService.findById(id);
    if (Technician == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(Technician, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<Technician> createTechnician(@RequestBody Technician Technician) {
    if (Technician == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    try {
      final Technician createdTechnician = technicianService.create(Technician);
      return new ResponseEntity<>(createdTechnician, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<Technician> updateTechnician(@PathVariable("id") Integer id, @RequestBody Technician Technician) {
    if (id == null || Technician == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    try {
      Technician.setId(id);
      final Technician updatedTechnician = technicianService.update(Technician);
      if (updatedTechnician == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(updatedTechnician, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<Technician> deleteTechnician(@PathVariable("id") Integer id) {
    if (id == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    try {
      final Integer deletedId = technicianService.delete(id);
      return new ResponseEntity<>(new Technician(deletedId), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

}
