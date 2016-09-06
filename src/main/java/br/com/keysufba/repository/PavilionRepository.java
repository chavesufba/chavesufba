package br.com.keysufba.repository;

import br.com.keysufba.entity.Pavilion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PavilionRepository extends JpaRepository<Pavilion, Integer> {
}
