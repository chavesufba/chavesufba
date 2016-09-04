package br.com.keysufba.controller;

import br.com.keysufba.entity.Institute;
import br.com.keysufba.service.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/institutes")
public class InstituteController {

    @Autowired
    private InstituteService instituteService;

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity<List<Institute>> getInstitutes() {
        final List<Institute> institutes = instituteService.findAll();
        return new ResponseEntity<>(institutes, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public HttpEntity<Institute> getInstitute(@PathVariable("id") Integer id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        final Institute institute = instituteService.findById(id);
        if (institute == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(institute, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Institute> createInstitute(@RequestBody Institute institute) throws DataIntegrityViolationException {
        if (institute == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            instituteService.create(institute);
            return new ResponseEntity<>(institute, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(path="/{id}", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<Institute> updateInstitute(@PathVariable("id") Integer id, @RequestBody Institute institute) {
        if (id == null || institute == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            institute.setId(id);
            final Institute updatedInstitute = instituteService.update(institute);
            return new ResponseEntity<>(updatedInstitute, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path="/{id}", method=RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
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
