package com.coltraneinvoices.invoice;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.coltraneinvoices.customer.Customer;
import com.coltraneinvoices.customer.CustomerRepository;
import com.coltraneinvoices.dto.CustomerDTO;
import com.coltraneinvoices.dto.InvoiceRequestDTO;
import com.coltraneinvoices.dto.InvoiceRequestDTO.InvoiceLinesRequestDTO;
import com.coltraneinvoices.dto.InvoiceResponseDTO;
import com.coltraneinvoices.exception.InsufficientStockException;
import com.coltraneinvoices.exception.InvalidOperationException;
import com.coltraneinvoices.exception.ResourceNotFoundException;
import com.coltraneinvoices.product.Product;
import com.coltraneinvoices.product.ProductRepository;
import com.coltraneinvoices.service.TimeProvider;

@Service
public class InvoiceService {

	private final InvoiceRepository invoiceRepository;
	private final InvoiceDetailRepository invoiceDetailRepository;
	private final CustomerRepository customerRepository;
	private final ProductRepository productRepository;
	private final TimeProvider timeProvider;
	
    public InvoiceService(InvoiceRepository invoiceRepository, InvoiceDetailRepository invoiceDetailRepository, 
    		CustomerRepository customerRepository, ProductRepository productRepository, TimeProvider timeProvider) {
    	
    		this.invoiceRepository = invoiceRepository;
    		this.invoiceDetailRepository = invoiceDetailRepository;
    		this.customerRepository = customerRepository;
    		this.productRepository = productRepository;
        this.timeProvider = timeProvider;
    }
	
	public InvoiceResponseDTO createInvoice(InvoiceRequestDTO requestDTO) {
		
		Long customerId = requestDTO.getCustomer().getCustomerId();
		
	    Customer customer = customerRepository.findById(customerId)
	    		.orElseThrow(() -> new ResourceNotFoundException("Cliente", customerId));

	    // Inicializamos en 0 las variables previo al loop de cálculo del Invoice.
	    List<InvoiceDetail> details = new ArrayList<>();
	    BigDecimal totalAmount = BigDecimal.ZERO;
	    Long totalProductQuantity = 0L;

	    	// Buscamos productos de la venta.
	    for(InvoiceLinesRequestDTO line : requestDTO.getLines()) {
    			
	        Long productId = line.getProduct().getProductId();
	    		Product product = productRepository.findById(productId)
	    		.orElseThrow(() -> new ResourceNotFoundException("Producto", productId));
	    		
	    	    if (product.getStock() < line.getProductQuantity()) {
	                throw new InsufficientStockException(product.getName());
            }
	    	    
	    	    // Calculamos el subtotal de productos.
            BigDecimal subtotal = product.getCurrentPrice().multiply(BigDecimal.valueOf(line.getProductQuantity()));
            
            InvoiceDetail detail = InvoiceDetail.builder()
            		.product(product)
            		.productQuantity(line.getProductQuantity())
            		.unitPrice(product.getCurrentPrice())
            		.subtotal(subtotal)
            		.build();
            		
            details.add(detail);
            totalAmount = totalAmount.add(subtotal);
            
            // Obtenemos el total de ítems tras completar el loop:
            totalProductQuantity += line.getProductQuantity();
            
            // Reducimos stock tras la venta:
            product.setStock(product.getStock() - line.getProductQuantity());
            productRepository.save(product);
            
	    }
	    
	    // Asignamos fecha utilizando el TimeProvider Service;
	    OffsetDateTime invoiceDate = timeProvider.getCurrentUtcTime();
	    
	    Invoice invoice = Invoice.builder()
	    		.customer(customer)
	    		.invoiceDate(invoiceDate)
	    		.productTotal(totalProductQuantity)
	    		.totalAmount(totalAmount)
	    		.build();

	    	// Persistimos Invoice para generar su ID;
	    Invoice savedInvoice = invoiceRepository.save(invoice);
	    
	    // Luego asignamos el invoice a invoiceDetails para persistirlos con su ID;
	    details.forEach(detail -> detail.setInvoiceId(savedInvoice.getInvoiceId()));
	    invoiceDetailRepository.saveAll(details);
	    
	    // Por último, retornamos un llamado a construcción del DTO con los parámetros necesarios:
	    return buildResponseDTO(invoice, details, customer);
	}
	
	private InvoiceResponseDTO buildResponseDTO(Invoice invoice, 
			List<InvoiceDetail> details, Customer customer) {
	    
	    // Convertimos Customer a un CustomerDTO;
	    CustomerDTO customerDTO = CustomerDTO.builder()
	        .customerId(customer.getCustomerId())
	        .dni(customer.getDni())
	        .firstName(customer.getFirstName())
	        .lastName(customer.getLastName())
	        .email(customer.getEmail())
	        .address(customer.getAddress())
	        .phoneNumber(customer.getPhoneNumber())
	        .build();
	    
	    // Convertimos InvoiceDetail a InvoiceDetailDTO;
	    List<InvoiceResponseDTO.DetailResponseDTO> detailDTOs = new ArrayList<>();
	    for (InvoiceDetail detail : details) {
	        InvoiceResponseDTO.DetailResponseDTO detailDTO = InvoiceResponseDTO.DetailResponseDTO.builder()
	        	    .detailId(detail.getDetailId())
	        	    .invoiceId(detail.getInvoiceId())
	            .productId(detail.getProduct().getProductId())
	            .productName(detail.getProduct().getName())
	            .productQuantity(detail.getProductQuantity())
	            .unitPrice(detail.getUnitPrice())
	            .subtotal(detail.getSubtotal())
	            .build();
	        
	        detailDTOs.add(detailDTO);
	    }
	    
	    return InvoiceResponseDTO.builder()
	            .invoiceId(invoice.getInvoiceId())
	            .invoiceDate(invoice.getInvoiceDate())
	            .customer(customerDTO)
	            .details(detailDTOs)
	            .productTotal(invoice.getProductTotal())
	            .totalAmount(invoice.getTotalAmount())
	            .build();
	    }
	
	public Invoice getInvoiceById(Long invoiceId) {
		return invoiceRepository.findById(invoiceId)
			.orElseThrow(() -> new ResourceNotFoundException("Factura", invoiceId));
	}
	
	public List<InvoiceResponseDTO> getAllInvoices() {
		List<Invoice> invoices = invoiceRepository.findAll();
		
		if(invoices.isEmpty()) {
			throw new InvalidOperationException("No hay ninguna factura creada!");
		}
		
		// Iteramos sobre los invoice obtenidos para obtener los datos del DTO;
		List<InvoiceResponseDTO> responseDTOs = new ArrayList<>();
		for(Invoice invoice : invoices) {
			
			Customer customer = invoice.getCustomer();
			List<InvoiceDetail> details = invoice.getDetails();
	        InvoiceResponseDTO dto = buildResponseDTO(invoice, details, customer);
	        responseDTOs.add(dto);
	        
		}
		return responseDTOs;
	}
	
	public List<InvoiceResponseDTO> getAllInvoicesFromCustomer(Long customerId) {
		
	    Customer customer = customerRepository.findById(customerId)
	    		.orElseThrow(() -> new ResourceNotFoundException("Cliente", customerId));
	    
	    List<Invoice> invoiceList = invoiceRepository.findByCustomer_CustomerId(customerId);
	    
		List<InvoiceResponseDTO> responseDTOs = new ArrayList<>();
			for(Invoice invoice : invoiceList) {
			
				List<InvoiceDetail> details = invoice.getDetails();
		        InvoiceResponseDTO dto = buildResponseDTO(invoice, details, customer);
		        responseDTOs.add(dto);
		        
			}
			return responseDTOs;
    }
	
	public void deleteInvoiceByID(Long invoiceId) {
		if(!invoiceRepository.existsById(invoiceId)) {
			throw new InvalidOperationException("Error - la factura indicada no existe!");
		}
		invoiceRepository.deleteById(invoiceId);
	}
	
}