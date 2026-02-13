package com.coltraneinvoices.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

	private Long customerId;
    private Long dni;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    
}
