package br.com.keysufba.controller;

import br.com.keysufba.entity.Institute;
import br.com.keysufba.service.InstituteService;
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
@RequestMapping("/api/v1/institutes")
public class InstituteController {

    @Autowired
    private InstituteService instituteService;

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity<List<Institute>> getInstitutes() {
        final List<Institute> institutes = instituteService.findAll();
        if(institutes.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(institutes, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public HttpEntity<Institute> getInstitute(@PathVariable("id") Integer id) {
        final Institute institute = instituteService.findById(id);
        if (institute == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(institute, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Institute> addInstitute(@RequestBody Institute institute) {
        if (institute == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        instituteService.create(institute);
        return new ResponseEntity<>(institute, HttpStatus.OK);
    }


    @RequestMapping(method=RequestMethod.PUT)
    public HttpEntity<Institute> updateInstitute(@RequestBody Institute institute) throws DataIntegrityViolationException {
        if (institute == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        instituteService.update(institute);
        return new ResponseEntity<>(institute, HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.DELETE)
    public HttpEntity<Institute> deleteInstitute(@RequestBody Institute institute) throws DataIntegrityViolationException {
        if (institute == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        instituteService.delete(institute);
        return new ResponseEntity<>(institute, HttpStatus.OK);
    }
}
