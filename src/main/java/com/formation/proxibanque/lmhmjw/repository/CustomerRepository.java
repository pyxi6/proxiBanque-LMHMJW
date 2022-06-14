package com.formation.proxibanque.lmhmjw.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.proxibanque.lmhmjw.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
