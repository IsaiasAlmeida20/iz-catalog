package br.com.izan.tests;

import java.time.Instant;

import br.com.izan.dto.ProductDTO;
import br.com.izan.entities.Category;
import br.com.izan.entities.Product;

public class Factory {

	public static Product createProduct() {  
		Product product = new Product(1L, "Phone", "Good Phone", 1000.0, "https://img.com/img.png", Instant.parse("2022-10-13T02:00:00Z"));
		product.getCategories().add(createCategory());
		return product;
	}
	
	public static ProductDTO createProductDTO() {
		Product product = createProduct();
		return new ProductDTO(product, product.getCategories());
	}
	
	public static Category createCategory() {
		return new Category(1L, "Electronics");
	}
}
