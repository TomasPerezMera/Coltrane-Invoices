package com.coltraneinvoices.product;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.coltraneinvoices.dto.ProductDTO;
import com.coltraneinvoices.exception.InvalidOperationException;
import com.coltraneinvoices.exception.ResourceNotFoundException;

import jakarta.transaction.Transactional;


@Service
public class ProductService {

	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
	this.productRepository = productRepository;
	}
	
	public Product createProduct(ProductDTO dto) {
		
		Product product = Product.builder()
				.name(dto.getName())
				.description(dto.getDescription())
				.coverImageSource(dto.getCoverImageSource())
				.currentPrice(dto.getCurrentPrice())
				.stock(dto.getStock())
				.category(dto.getCategory())
				.isAvailable(dto.getIsAvailable())
				.build();

	    return productRepository.save(product);
	}
	
	public Product getProductById(Long productId) {
		return productRepository.findById(productId)
		        .orElseThrow(() -> new ResourceNotFoundException("Producto", productId));
	}
	
	public List<ProductDTO> getAllProducts() {
	    return productRepository.findAll().stream()
		        .map(this::convertToDTO)
		        .toList();
	}
	
	@Transactional
	public Product updateProduct(Long productId, ProductDTO dto) {
		
		Product product = productRepository.findById(productId)
		        .orElseThrow(() -> new ResourceNotFoundException("Producto", productId));

		if (dto.getName() != null && !dto.getName().isBlank()) {
		    product.setName(dto.getName());
		}
		if (dto.getCurrentPrice().compareTo(BigDecimal.ZERO) <= 0) {
		    throw new InvalidOperationException("Error - el precio no puede ser negativo!");
		}
		    product.setCurrentPrice(dto.getCurrentPrice());
		    
		if (dto.getDescription() != null && !dto.getDescription().isBlank()) {
		    product.setDescription(dto.getDescription());
		}
		if (dto.getCoverImageSource() != null && !dto.getCoverImageSource().isBlank()) {
		    product.setCoverImageSource(dto.getCoverImageSource());
		}
		if (dto.getStock() < 0) {
		    throw new InvalidOperationException("El stock no puede ser negativo!");
		}
			product.setStock(dto.getStock());

		if (dto.getCategory() != null && !dto.getCategory().isBlank()) {
		    product.setCategory(dto.getCategory());
		}
		
		if (dto.getIsAvailable() != null) {
		    product.setIsAvailable(dto.getIsAvailable());
		}
		
		return product;
	}
	
	public void deleteProductById(Long productId) {
		if(!productRepository.existsById(productId)) {
			throw new InvalidOperationException("Error - no existe un producto con ese ID!");
		}
		productRepository.deleteById(productId);
	}
	
	// Método para conversión Entidad -> DTO
	private ProductDTO convertToDTO(Product product) {
	    return ProductDTO.builder()
	        .productId(product.getProductId())
	        .name(product.getName())
	        .currentPrice(product.getCurrentPrice())
	        .stock(product.getStock())
	        .coverImageSource(product.getCoverImageSource())
	        .category(product.getCategory())
	        .description(product.getDescription())
	        .isAvailable(product.getIsAvailable())
	        .build();
	}	
}
