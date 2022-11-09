package com.nttdata;

import java.time.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.persistence.Client;
import com.nttdata.persistence.Contract;
import com.nttdata.services.ClientServiceI;
import com.nttdata.services.ContractServiceI;


/**
 * 
 * Clase principal
 * 
 * @author Sebastián Forte
 *
 */
@SpringBootApplication
public class NTTDataMain implements CommandLineRunner {

	/** Servicio de clientes */
	@Autowired
	private ClientServiceI clientServ;
	
	@Autowired
	private ContractServiceI contractServ;


	/**
	 * Metodo principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(NTTDataMain.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Client client1 = new Client("Jose Maria", "Pietra", "65479874S");
		clientServ.addClient(new Client("Pedro", "Pastor", "12345678T"));
		clientServ.addClient(new Client("Santi", "Sano", "87654321E"));
		clientServ.addClient(new Client("Pedro", "Sunderland", "12365478V"));
		clientServ.addClient(new Client("Juan", "Tonos", "98765432F"));
		clientServ.addClient(client1);
		
		
		for(Client client : clientServ.getAllClients()) {
			System.out.println(client.toString());
		}
	
		for(Client client : clientServ.getClientByNameAndLastName("Pedro", "Pastor")) {
			System.out.println(client.toString());
		}
		
		client1.setName("Chema");
		clientServ.updateClient(client1);
		
		System.out.println(clientServ.getClientById(5).toString());
		
		
		Contract contract1 = new Contract(LocalDate.of(2022, 11, 9), LocalDate.of(2023, 11, 9), 350L, client1);
		contractServ.addContract(contract1);
		contractServ.addContract(new Contract(LocalDate.of(2018, 6, 10), LocalDate.of(2018, 6, 10), 150L, client1));
		
		for(Contract contract : contractServ.getAllContracts()) {
			System.out.println(contract.toString());
		}
		
		contract1.setPrice(500L);
		contractServ.updateContract(contract1);
		
		System.out.println(contractServ.getContractById(6).toString()); //El generador de ids es compartido, así que este contrato tendrá el id 6.
		
		
	}

}
