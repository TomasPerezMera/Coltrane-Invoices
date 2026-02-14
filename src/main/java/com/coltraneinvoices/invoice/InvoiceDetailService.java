package com.coltraneinvoices.invoice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coltraneinvoices.dto.InvoiceDetailDTO;

@Service
public class InvoiceDetailService {
	
	private final InvoiceDetailRepository invoiceDetailRepository;
	
	public InvoiceDetailService(InvoiceDetailRepository invoiceDetailRepository) {
		this.invoiceDetailRepository = invoiceDetailRepository;
	}
	
	public List<InvoiceDetailDTO> getDetailsByInvoice(Long invoiceId) {
	    return invoiceDetailRepository.findByInvoice_InvoiceId(invoiceId)
	            .stream()
	            .map(this::convertToDTO)
	            .toList();
	}

	private InvoiceDetailDTO convertToDTO(InvoiceDetail detail) {
	    return InvoiceDetailDTO.builder()
	            .invoiceDetailId(detail.getDetailId())
	            .productId(detail.getProduct().getProductId())
	            .invoiceId(detail.getInvoice().getInvoiceId())
	            .quantity(detail.getProductQuantity())
	            .unitPrice(detail.getUnitPrice())
	            .subtotal(detail.getSubtotal())
	            .build();
	}

}
