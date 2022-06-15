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

import com.formation.proxibanque.lmhmjw.entity.Conseiller;
import com.formation.proxibanque.lmhmjw.entity.Customer;
import com.formation.proxibanque.lmhmjw.repository.CustomerRepository;
import com.formation.proxibanque.lmhmjw.service.CustomerServiceImpl;


@RestController
public class CustomerRestController {
	
	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	
	
	public CustomerRestController(CustomerServiceImpl customerServiceImpl) {
		super();
		this.customerServiceImpl = customerServiceImpl;
	}

	@GetMapping(path = "/customers")
	public List<Customer> listAllCustomers(){
		return customerServiceImpl.listAllCustomersService();
	}
	
//	@GetMapping(path = "/customers/{id}")
//	public List<Customer> listCustomerByConseiller(@PathVariable Long id){
//		return customerServiceImpl.listCustomersByConseillerService(id);
//		
//	}
	
	@GetMapping(path = "/customers/{id}")
	public Customer getCustomerById(@PathVariable Long id) {
		return customerServiceImpl.getCustomerByIdService(id);
	}
	
	@DeleteMapping(path = "/customers/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		customerServiceImpl.deleteCustomerService(id);
	}
	
	@PostMapping(path = "/customers")
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerServiceImpl.saveCustomerService(customer);
		
		
	}
	
	@PutMapping(path = "/customers/{id}")
	public Customer updateCustommer(@PathVariable Long id, @RequestBody Customer customer) {
		customer.setId(id);
		return customerServiceImpl.saveCustomerService(customer);
		
	}
}
