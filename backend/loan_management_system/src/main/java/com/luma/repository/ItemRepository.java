package com.luma.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.luma.model.Employee;
import com.luma.model.Item;
import com.luma.model.dto.ItemDto;
@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

	@Query("SELECT u FROM Item u WHERE u.category = ?1")
	List<Item> findByItemCategory(String category);
	
	@Query("SELECT u FROM Item u WHERE u.description = ?1")
	Item findByItemDescription(String description);

//	Optional List<Item> findByCategory(String category);

//	Optional List<Item> findByCategory(String category);

//	Optional<Item> findByCategory(String category);
//	List<Item> findByItemCategory(String category);
	

}
