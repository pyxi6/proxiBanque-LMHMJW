package com.formation.proxibanque.lmhmjw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.formation.proxibanque.lmhmjw.entity.Conseiller;
import com.formation.proxibanque.lmhmjw.entity.Customer;
import com.formation.proxibanque.lmhmjw.repository.ConseillerRepository;

@Service
public class ConseillerServiceImpl {
	
	@Autowired
	private ConseillerRepository conseillerRepository;

	public ConseillerServiceImpl(ConseillerRepository conseillerRepository) {
		this.conseillerRepository = conseillerRepository;
	}
	
	public List<Conseiller> findAllConseillers(){
		return conseillerRepository.findAll();
	}
	
	public List<Customer> ListCustomerByConseiller(Long id){
		return conseillerRepository.findById(id).get().getCustomers();

	}
		
	public Conseiller findConseillerById(Long id) {
		return conseillerRepository.findById(id).get();
	}
	
	public Conseiller addConseiller(Conseiller conseiller) {
		return conseillerRepository.save(conseiller);
	}
	
	public Conseiller modifConseiller(Long id, Conseiller conseiller) {
		conseiller.setId(id);
		return conseillerRepository.save(conseiller);
	}
	
	public void eraseConseillerById(Long id) {
		conseillerRepository.deleteById(id);
	}
}
