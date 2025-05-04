package com.coderhouse.Coltrane_Invoices.services;

import com.coderhouse.Coltrane_Invoices.entities.Client;
import com.coderhouse.Coltrane_Invoices.entities.Sale;
import com.coderhouse.Coltrane_Invoices.repositories.ClientRepository;
import com.coderhouse.Coltrane_Invoices.repositories.SaleRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DaoFactory {
	
	@PersistenceContext
	private EntityManager em;
	
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
    
    @Transactional
    public void wipeClients() {
    	clientRepo.deleteAll();
    }
    
    @Transactional
    public void wipeSales() {
    	saleRepo.deleteAll();
    }
}
