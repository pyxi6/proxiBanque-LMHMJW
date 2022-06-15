package com.formation.proxibanque.lmhmjw.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.proxibanque.lmhmjw.entity.Agence;
import com.formation.proxibanque.lmhmjw.repository.AgenceRepository;

@Service
public class AgenceServiceImpl {
	
	@Autowired
	private AgenceRepository agenceRepository;

	public AgenceServiceImpl(AgenceRepository agenceRepository) {
		this.agenceRepository = agenceRepository;
	}
	
	public List<Agence> findAllAgenceList(){
		return agenceRepository.findAll();
	}
	
	public Agence findAgenceById(Long id) {
		return agenceRepository.findById(id).get();
	}
	
	public Agence addAgence(Agence agence) {
		agence.setDate_ouverture(LocalDate.now());
		return agenceRepository.save(agence);
	}
	
	public Agence modifAgence(Long id,Agence agence) {
		agence.setId(id);
		return agenceRepository.save(agence);
	}
	
	public void supprAgence(Long id) {
		agenceRepository.deleteById(id);
	}
	
}
