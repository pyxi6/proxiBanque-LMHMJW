package com.formation.proxibanque.lmhmjw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.proxibanque.lmhmjw.entity.Customer;
import com.formation.proxibanque.lmhmjw.service.AuditService;

@RestController
public class AuditRestController {
	
	@Autowired
	private AuditService auditService;
	
	@GetMapping(path ="/directeur/balanceTotale")
	public double getBalanceTotale() {
		return auditService.getSoldeTotal();
		
	}
	
	
	@GetMapping(path ="/directeur/balanceEpargne")
	public double getBalanceEpargne() {
		return auditService.getSoldeEpargne();
		
	}
	
	@GetMapping(path ="/directeur/balanceCourant")
	public double getBalanceCourant() {
		return auditService.getSoldeCourant();
		
	}
	
	@GetMapping(path ="/directeur/customersDeficitaires")
	public List<Customer> getCustomersDeficitaires() {
		return auditService.ListCustomersDeficitaires();
	}
	
	@GetMapping(path ="/directeur/customersPremium")
	public List<Customer> getCustomersPremium() {
		return auditService.ListCustomersPremium();
	}
	
	@GetMapping(path ="/directeur/customersARisques")
	public List<Customer> getCustomersARisque() {
		return auditService.ListCustomerARisque();
	}
	
	
	

}
