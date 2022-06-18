package com.formation.proxibanque.lmhmjw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.formation.proxibanque.lmhmjw.service.AuditService;

@Controller
public class AuditUIController {

	@Autowired
	private AuditService auditService;

	public AuditUIController(AuditService auditService) {
		this.auditService = auditService;
	}
	
	@GetMapping("/Audit")
	public String getAudit(Model model) {
		
		model.addAttribute("SoldeTotal",auditService.getSoldeTotal());
		model.addAttribute("SoldeCourant", auditService.getSoldeCourant());
		model.addAttribute("SoldeEpargne", auditService.getSoldeEpargne());
		model.addAttribute("clientsarisque", auditService.ListCustomerARisque() );
		model.addAttribute("clientsdeficit", auditService.ListCustomersDeficitaires() );
		model.addAttribute("clientsPremium", auditService.ListCustomersPremium() );
		
		return "Audit";
	}
	
}
