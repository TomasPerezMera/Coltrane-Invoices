package com.coltraneinvoices.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceRequestDTO {

	// Variables y sub-DTOs para manejar recepción de IDs desde la API.
	private CustomerRefDTO customer;
    private List<InvoiceLinesRequestDTO> lines;
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CustomerRefDTO {
        private Long customerId;
    }
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProductRefDTO {
        private Long productId;
    }
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InvoiceLinesRequestDTO {
    		private Long amount;
    		private ProductRefDTO product;
    }
    
}
