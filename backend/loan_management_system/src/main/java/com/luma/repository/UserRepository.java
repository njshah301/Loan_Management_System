package org.reni.repositories;

import java.util.Optional;

import org.reni.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional<User> findByUsername(String username);
	Optional<User> findByEmail(String email);
	Optional<User> findByUsernameOrEmail(String usernString,String email);
	
	boolean existsByUsername(String username);
	boolean existsByEmail(String email);
	boolean existsByUsernameOrEmail(String username,String email);
	
	

}
