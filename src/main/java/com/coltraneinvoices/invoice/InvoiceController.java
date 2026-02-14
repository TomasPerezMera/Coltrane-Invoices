package com.coltraneinvoices.invoice;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coltraneinvoices.dto.InvoiceRequestDTO;
import com.coltraneinvoices.dto.InvoiceResponseDTO;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

	private final InvoiceService invoiceService;
	
	public InvoiceController(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}
	
	@GetMapping("/{id}")
	public Invoice getInvoiceById(@PathVariable Long id) {
		return invoiceService.getInvoiceById(id);
	}
	
	@GetMapping
	public List<InvoiceResponseDTO> getAllInvoices() {
		return invoiceService.getAllInvoices();
	}
	
	@PostMapping
	public ResponseEntity<InvoiceResponseDTO> createInvoice(@RequestBody InvoiceRequestDTO requestDTO) {
		InvoiceResponseDTO response = invoiceService.createInvoice(requestDTO);
	    return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@DeleteMapping("/{id}")
	public void deleteInvoiceById(Long invoiceId) {
		invoiceService.deleteInvoiceByID(invoiceId);
	}
	
}