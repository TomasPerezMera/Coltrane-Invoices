package com.coltraneinvoices.invoice;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coltraneinvoices.service.TimeProvider;

@Service
public class InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;	

	private final TimeProvider timeProvider;
	
    public InvoiceService(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }
	
	public Invoice createInvoice(Invoice invoice) {

	    OffsetDateTime utcNow = timeProvider.getCurrentUtcTime();

	    invoice.setInvoiceDate(utcNow);

	    return invoiceRepository.save(invoice);
	}
	
}
