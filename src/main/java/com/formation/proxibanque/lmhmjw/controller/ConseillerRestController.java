package com.formation.proxibanque.lmhmjw.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.proxibanque.lmhmjw.entity.Conseiller;
import com.formation.proxibanque.lmhmjw.entity.Personne;
import com.formation.proxibanque.lmhmjw.repository.ConseillerRepository;
import com.formation.proxibanque.lmhmjw.service.ConseillerServiceImpl;

@RestController
public class ConseillerRestController {
	
	@Autowired
	private ConseillerServiceImpl serviceImpl;
	
	@Autowired
	private ConseillerRepository conseillerRepository;

	public ConseillerRestController(ConseillerServiceImpl serviceImpl) {
		this.serviceImpl = serviceImpl;
	}
	
	Personne p1 = new Personne("Lassale", "Jean");
	Personne p2 = new Personne("Hidalgo", "Anne");
	Personne p3 = new Personne("Cena", "John");
	
	@PostConstruct
	public void LoaderConseiller() {
		List<Conseiller> listCons = List.of(
		new Conseiller(p1),
		new Conseiller(p2),
		new Conseiller(p3)
		);
		conseillerRepository.saveAll(listCons);
	}


	@GetMapping(path = "/conseillers")
	public List<Conseiller> ListConseiller(){
		return serviceImpl.findAllConseillers();
	}
	
	@GetMapping(path = "/conseillers/{id}")
	public Conseiller getConseiller(@PathVariable Long id) {
		return serviceImpl.findConseillerById(id);
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
