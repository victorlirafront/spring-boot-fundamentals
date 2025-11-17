package com.jhonata.product.controller;

import com.jhonata.product.domain.Product;
import com.jhonata.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody Product product){
		productService.save(product);
	}

	@GetMapping("/{id}")
	public Product findById(@PathVariable UUID id) {
		return productService.findById(id);
	}

	@GetMapping
	public ResponseEntity<List<Product>> findAll(@RequestParam(defaultValue = "0") int page,
												@RequestParam(defaultValue = "10") int resultsPerPage) {
		return ResponseEntity.ok(productService.findAll(page, resultsPerPage));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable UUID id) {
		productService.deleteById(id);
	}

	@PutMapping
	public void update(@RequestBody Product product) {
		productService.update(product);
	}

}
