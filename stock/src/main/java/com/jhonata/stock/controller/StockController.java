package com.jhonata.stock.controller;

import com.jhonata.stock.client.ProductClient;
import com.jhonata.stock.dto.FullProductDTO;
import com.jhonata.stock.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/stock")
public class StockController {

	@Autowired
	private ProductClient productClient;

	@GetMapping("/{productId}")
	public FullProductDTO getStockByProductId(@PathVariable UUID productId) {
		ProductDTO response = productClient.getProductById(productId);
		return new FullProductDTO(
			response,
			10 > response.getQuantityInStock()
		);
	}

	@PutMapping("/{productId}/amount/{amount}")
	public void updateStock(@PathVariable UUID productId, @PathVariable long amount) {
		ProductDTO productDTO = productClient.getProductById(productId);
		productDTO.setQuantityInStock(productDTO.getQuantityInStock() + amount);
		productClient.updateProduct(productDTO);
	}

}
