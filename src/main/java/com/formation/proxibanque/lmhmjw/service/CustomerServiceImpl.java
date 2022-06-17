package com.formation.proxibanque.lmhmjw.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.formation.proxibanque.lmhmjw.entity.Conseiller;
import com.formation.proxibanque.lmhmjw.entity.Customer;
import com.formation.proxibanque.lmhmjw.repository.CustomerRepository;

@Service
public class CustomerServiceImpl {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ConseillerServiceImpl conseillerServiceImpl;
	

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	public List<Customer> listAllCustomersService(){
		return customerRepository.findAll();
	}
	
	
	public Customer getCustomerByIdService(Long id) {
		return customerRepository.findById(id).get();
	}
	
	
	public void deleteCustomerService(Long id) {
		customerRepository.deleteById(id);
	}
	
	public Customer saveCustomerService(Customer customer) {
		Conseiller c = findFreeConseiller();
		customer.setConseiller(c);
		customer.setAgence(c.getAgence());
		return customerRepository.save(customer);		
		
	}
	
	private Conseiller findFreeConseiller() {
		List<Conseiller> c = conseillerServiceImpl.findAllConseillers();
		Conseiller consChoisi = null;
		for (Conseiller conseiller : c) {
			if(conseiller.getCustomers().size()<10) {
				consChoisi = conseiller;
			}
		}
		return consChoisi;
	}
	
	

	public Customer updateCustommerService(@PathVariable Long id, @RequestBody Customer customer) {
		customer.setId(id);
		return customerRepository.save(customer);
	}

}
