package com.coltraneinvoices.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO para respuesta con datos completos de la factura creada")
public class InvoiceResponseDTO {
	
	@Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long invoiceId;
    
	private OffsetDateTime invoiceDate;
    private CustomerDTO customer;
    private List<DetailResponseDTO> details;
    private Long productTotal;
    private BigDecimal totalAmount;
    private List<String> errors;
    
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(description = "DTO interno para el detalle de la factura creada")
    public static class DetailResponseDTO {
    		private Long productId;
    		private String productName;
    		private Long invoiceId;
    		private Long detailId;
        private BigDecimal subtotal;
        private Long productQuantity;        
        private BigDecimal unitPrice;
    }
    
}