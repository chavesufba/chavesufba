package br.com.keysufba.service;

import br.com.keysufba.entity.Course;
import br.com.keysufba.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;



/**
 * Created by ian on 04/09/16.
 */
@Service("courseService")
public class CourseService implements GenericService<Course> {


    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(Integer id) {
        return courseRepository.findOne(id);
    }

    @Override
    public Course create(Course t) throws DataIntegrityViolationException {
        if(findById(t.getId()) != null){
            throw new DataIntegrityViolationException("entity already exists");
        }
        return courseRepository.save(t);
    }

    @Override
    public Integer delete(Course t) {
        courseRepository.delete(t);
        return null;
    }

    public Course update(Course t) throws DataIntegrityViolationException {
        if(findById(t.getId()) != null){
            return courseRepository.save(t);
        }
        throw new DataIntegrityViolationException("entity not found");
    }
}
