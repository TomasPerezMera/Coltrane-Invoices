package com.coltraneinvoices.dto;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO con datos del producto")
public class ProductDTO {
	
	private Long productId;
	private String name;
	private String description;
    private String coverImageSource;
	private BigDecimal currentPrice;
	private Long stock;
	private String category;
	private Boolean isAvailable;
	
}
