package com.coltraneinvoices.service;

import java.time.Clock;
import java.time.OffsetDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.coltraneinvoices.dto.TimeApiResponseDTO;

import io.swagger.v3.oas.annotations.media.Schema;


@Service
@Schema(name = "Time Provider Service", description = "Servicio dedicado a la obtención de fecha actual" + 
"utilizando la API de Time.now, con respaldo en la función Clock de JVM.")
public class TimeProvider {
		
    		private final RestTemplate restTemplate;	  
    		private final Clock clock;
    		private static final String API_URL = "https://time.now/developer/api";
		
    	    
    	    public TimeProvider(RestTemplate restTemplate, Clock clock) {
    	        this.restTemplate = restTemplate;
    	        this.clock = clock;
    	    }
    	    
	    public OffsetDateTime getCurrentUtcTime() {

	        try {
	            ResponseEntity<TimeApiResponseDTO> response =
	                    restTemplate.getForEntity(API_URL, TimeApiResponseDTO.class);

	            if (response.getBody() != null) {
	                return response.getBody().toOffsetDateTime();
	            }
	        } catch (RestClientException ex) {
	        		System.out.println("Time.now API no disponible — usando JVM Clock como sustituto!");	     
	        }
        return OffsetDateTime.now(clock);
	}
}
