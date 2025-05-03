package com.coderhouse.Coltrane_Invoices.entities;

import java.time.LocalDateTime;

public class Client {

	private int id;
	
	private String name;
	
	private String surname;
	
	private int dni;
	
	private String email;
	
	private String address;
	
	private LocalDateTime createdAt;
	
	
	public Client() {
		super();
	}


	public Client(int id, String name, String surname, int dni, String email, String address,
			LocalDateTime createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.dni = dni;
		this.email = email;
		this.address = address;
		this.createdAt = createdAt;
	}
	
}
