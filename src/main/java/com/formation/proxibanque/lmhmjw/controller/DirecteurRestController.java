package com.formation.proxibanque.lmhmjw.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.proxibanque.lmhmjw.entity.Directeur;
import com.formation.proxibanque.lmhmjw.repository.DirecteurRepository;

@RestController
public class DirecteurRestController {

	private DirecteurRepository directeurRepository;

	public DirecteurRestController(DirecteurRepository directeurRepository) {
		this.directeurRepository = directeurRepository;
	}

	@GetMapping(path = "/directeurs")
	public List<Directeur> ListDirecteur(){
		return directeurRepository.findAll();
	}
	
	@GetMapping(path = "/directeurs/{id}")
	public Directeur getdirecteur(@PathVariable Long id) {
		return directeurRepository.findById(id).get();
	}
	
	@PostMapping(path = "/directeurs")
	public Directeur addDirecteur(@RequestBody Directeur directeur) {
		return directeurRepository.save(directeur);
	}
	
	@PutMapping(path = "/directeurs/{id}")
	public Directeur editDirecteur(@PathVariable Long id,@RequestBody Directeur directeur) {
		directeur.setId(id);
		return directeurRepository.save(directeur);
	}
	
	@DeleteMapping(path = "/directeurs/{id}")
	public void deleteDirecteur(@PathVariable Long id) {
		directeurRepository.deleteById(id);
	}
}
