package com.luma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luma.model.Employee;
import com.luma.model.Item;
@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

}
