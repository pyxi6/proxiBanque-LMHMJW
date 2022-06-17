package com.formation.proxibanque.lmhmjw.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.formation.proxibanque.lmhmjw.repository.CompteCourantRepository;
import com.formation.proxibanque.lmhmjw.repository.CompteEpargneRepository;
import com.formation.proxibanque.lmhmjw.repository.CompteRepository;

public class CompteUIController {
	
	  @Autowired
	    private CompteRepository compteRepository;

	    @Autowired
	    private CompteCourantRepository compteCourantRepository;

	    @Autowired
	    private CompteEpargneRepository compteEpargneRepository;
	    

		public CompteUIController(CompteRepository compteRepository, CompteCourantRepository compteCourantRepository,
				CompteEpargneRepository compteEpargneRepository) {
			this.compteRepository = compteRepository;
			this.compteCourantRepository = compteCourantRepository;
			this.compteEpargneRepository = compteEpargneRepository;
		}
		
		public 
	    
	    
}
