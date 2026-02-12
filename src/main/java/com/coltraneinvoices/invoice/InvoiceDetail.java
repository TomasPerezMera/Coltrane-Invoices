package com.coltraneinvoices.invoice;

import java.math.BigDecimal;

import com.coltraneinvoices.product.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "invoice_details")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDetail {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long detailId;
	
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	
	@ManyToOne
	@JoinColumn(name = "invoice_id")
	private Invoice invoice;
	
	
    private Integer productQuantity;
    
    private BigDecimal precioUnitario;
    
    private BigDecimal subtotal;
	
	
}
