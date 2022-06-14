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
import com.formation.proxibanque.lmhmjw.service.DirecteurServiceImpl;

@RestController
public class DirecteurRestController {

	private DirecteurServiceImpl directeurServiceImpl;

	

	public DirecteurRestController(DirecteurServiceImpl directeurServiceImpl) {
		this.directeurServiceImpl = directeurServiceImpl;
	}

	@GetMapping(path = "/directeurs")
	public List<Directeur> ListDirecteur(){
		return directeurServiceImpl.findAllDirecteurs();
	}
	
	@GetMapping(path = "/directeurs/{id}")
	public Directeur getdirecteur(@PathVariable Long id) {
		return directeurServiceImpl.findDirecteurById(id);
	}
	
	@PostMapping(path = "/directeurs")
	public Directeur addDirecteur(@RequestBody Directeur directeur) {
		return directeurServiceImpl.addDirecteur(directeur);
	}
	
	@PutMapping(path = "/directeurs/{id}")
	public Directeur editDirecteur(@PathVariable Long id,@RequestBody Directeur directeur) {
		directeur.setId(id);
		return directeurServiceImpl.modifDirecteur(id,directeur);
	}
	
	@DeleteMapping(path = "/directeurs/{id}")
	public void deleteDirecteur(@PathVariable Long id) {
		directeurServiceImpl.eraseDirecteurById(id);
	}
}
