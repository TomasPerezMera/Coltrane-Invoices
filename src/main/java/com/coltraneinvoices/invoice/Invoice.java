package com.coltraneinvoices.invoice;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import com.coltraneinvoices.customer.Customer;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "invoices")
@Schema(name = "Factura", description = "Modelo de Factura")

public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(name = "ID de la factura", example = "123")
    @Column(name = "invoice_id")
    private Long invoiceId;
	
    @Schema(name = "Fecha de la factura", requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(name = "invoice_date", nullable = false, updatable = false)
    private OffsetDateTime invoiceDate;
    
    
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @Schema(name = "ID del cliente", example = "1")
    private Customer customer;
    
    
    @Column(name = "product_total", nullable = false)
    @Schema(name = "Cantidad total de productos", example = "5")
    private Long productTotal;
    
    
    @Schema(name = "Monto total de la compra")
    @Column(name = "total_amount", nullable = false)
    private BigDecimal totalAmount;

    @Schema(name = "Detalle de la factura")
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
    private List<InvoiceDetail> details;
    
}
