package com.coltraneinvoices.invoice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Long>{

	InvoiceDetail findByInvoiceId(Long invoiceId);
	
	InvoiceDetail findByProductId(Long productId);
	
	
	
	
}
