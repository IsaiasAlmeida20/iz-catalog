package br.com.izan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.izan.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
