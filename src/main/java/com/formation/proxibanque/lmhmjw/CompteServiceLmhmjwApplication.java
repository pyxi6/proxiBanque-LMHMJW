package com.formation.proxibanque.lmhmjw;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
