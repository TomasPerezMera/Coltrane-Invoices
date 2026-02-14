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
public class InvoiceDetailDTO {

    private Long invoiceDetailId;
    private Long productId;
    private Long invoiceId;

    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal subtotal;
}
