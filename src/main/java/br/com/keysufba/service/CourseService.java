package br.com.keysufba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.keysufba.entity.Course;
import br.com.keysufba.repository.CourseRepository;

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
    public Course create(Course c) {
        courseRepository.save(c);
        return c;
    }

    @Override
    public Integer delete(Integer id) {
        courseRepository.delete(id);
        return id;
    }

    @Override
    public Course update(Course c) {
        final Course foundCourse = findById(c.getId());
        if (foundCourse == null) {
            return null;
        }
        courseRepository.save(c);
        return c;
    }

}
