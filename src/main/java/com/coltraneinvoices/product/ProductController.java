package com.coltraneinvoices.product;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.coltraneinvoices.dto.ProductDTO;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
    
    @GetMapping
    public List<ProductDTO> getAllProducts() {
    		return productService.getAllProducts();
    }
    
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO dto) {
    		Product createdProduct = productService.createProduct(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
	}
    
    @PutMapping("/{id}")
    public Product updateProductById(@PathVariable Long id, @RequestBody ProductDTO dto) {
    		return productService.updateProduct(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
    		productService.deleteProductById(id);
    }

}

