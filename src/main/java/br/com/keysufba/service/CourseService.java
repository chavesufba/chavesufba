package br.com.keysufba.service;

import java.util.List;

import br.com.keysufba.entity.Course;
import br.com.keysufba.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("courseService")
public class CourseService implements GenericService<Course> {

  @Autowired
  private CourseRepository courseRepository;

  @Override
  public List<Course> findAll() {
    return courseRepository.findAll();
  }

  @Override
  public Course findById(final Integer id) {
    return courseRepository.findOne(id);
  }

  @Override
  public Course create(Course i) {
    courseRepository.save(i);
    return i;
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
