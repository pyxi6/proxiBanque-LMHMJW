package com.formation.proxibanque.lmhmjw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.proxibanque.lmhmjw.repository.CustomerRepository;
import com.formation.proxibanque.lmhmjw.service.CustomerServiceImpl;

@Controller
public class CustomerUIController {

	@Autowired
	private CustomerServiceImpl customerServiceImpl;

	public CustomerUIController(CustomerServiceImpl customerServiceImpl) {
		super();
		this.customerServiceImpl = customerServiceImpl;
	}
	
	@GetMapping("/customersWeb")
	public String showUserList(Model model) {
	    model.addAttribute("customers", customerServiceImpl.listAllCustomersService());
	    return "listeClients";
	}
	
	

}
