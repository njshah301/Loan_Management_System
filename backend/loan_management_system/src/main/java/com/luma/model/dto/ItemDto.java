package com.luma.model.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ItemDto {
	
	@Column(nullable = false)
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
	private String value;
}