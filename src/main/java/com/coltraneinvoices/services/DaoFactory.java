package com.coltraneinvoices.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coltraneinvoices.entities.Client;
import com.coltraneinvoices.entities.Sale;
import com.coltraneinvoices.repositories.ClientRepository;
import com.coltraneinvoices.repositories.SaleRepository;


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
