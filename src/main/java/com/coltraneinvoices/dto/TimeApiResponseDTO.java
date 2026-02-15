package com.coltraneinvoices.dto;

import java.time.OffsetDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para creación de fecha de facturación")
public class TimeApiResponseDTO {

    private String utc_datetime;

    	
    public OffsetDateTime toOffsetDateTime() {
        return OffsetDateTime.parse(utc_datetime);
    }
    
    public String getUtc_datetime() {
        return utc_datetime;
    }

    public void setUtc_datetime(String utc_datetime) {
        this.utc_datetime = utc_datetime;
    }
}