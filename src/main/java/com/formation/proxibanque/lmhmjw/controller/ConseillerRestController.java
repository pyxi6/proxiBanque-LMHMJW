package com.formation.proxibanque.lmhmjw.controller;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.proxibanque.lmhmjw.entity.Adresse;
import com.formation.proxibanque.lmhmjw.entity.Agence;
import com.formation.proxibanque.lmhmjw.entity.Conseiller;
import com.formation.proxibanque.lmhmjw.entity.Customer;
import com.formation.proxibanque.lmhmjw.repository.ConseillerRepository;
import com.formation.proxibanque.lmhmjw.service.ConseillerServiceImpl;

@RestController
public class ConseillerRestController {
	
	private ConseillerServiceImpl serviceImpl;
	

	public ConseillerRestController(ConseillerServiceImpl serviceImpl) {
		this.serviceImpl = serviceImpl;
	}

	@GetMapping(path = "/conseillers")
	public List<Conseiller> ListConseiller(){
		return serviceImpl.findAllConseillers();
	}
	
	@GetMapping(path = "/conseillers/{id}")
	public Conseiller getConseiller(@PathVariable Long id) {
		return serviceImpl.findConseillerById(id);
	}
	
	@GetMapping(path = "/conseillers/{id}/clients")
	public List<Customer> GetCustomerByConseiller(@PathVariable Long id){
		return serviceImpl.ListCustomerByConseiller(id);
	}
	
	@PostMapping(path = "/conseillers")
	public Conseiller addConseiller(@RequestBody Conseiller conseiller) {
		return serviceImpl.addConseiller(conseiller);
	}
	
	@PutMapping(path = "/conseillers/{id}")
	public Conseiller editConseiller(@PathVariable Long id,@RequestBody Conseiller conseiller) {

		return serviceImpl.modifConseiller(id,conseiller);
	}
	
	@DeleteMapping(path = "/conseillers/{id}")
	public void deleteConseiller(@PathVariable Long id) {
		serviceImpl.eraseConseillerById(id);
	}
	
	
}
