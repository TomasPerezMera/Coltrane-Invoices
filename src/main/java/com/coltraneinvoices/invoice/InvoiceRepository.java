package com.coltraneinvoices.invoice;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long>{

	List<Invoice> findByCustomer_CustomerId(Long id);
	
	List<Invoice> findByInvoiceDateBetween(OffsetDateTime start, OffsetDateTime end);
	
}