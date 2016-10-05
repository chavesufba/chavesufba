package br.com.keysufba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.keysufba.entity.Technician;

public interface TechnicianRepository extends JpaRepository<Technician, Integer> {
}
