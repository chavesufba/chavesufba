package br.com.keysufba.repository;

import br.com.keysufba.entity.Institute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstituteRepository extends JpaRepository<Institute, Integer> {
}
