package com.jhonata.product.service;

import com.jhonata.product.domain.Product;
import com.jhonata.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public void save(Product product) {
		repository.save(product);
	}

	public Product findById(UUID id) {
		return repository.findById(id).orElse(null);
	}

	public List<Product> findAll(int page, int resultsPerPage) {
		return repository.findAll(PageRequest.of(page, resultsPerPage)).getContent();
	}

	public void deleteById(UUID id) {
		repository.deleteById(id);
	}

	public void update(Product product) {
		if (repository.existsById(product.getId())) {
			repository.save(product);
		} else {
			throw new IllegalArgumentException("Product with ID " + product.getId() + " does not exist.");
		}
	}

}
