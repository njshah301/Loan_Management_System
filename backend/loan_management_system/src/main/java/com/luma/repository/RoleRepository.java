package com.luma.repository;

import java.util.Optional;

import com.luma.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	Optional<Role> findByName(String name);

}
