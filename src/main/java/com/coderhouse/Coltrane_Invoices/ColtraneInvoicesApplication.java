package com.coderhouse.Coltrane_Invoices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.coderhouse.Coltrane_Invoices.entities.Client;
import com.coderhouse.Coltrane_Invoices.entities.Sale;
import com.coderhouse.Coltrane_Invoices.services.DaoFactory;

@SpringBootApplication
public class ColtraneInvoicesApplication implements CommandLineRunner{

	
		@Autowired
		private DaoFactory dao;
		
	public static void main(String[] args) {
		SpringApplication.run(ColtraneInvoicesApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		try {
			
			dao.wipeSales();
			dao.wipeClients();
			
			Client clienteEjemplo = new Client("Tomas", "Perez", 5454554, "ejemplo@m4ail.com", "Cal4le Ejemplo 123", null);
	        Client client2 = new Client("Maria", "Lopez", 45454545, "maria@examp4le.com", "Ave4nida Central 456", null);
			
	        clienteEjemplo = dao.saveClient(clienteEjemplo);
	        client2 = dao.saveClient(client2);

	        Sale sale1 = new Sale(200.0, clienteEjemplo);
	        Sale sale2 = new Sale(150, client2);
	        
	        dao.saveSale(sale1);
	        dao.saveSale(sale2);

			
		} catch(Exception err) {
			err.printStackTrace(System.err);
		}
	}
}