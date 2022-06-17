package com.formation.proxibanque.lmhmjw.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.proxibanque.lmhmjw.entity.Compte;
import com.formation.proxibanque.lmhmjw.entity.CompteCourant;
import com.formation.proxibanque.lmhmjw.entity.CompteEpargne;
import com.formation.proxibanque.lmhmjw.entity.Customer;
import com.formation.proxibanque.lmhmjw.repository.CompteCourantRepository;
import com.formation.proxibanque.lmhmjw.repository.CompteEpargneRepository;
import com.formation.proxibanque.lmhmjw.repository.CompteRepository;
import com.formation.proxibanque.lmhmjw.repository.CustomerRepository;
import com.formation.proxibanque.lmhmjw.repository.DirecteurRepository;

@Service
public class AuditService {
	
	
	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private CompteEpargneRepository compteEpargneRepository;
	
	@Autowired
	private CompteCourantRepository compteCourantRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	

	
	
	

	@Override
	public String toString() {
		return "AuditService [compteRepository=" + compteRepository + "]";
	}


	public double getSoldeTotal() {
		
		double soldeTotal = 0;
		
		List<Compte> comptes = compteRepository.findAll();
		for (Compte compte : comptes) {
			soldeTotal += compte.getSolde();	
		}
		
		return soldeTotal;
		
	}
	
	public double getSoldeEpargne(){
		
		double soldeEpargne = 0;
		
		List<CompteEpargne> comptesEpargnes = compteEpargneRepository.findAll();
		for (CompteEpargne compteEpargne : comptesEpargnes) {
			soldeEpargne += compteEpargne.getSolde();	
		}
		
		return soldeEpargne;
		
	}
	
	public double getSoldeCourant(){
		
		double soldeCourant = 0;
		
		List<CompteCourant> comptesCourants = compteCourantRepository.findAll();
		for (CompteCourant compteCourant : comptesCourants) {
			soldeCourant += compteCourant.getSolde();	
		}
		
		return soldeCourant;
		
	}
	
	public List<Customer> ListCustomersDeficitaires(){
		
		
		List<Customer> customers = customerRepository.findAll();
		List<Customer> customerdeficitaires = new ArrayList<>();
		
		for (Customer customer : customers) {
			List<Compte> comptes = customer.getComptes();
			double soldeTotal = 0;

			for (int i = 0; i < comptes.size(); i++ ) {
				soldeTotal += comptes.get(i).getSolde() ;
				
			}
			
			if (soldeTotal < 0) {
				customerdeficitaires.add(customer);
			}
			
		}
		return customerdeficitaires ;
		
		
	}
	
	
	

}
