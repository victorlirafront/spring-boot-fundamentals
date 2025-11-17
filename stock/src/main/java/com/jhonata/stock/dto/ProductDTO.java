package com.jhonata.stock.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {

	private String id;
	private String name;
	private String description;
	private BigDecimal price;
	private long quantityInStock;

}
