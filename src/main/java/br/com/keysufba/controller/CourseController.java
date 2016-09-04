package br.com.keysufba.controller;

import br.com.keysufba.entity.Course;
import br.com.keysufba.service.CourseService;
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
@RequestMapping("/api/v1/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity<List<Course>> getCourses() {
        final List<Course> courses = courseService.findAll();
        if(courses.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public HttpEntity<Course> getCourse(@PathVariable("id") Integer id) {
       final Course course = courseService.findById(id);
        if (course == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        if (course == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        courseService.create(course);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }


    @RequestMapping(method=RequestMethod.PUT)
    public HttpEntity<Course> updateCourse(@RequestBody Course course) throws DataIntegrityViolationException {
        if (course == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        courseService.update(course);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.DELETE)
    public HttpEntity<Course> deleteCourse(@RequestBody Course course) throws DataIntegrityViolationException {
        if (course == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        courseService.delete(course);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }
}
