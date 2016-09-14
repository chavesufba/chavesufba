package br.com.keysufba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.keysufba.entity.Leasing;

public interface LeasingRepository extends JpaRepository<Leasing, Integer> {

}
