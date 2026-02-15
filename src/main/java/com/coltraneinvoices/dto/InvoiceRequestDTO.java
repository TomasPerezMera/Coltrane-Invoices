package com.coltraneinvoices.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO para crear una nueva factura")
public class InvoiceRequestDTO {

	// Variables y sub-DTOs para manejar recepción de IDs desde la API.
	private CustomerRefDTO customer;
    private List<InvoiceLinesRequestDTO> lines;
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor    
    @Schema(description = "Referencia al cliente", example = "{\"customerId\": 1}")
    @NotNull(message = "Se requiere un ID de cliente!")
    public static class CustomerRefDTO {
        private Long customerId;
    }
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(description = "Referencia al producto", example = "{\"productId\": 1}")
    @NotNull(message = "Se requiere un ID de producto!")
    @NotEmpty(message = "Debe incluir al menos un producto!")
    public static class ProductRefDTO {
        private Long productId;
    }
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(description = "DTO para el detalle de la factura" + "Contiene cantidad, producto.")
    public static class InvoiceLinesRequestDTO {
    	
	    	@NotNull(message = "La cantidad es obligatoria")
	    	@Positive(message = "La cantidad debe ser positiva")
    		private Long amount;
	    	
        @NotEmpty(message = "Debe incluir al menos un producto!")
    		private ProductRefDTO product;
    }
    
}