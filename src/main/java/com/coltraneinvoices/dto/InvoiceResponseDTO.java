package com.coltraneinvoices.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceResponseDTO {
	
    private Long invoiceId;
    private OffsetDateTime invoiceDate;
    private CustomerDTO customer;
    private List<DetailResponseDTO> details;
    private Long productTotal;
    private List<String> errors;
    
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DetailResponseDTO {
    		private Long invoiceId;
    		private Long detailId;
        private BigDecimal subtotal;
        private Integer productQuantity;        
        private BigDecimal unitPrice;
    }    
}
