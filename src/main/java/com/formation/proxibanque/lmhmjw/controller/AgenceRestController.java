package com.formation.proxibanque.lmhmjw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.proxibanque.lmhmjw.entity.Agence;
import com.formation.proxibanque.lmhmjw.service.AgenceServiceImpl;

@RestController
public class AgenceRestController {
	
	@Autowired
	private AgenceServiceImpl agenceServiceImpl;

	public AgenceRestController(AgenceServiceImpl agenceServiceImpl) {
		this.agenceServiceImpl = agenceServiceImpl;
	}
	
	@GetMapping(path = "/agences")
	public List<Agence> getAllAgenceList(){
		return agenceServiceImpl.findAllAgenceList();
	}
	
	@GetMapping(path = "/agences/{id}")
	public Agence GetAgenceById(@PathVariable Long id) {
		return agenceServiceImpl.findAgenceById(id);
	}
	@PostMapping(path = "/agences")
	public Agence newAgence(@RequestBody Agence agence) {
		return agenceServiceImpl.addAgence(agence);
	}
	@PutMapping(path = "/agences/{id}")
	public Agence editAgence(@PathVariable Long id,@RequestBody Agence agence) {
		return agenceServiceImpl.modifAgence(id, agence);
	}
	@DeleteMapping(path = "/agences/{id}")
	public void deleteAgence(@PathVariable Long id) {
		agenceServiceImpl.supprAgence(id);;
	}
}
