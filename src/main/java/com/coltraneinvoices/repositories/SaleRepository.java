package com.coltraneinvoices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coltraneinvoices.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Integer> {
}
