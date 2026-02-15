package com.coltraneinvoices.product;

import java.math.BigDecimal;
import java.util.List;

import com.coltraneinvoices.invoice.InvoiceDetail;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Producto", description = "Modelo de Producto")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    @Schema(name = "ID del producto", example = "1")
    private Long productId;
	
    
    @Column(name = "product_name", nullable = false, unique = true, length = 100)
    @Schema(name = "Nombre del producto", example = "Giant Steps")
    private String name;
    
    
    @Column(name = "product_description", nullable = false, columnDefinition = "TEXT")
    @Schema(name = "Descripción del producto")
    private String description;
    
    
    @Column(name = "cover_img_source", nullable = false)
    @Schema(name = "PATH de la imagen de portada del producto", example = "./images/covers/ascension.jpg")
    private String coverImageSource;
    
    
    @Schema(name = "Precio actual del producto")
    @Column(name = "current_price", nullable = false, precision = 15, scale = 2)
    private BigDecimal currentPrice;
    
    
    @Schema(name = "Stock disponible del producto")
    @Column(name = "stock")
    private Long stock;
    
    
    @Schema(name = "Categoría del producto")
    @Column(name = "product_category")
    private String category;
    
    
    @Builder.Default
    @Column(name = "is_available")
    private Boolean isAvailable = true;
    
    
    @OneToMany(mappedBy = "product")
    private List<InvoiceDetail> details;
    
}