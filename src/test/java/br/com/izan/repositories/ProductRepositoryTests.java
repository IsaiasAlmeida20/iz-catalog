package br.com.izan.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import br.com.izan.entities.Product;
import br.com.izan.tests.Factory;

@DataJpaTest
public class ProductRepositoryTests {

	@Autowired
	private ProductRepository repository;
	
	private Long existingId;
	private Long nonExistingId;
	private Long countTotalProduct;
	
	@BeforeEach
	void setUp() throws Exception {
		existingId = 1L;
		nonExistingId = 1000L;
		countTotalProduct = 25L;
	}
	
	@Test
	public void saveShouldPersistWithAutoincrementeWhenIdIsNull() {
		
		Product product = Factory.createProduct();
		product.setId(null);
		
		product = repository.save(product);
		
		Assertions.assertNotNull(product.getId());
		Assertions.assertEquals(countTotalProduct + 1, product.getId());
	}
	
	@Test
	public void findByIdShouldReturnOptionalProductNotEmptyWhenIdExists() {
			
		Optional<Product> result = repository.findById(existingId);
		
		Assertions.assertTrue(result.isPresent());
	}
	
	@Test
	public void findByIdShouldReturnOptionalProductEmptyWhenIdDoesNotExists() {
		
		Optional<Product> result = repository.findById(nonExistingId);
		
		Assertions.assertTrue(result.isEmpty());
	}

	@Test
	public void deleteShouldDeleteObjectWhenIdExists() {
		
		repository.deleteById(existingId);
		
		Optional<Product> result = repository.findById(existingId);
		Assertions.assertFalse(result.isPresent());
	}
	
	@Test
	public void deleteShouldThrowEmptyResultDataAccessExceptionWhenIdDoesNotExists() {
		
		Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
			repository.deleteById(nonExistingId);	
		});
	}
}
