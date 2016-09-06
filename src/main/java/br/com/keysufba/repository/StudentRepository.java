package br.com.keysufba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.keysufba.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
