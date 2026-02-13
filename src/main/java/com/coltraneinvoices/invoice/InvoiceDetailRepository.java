package com.coltraneinvoices.invoice;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Long>{

	List<InvoiceDetail> findByInvoice_InvoiceId(Long invoiceId);
	
	InvoiceDetail findByProduct_ProductId(Long productId);
	
	InvoiceDetail findByInvoice_InvoiceDate(OffsetDateTime invoiceDate);

}