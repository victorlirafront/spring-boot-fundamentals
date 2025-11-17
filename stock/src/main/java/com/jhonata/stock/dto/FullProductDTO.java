package com.jhonata.stock.dto;

public record FullProductDTO(
	boolean isBelowMinimumStock,
	String id,
	String name,
	String description,
	String price,
	long quantityInStock
){

	public FullProductDTO(ProductDTO productDTO, boolean isBelowMinimumStock) {
		this(
			isBelowMinimumStock,
			productDTO.getId(),
			productDTO.getName(),
			productDTO.getDescription(),
			productDTO.getPrice().toString(),
			productDTO.getQuantityInStock()
		);
	}

}
