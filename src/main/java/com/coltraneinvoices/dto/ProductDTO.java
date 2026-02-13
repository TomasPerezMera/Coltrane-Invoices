package com.coltraneinvoices.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	
	private Long productId;
	private String name;
	private String description;
	private BigDecimal currentPrice;
	private Long stock;
	private String category;
	private Boolean isAvailable;
	
}
