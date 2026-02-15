package com.coltraneinvoices.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Modelo para manejar respuestas de error")
public class ErrorResponse {

    private final String code;
    private final String message;
	
}