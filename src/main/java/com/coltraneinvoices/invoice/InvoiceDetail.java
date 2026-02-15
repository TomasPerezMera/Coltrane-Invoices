package com.coltraneinvoices.invoice;

import java.math.BigDecimal;

import com.coltraneinvoices.product.Product;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(name = "Detalle de Factura", description = "Modelo de detalle interno de la factura")

public class InvoiceDetail {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(name = "ID del detalle de factura", requiredMode = Schema.RequiredMode.REQUIRED)
	private Long detailId;
	
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	@Schema(name = "ID del producto", requiredMode = Schema.RequiredMode.REQUIRED)
	private Product product;
	
	
	@ManyToOne
	@JoinColumn(name = "invoice_id")
	@Schema(name = "ID de la factura que se detalla", requiredMode = Schema.RequiredMode.REQUIRED)
	private Invoice invoice;
	
	@Schema(name = "Cantidad de productos")
    private Long productQuantity;
    
	
	@Schema(name = "Precio por unidad")
    private BigDecimal unitPrice;
    
	@Schema(name = "Subtotal")
    private BigDecimal subtotal;
	
}