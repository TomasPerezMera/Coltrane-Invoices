package com.coltraneinvoices.product;

import java.math.BigDecimal;
import java.util.List;

import com.coltraneinvoices.invoice.InvoiceDetail;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;
	
    
    @Column(name = "product_name", nullable = false, unique = true, length = 100)
    private String name;
    
    
    @Column(name = "product_description", nullable = false, columnDefinition = "TEXT")
    private String description;
    
    @Column(name = "cover_img_source", nullable = false)
    private String coverImageSource;
    
    
    @Column(name = "current_price", nullable = false, precision = 15, scale = 2)
    private BigDecimal currentPrice;
    
    
    @Column(name = "stock")
    private Long stock;
    
    
    @Column(name = "product_category")
    private String category;
    
    
    @Column(name = "is_available")
    private Boolean isAvailable;
    
    
    @OneToMany(mappedBy = "product")
    private List<InvoiceDetail> detalles;
    
}
