package com.coltraneinvoices.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findByProductId(Long productId);
	
	List<Product> findByCategory(String category);
	
	List<Product> findByName(String name);
	
	boolean existsById(Long productId);
	
	List<Product> findByStockGreaterThan(Long amount);
	
	List<Product> findByIsAvailableTrue();
	
}