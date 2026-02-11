package com.coltraneinvoices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coltraneinvoices.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}

