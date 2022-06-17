package com.formation.proxibanque.lmhmjw.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.formation.proxibanque.lmhmjw.entity.Compte;
import com.formation.proxibanque.lmhmjw.entity.CompteCourant;
import com.formation.proxibanque.lmhmjw.entity.CompteEpargne;
import com.formation.proxibanque.lmhmjw.entity.Customer;
import com.formation.proxibanque.lmhmjw.repository.CompteCourantRepository;
import com.formation.proxibanque.lmhmjw.repository.CompteEpargneRepository;
import com.formation.proxibanque.lmhmjw.repository.CompteRepository;
import com.formation.proxibanque.lmhmjw.repository.ConseillerRepository;
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
	
	@Autowired
	private ConseillerRepository conseillerRepository;

	@Override
	public String toString() {
		return "AuditService [compteRepository=" + compteRepository + "]";
	}
	

	/**
	 * Parametres d'entree: rien
	 * @return solde total de l'agence
	 */
	public double getSoldeTotal() {

		double soldeTotal = 0;

		List<Compte> comptes = compteRepository.findAll();
		for (Compte compte : comptes) {
			soldeTotal += compte.getSolde();
		}

		return soldeTotal;

	}
	
	/**
	 * Parametres d'entree: rien
	 * @return solde des comptes epargnes de l'agence
	 */

	public double getSoldeEpargne() {

		double soldeEpargne = 0;

		List<CompteEpargne> comptesEpargnes = compteEpargneRepository.findAll();
		for (CompteEpargne compteEpargne : comptesEpargnes) {
			soldeEpargne += compteEpargne.getSolde();
		}

		return soldeEpargne;

	}
	
	/**
	 * Parametres d'entree: rien
	 * @return solde des comptes courants de l'agence
	 */

	public double getSoldeCourant() {

		double soldeCourant = 0;

		List<CompteCourant> comptesCourants = compteCourantRepository.findAll();
		for (CompteCourant compteCourant : comptesCourants) {
			soldeCourant += compteCourant.getSolde();
		}

		return soldeCourant;

	}
	/**
	 * Parametres d'entree: rien
	 * @return liste des clients avec solde total inférieur à 0
	 */

	public List<Customer> listCustomersDeficitaires() {

		List<Customer> customers = customerRepository.findAll();
		List<Customer> customerdeficitaires = new ArrayList<>();

		for (Customer customer : customers) {
			List<Compte> comptes = customer.getComptes();
			double soldeTotal = 0;

			for (int i = 0; i < comptes.size(); i++) {
				soldeTotal += comptes.get(i).getSolde();

			}

			if (soldeTotal < 0) {
				customerdeficitaires.add(customer);
			}

		}
		return customerdeficitaires;

	}
	
	/**
	 * Parametres d'entree: rien
	 * @return liste des clients avec solde total > 500 000
	 */

	public List<Customer> listCustomersPremium() {

		List<Customer> customers = customerRepository.findAll();
		List<Customer> customerpremium = new ArrayList<>();

		for (Customer customer : customers) {
			List<Compte> comptes = customer.getComptes();
			double soldeTotal = 0;

			for (int i = 0; i < comptes.size(); i++) {
				soldeTotal += comptes.get(i).getSolde();

			}

			if (soldeTotal >= 500000) {
				customerpremium.add(customer);
			}

		}
		return customerpremium;

	}

	/**
	 * Parametres d'entree: rien
	 * @return liste des clients avec solde total < 5000
	 */

	public List<Customer> ListCustomerARisque() {

		List<Customer> customers = customerRepository.findAll();
		List<Customer> customerARisque = new ArrayList<>();

		for (Customer customer : customers) {
			List<Compte> comptes = customer.getComptes();
			double soldeTotal = 0;

			for (int i = 0; i < comptes.size(); i++) {
				soldeTotal += comptes.get(i).getSolde();

			}

			if (soldeTotal < -5000) {
				customerARisque.add(customer);
			}

		}
		return customerARisque;

	}
	
	/**
	 * Parametres d'entree: id conseiller
	 * @return nombre de clients du conseiller
	 */
	
	public int getNombreClientParConseiller(Long id) {
		List<Customer> customers = conseillerRepository.findById(id).get().getCustomers();
		int nombreDeClient=0;
		for (int i = 0; i < customers.size(); i++) {
			nombreDeClient +=1;
			
		}
				
		return nombreDeClient;
		
	}
	

}
