package com.jhonata.stock.client;

import com.jhonata.stock.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@FeignClient(name = "product-service", url = "${application.config.product-service-url}")
public interface ProductClient {

	@GetMapping("/v1/product/{productId}")
	ProductDTO getProductById(@PathVariable UUID productId);

	@PutMapping("/v1/product")
	void updateProduct(@RequestBody ProductDTO productDTO);

}
