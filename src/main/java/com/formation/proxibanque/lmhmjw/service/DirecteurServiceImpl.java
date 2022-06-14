package com.formation.proxibanque.lmhmjw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.proxibanque.lmhmjw.entity.Directeur;
import com.formation.proxibanque.lmhmjw.repository.DirecteurRepository;

@Service
public class DirecteurServiceImpl {

	@Autowired
	private DirecteurRepository directeurRepository;

	public DirecteurServiceImpl(DirecteurRepository directeurRepository) {
		this.directeurRepository = directeurRepository;
	}
	
	public List<Directeur> findAllDirecteurs(){
		return directeurRepository.findAll();
	}
	
	public Directeur findDirecteurById(Long id) {
		return directeurRepository.findById(id).get();
	}
	
	public Directeur addDirecteur(Directeur Directeur) {
		return directeurRepository.save(Directeur);
	}
	
	public Directeur modifDirecteur(Long id, Directeur Directeur) {
		Directeur.setId(id);
		return directeurRepository.save(Directeur);
	}
	
	public void eraseDirecteurById(Long id) {
		directeurRepository.deleteById(id);
	}
	
	
}
