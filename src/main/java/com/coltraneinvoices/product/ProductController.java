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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Productos", description = "API Endpoints para gestión de productos")
public class ProductController {

	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	
    @GetMapping("/{id}")
    @Operation(summary = "Obtener producto por ID")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Producto localizado exitosamente"),
		@ApiResponse(responseCode = "400", description = "Datos inválidos"),
		@ApiResponse(responseCode = "404", description = "Producto no encontrado")
		})
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
    
    @GetMapping
    @Operation(summary = "Obtener un listado de todos los productos")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Listado de productos generado"),
		@ApiResponse(responseCode = "404", description = "No se han encontrado productos")
		})
    public List<ProductDTO> getAllProducts() {
    		return productService.getAllProducts();
    }
    
    @PostMapping
	@Operation(summary = "Crear nuevo producto", 
    description = "Crea un nuevo producto en el inventario a partir de los datos proporcionados") 
	@ApiResponses(value = {
		@ApiResponse(responseCode = "201", description = "Producto creado exitosamente"),
		@ApiResponse(responseCode = "400", description = "Datos inválidos"),
		@ApiResponse(responseCode = "404", description = "Cliente o producto no encontrado")
		})
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO dto) {
    		Product createdProduct = productService.createProduct(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
	}
    
    @PutMapping("/{id}")
	@Operation(summary = "Actualiza a un producto existente con los datos proporcionados")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Producto actualizado exitosamente"),
			@ApiResponse(responseCode = "400", description = "Datos inválidos"),
			@ApiResponse(responseCode = "404", description = "Producto no encontrado")
			})
    public Product updateProductById(@PathVariable Long id, @RequestBody ProductDTO dto) {
    		return productService.updateProduct(id, dto);
    }

    @DeleteMapping("/{id}")
	@Operation(summary = "Elimina el producto cuyo ID se proporcione")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Producto eliminado exitosamente"),
			@ApiResponse(responseCode = "400", description = "Datos inválidos"),
			@ApiResponse(responseCode = "404", description = "Producto no encontrado")
			})
    public void deleteProductById(@PathVariable Long id) {
    		productService.deleteProductById(id);
    }

}