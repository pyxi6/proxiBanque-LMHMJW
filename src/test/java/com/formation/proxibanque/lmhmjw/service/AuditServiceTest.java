package com.formation.proxibanque.lmhmjw.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.formation.proxibanque.lmhmjw.entity.Customer;

@SpringBootTest
public class AuditServiceTest {

	@Autowired
	private AuditService auditService;

	@Test
	public void get_solde_total_agence() {
		double soldeTotal = auditService.getSoldeTotal();
		assertEquals(558550, soldeTotal);
	}
	@Test
	public void get_solde_total_compte_epargne() {
		double soldeEpargne = auditService.getSoldeEpargne();
		assertEquals(536200, soldeEpargne);
	}
	
	@Test
	public void get_solde_total_compte_courant() {
		double soldeCourant = auditService.getSoldeCourant();
		assertEquals(22350, soldeCourant);
	}
	
	@Test
	public void list_Customers_Deficitaires() {
		int nbCustomerDeficitaires = 0;
		List<Customer> customersDeficitaires = auditService.listCustomersDeficitaires();
		System.out.println();
		for (Customer customer : customersDeficitaires) {

			nbCustomerDeficitaires+=1;
		}
		assertEquals(4, nbCustomerDeficitaires);
		
	}
	
	@Test
	public void list_customers_premium() {
		int nbCustomerPremium=0;
		List<Customer> customersPremium = auditService.listCustomersPremium();
		for (Customer customer : customersPremium) {
			nbCustomerPremium+=1;
		}
		assertEquals(2, nbCustomerPremium);
		
	}
	
	

}
