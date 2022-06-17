package com.formation.proxibanque.lmhmjw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.formation.proxibanque.lmhmjw.repository.ConseillerRepository;
import com.formation.proxibanque.lmhmjw.service.ConseillerServiceImpl;

@Controller
public class ConseillerUIController {
	
	@Autowired
	private ConseillerServiceImpl conseillerServiceImpl;
	
	
	
	public ConseillerUIController(ConseillerServiceImpl conseillerServiceImpl) {
		this.conseillerServiceImpl = conseillerServiceImpl;
	}



	@GetMapping("/conseillerWeb")
	public String listAllCustomer(Model model) {
		model.addAttribute("conseillers", conseillerServiceImpl.findAllConseillers());
		return "listeConseiller";
	}
	
	
	
	
}
