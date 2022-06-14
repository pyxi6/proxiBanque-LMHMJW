package com.formation.proxibanque.lmhmjw.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.proxibanque.lmhmjw.entity.Conseiller;
import com.formation.proxibanque.lmhmjw.repository.ConseillerRepository;

@RestController
public class ConseillerRestController {
	
	private ConseillerRepository conseillerRepository;

	public ConseillerRestController(ConseillerRepository conseillerRepository) {
		this.conseillerRepository = conseillerRepository;
	}
	
	@GetMapping(path = "/conseillers")
	public List<Conseiller> ListConseiller(){
		return conseillerRepository.findAll();
	}
	
	@GetMapping(path = "/conseillers/{id}")
	public Conseiller getConseiller(@PathVariable Long id) {
		return conseillerRepository.findById(id).get();
	}
	
	@PostMapping(path = "/conseillers")
	public Conseiller addConseiller(@RequestBody Conseiller conseiller) {
		return conseillerRepository.save(conseiller);
	}
	
	@PutMapping(path = "/conseillers/{id}")
	public Conseiller editConseiller(@PathVariable Long id,@RequestBody Conseiller conseiller) {
		conseiller.setId(id);
		return conseillerRepository.save(conseiller);
	}
	
	@DeleteMapping(path = "/conseillers/{id}")
	public void deleteConseiller(@PathVariable Long id) {
		conseillerRepository.deleteById(id);
	}
	
	
}
