package com.formation.proxibanque.lmhmjw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.formation.proxibanque.lmhmjw.repository.CompteCourantRepository;
import com.formation.proxibanque.lmhmjw.repository.CompteEpargneRepository;
import com.formation.proxibanque.lmhmjw.repository.CompteRepository;

@Controller
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
		
		@GetMapping("/virement/courant/{id}")
		public String LoadVirementFromCourant(@PathVariable Long id, Model model) {
			model.addAttribute("compte", compteCourantRepository.findById(id));
			return "virement";
		}
		
		@GetMapping("/virement/epargne/{id}")
		public String LoadVirementFromEpargne(@PathVariable Long id, Model model) {
			model.addAttribute("compte", compteEpargneRepository.findById(id));
			return "virement";
		}
		
		
	    
	    
}
