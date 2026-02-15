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
@Schema(description = "DTO para el detalle interno de la factura")
public class InvoiceDetailDTO {

    private Long invoiceDetailId;
    private Long productId;
    private Long invoiceId;

    private Long quantity;
    private BigDecimal unitPrice;
    private BigDecimal subtotal;
}