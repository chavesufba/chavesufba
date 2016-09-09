package br.com.keysufba.repository;

import br.com.keysufba.entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTypeRepository extends JpaRepository<UserType, Integer> {
}
