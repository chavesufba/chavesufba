package br.com.keysufba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.keysufba.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}
