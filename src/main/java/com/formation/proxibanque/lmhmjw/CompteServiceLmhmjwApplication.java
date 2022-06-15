package com.formation.proxibanque.lmhmjw;

import com.formation.proxibanque.lmhmjw.entity.Adresse;

import com.formation.proxibanque.lmhmjw.entity.Compte;
import com.formation.proxibanque.lmhmjw.entity.Customer;
import com.formation.proxibanque.lmhmjw.entity.enums.TypeCompte;
import com.formation.proxibanque.lmhmjw.repository.CompteRepository;
import com.formation.proxibanque.lmhmjw.repository.CustomerRepository;
import com.formation.proxibanque.lmhmjw.repository.OpperationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CompteServiceLmhmjwApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompteServiceLmhmjwApplication.class, args);
//	}
//
//	
//	Adresse adresse1 = new Adresse("8 rue Perlimpimpin", "92800", "Puteaux");
//	Adresse adresse2 = new Adresse("7 rue Delay", "92100", "Boulogne");
//	Adresse adresse3 = new Adresse("11 rue de la Liberté", "95620", "Parmain");
//
//
//	
//	@Bean
//	CommandLineRunner Start(CustomerRepository customerRepository) {
//		return args -> {
//			
//			customerRepository.save(new Customer(1L, "Jean", "DeLaFontaine", "0123654778", adresse1));
//			customerRepository.save(new Customer(2L, "Karim", "BenHakhlef", "0123625648", adresse2));
//			customerRepository.save(new Customer(3L, "Etienne", "Dufour", "0178654778", adresse3));
//
//
//			// finAll recupere tous les compte
//			// foreach parcour la liste
//			customerRepository.findAll().forEach(customer -> {
//				System.out.println(customer.getId());
//				System.out.println(customer.getNom());
//				System.out.println(customer.getPrenom());
//				System.out.println(customer.getNumTel());
//				System.out.println(customer.getAdresse());
//
//
//			});
//
//		};		
	}
	
	
}
