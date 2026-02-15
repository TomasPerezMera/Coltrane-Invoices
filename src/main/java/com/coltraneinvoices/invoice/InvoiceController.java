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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/invoices")
@Tag(name = "Facturas", description = "API Endpoints para gestión de facturas")
public class InvoiceController {

	private final InvoiceService invoiceService;
	
	public InvoiceController(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}
	
	@GetMapping("/{id}")
    @Operation(summary = "Obtener factura por ID")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Factura localizada exitosamente"),
		@ApiResponse(responseCode = "400", description = "Datos inválidos"),
		@ApiResponse(responseCode = "404", description = "Factura no encontrada")
		})
	public Invoice getInvoiceById(@PathVariable Long id) {
		return invoiceService.getInvoiceById(id);
	}
	
	@GetMapping
    @Operation(summary = "Obtener un listado de todas las facturas")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Listado de facturas generado"),
		@ApiResponse(responseCode = "404", description = "No se han encontrado facturas")
		})
	public List<InvoiceResponseDTO> getAllInvoices() {
		return invoiceService.getAllInvoices();
	}
	
	@PostMapping
	@Operation(summary = "Crear nueva factura", 
    description = "Procesa una venta creando una factura con sus detalles") 
	@ApiResponses(value = {
		@ApiResponse(responseCode = "201", description = "Factura creada exitosamente"),
		@ApiResponse(responseCode = "400", description = "Datos inválidos o stock insuficiente"),
		@ApiResponse(responseCode = "404", description = "Cliente o producto no encontrado")
		})
	public ResponseEntity<InvoiceResponseDTO> createInvoice(@RequestBody InvoiceRequestDTO requestDTO) {
		InvoiceResponseDTO response = invoiceService.createInvoice(requestDTO);
	    return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Elimina la factura cuyo ID se proporcione")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Factura eliminada exitosamente"),
			@ApiResponse(responseCode = "400", description = "Datos inválidos"),
			@ApiResponse(responseCode = "404", description = "Factura no encontrada")
			})
	public void deleteInvoiceById(Long invoiceId) {
		invoiceService.deleteInvoiceByID(invoiceId);
	}
	
}