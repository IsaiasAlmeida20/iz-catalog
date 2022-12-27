package br.com.izan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.izan.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
