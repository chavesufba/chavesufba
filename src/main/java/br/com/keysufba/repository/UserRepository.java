package br.com.keysufba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.keysufba.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
