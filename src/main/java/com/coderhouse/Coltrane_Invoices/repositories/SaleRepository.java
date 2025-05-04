package com.coderhouse.Coltrane_Invoices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.coderhouse.Coltrane_Invoices.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Integer> {
}
