package br.com.keysufba.controller;

import br.com.keysufba.entity.Course;
import br.com.keysufba.entity.Room;
import br.com.keysufba.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ian on 28/08/16.
 */

@RestController
@RequestMapping("/api/v1")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;



    @RequestMapping("/courses")
    public HttpEntity<List<Course>> getCourses() {
        final List<Course> courses = courseRepository.findAll();
        if(courses.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @RequestMapping(value = "/courses/{id}")
    public HttpEntity<Course> getCourse(@PathVariable("id") Integer id) {
       final Course course = courseRepository.findOne(id);
        if (course == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @RequestMapping(value = "/courses", method = RequestMethod.POST)
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        courseRepository.save(course);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }
    
    @RequestMapping("/courses/delete/{id}")
    public boolean deleteCourse(@PathVariable("id") Integer id) {
  	 if(courseRepository.exists(id)){
  		courseRepository.delete(id);
  		 return true;
  	 }else{
  		 return false;
   	 }	 
    }  
    
    @RequestMapping("/courses/edit/{id}")
    public boolean updateRoom(@PathVariable("id") Integer id) {
      if(courseRepository.exists(id)){
    	 Course course = new Course(id,"Licenciatura em Computação","Graduação"); 
      	 courseRepository.save(course);
      	 return true;
      }else{
      	 return false;
      }
    }   

}
