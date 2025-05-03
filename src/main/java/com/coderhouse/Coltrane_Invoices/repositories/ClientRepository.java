package com.coderhouse.Coltrane_Invoices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderhouse.Coltrane_Invoices.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> { }

}