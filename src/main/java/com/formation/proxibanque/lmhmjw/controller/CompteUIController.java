package com.formation.proxibanque.lmhmjw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.formation.proxibanque.lmhmjw.dto.VirementRequestDTO;
import com.formation.proxibanque.lmhmjw.entity.Virement;
import com.formation.proxibanque.lmhmjw.service.CompteServiceImpl;

@Controller
public class CompteUIController {
	
	  	@Autowired
	  	private CompteServiceImpl compteServiceImpl;
	  	
	  	@Autowired
	  	private CompteRestController compteRestController;
	  	
		



		public CompteUIController(CompteServiceImpl compteServiceImpl, CompteRestController compteRestController) {
			this.compteServiceImpl = compteServiceImpl;
			this.compteRestController = compteRestController;
		}

		@GetMapping("/virement/{id}")
		public String LoadVirement(@PathVariable Long id, Model model) {
			model.addAttribute("compte",compteServiceImpl.getCompte(id));
			model.addAttribute("virement",new Virement());
			return "virement";
		}
		
		@PostMapping("/virement")
		public String FaireVirement(@ModelAttribute Virement virement) {
			String id = compteServiceImpl.getCompte(virement.getCodeSource()).getId().toString();
			compteServiceImpl.virement(virement.getCodeSource(), virement.getCodeDestination(), virement.getMontant());
			return "redirect:/customersWeb/"+id;
		}
		
		
	    
	    
}
