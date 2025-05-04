package com.coderhouse.Coltrane_Invoices.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "clients")
public class Client {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String surname;
	
	private int dni;
	
	private String email;
	
	private String address;
	
	private LocalDateTime createdAt;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private List<Sale> sales = new ArrayList<>();	
	
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
