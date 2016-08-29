package br.com.keysufba.repository;

import br.com.keysufba.entity.Course;
import br.com.keysufba.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer>{

}
