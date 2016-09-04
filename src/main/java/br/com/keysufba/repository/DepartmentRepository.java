package br.com.keysufba.repository;

import br.com.keysufba.entity.Department;
import br.com.keysufba.entity.Institute;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ian on 04/09/16.
 */
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}

