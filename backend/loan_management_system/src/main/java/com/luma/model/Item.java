package com.luma.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@Table(name = "Item")
public class Item {
	
	@Id
	private Long itemid;
	
	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private String status;

	@Column(nullable = false)
	private String make;

	@Column(nullable = false)
	private String category;

	@Column(nullable = false)
	private Double value;


	
}