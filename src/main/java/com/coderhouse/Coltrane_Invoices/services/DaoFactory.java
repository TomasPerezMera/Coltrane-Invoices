package com.coderhouse.Coltrane_Invoices.services;

import com.coderhouse.Coltrane_Invoices.entities.Client;
import com.coderhouse.Coltrane_Invoices.entities.Sale;
import com.coderhouse.Coltrane_Invoices.repositories.ClientRepository;
import com.coderhouse.Coltrane_Invoices.repositories.SaleRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DaoFactory {
	
    @Autowired
    private ClientRepository clientRepo;

    @Autowired
    private SaleRepository saleRepo;
    
    @Transactional
    public Client saveClient(Client client) {
        return clientRepo.save(client);
    }
    
    @Transactional
    public Sale saveSale(Sale sale) {
        return saleRepo.save(sale);
    }
}
