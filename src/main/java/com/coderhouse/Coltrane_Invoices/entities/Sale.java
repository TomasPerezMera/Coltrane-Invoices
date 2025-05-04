package com.coderhouse.Coltrane_Invoices.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "sale_date", nullable = false)
    private LocalDateTime saleDate = LocalDateTime.now();
    
    @Column(name = "total_amount", nullable = false)
    private double totalAmount;
    
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
    
	public Sale() {
		super();
	}
    
    public Sale(double totalAmount, Client client) {
        this.saleDate = LocalDateTime.now();
        this.totalAmount = totalAmount;
        this.client = client;
    }
    
    public Sale(LocalDateTime saleDate, double totalAmount, Client client) {
        this.saleDate = saleDate != null ? saleDate : LocalDateTime.now();
        this.totalAmount = totalAmount;
        this.client = client;
    }
    
}
