package com.coltraneinvoices.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findByProduct_ProductId(Long productId);
	
	Product findByProduct_ProductCategory(String productCategory);
	
	Product findByProduct_ProductName(String productName);
	
	boolean existsById(Long productId);
	
	List<Product> findByStockGreaterThan(Long amount);
	
	List<Product> findByAvailableTrue();
	
}