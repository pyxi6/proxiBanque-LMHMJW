package com.formation.proxibanque.lmhmjw.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Agence {
	@Id
	private String id;
	
	private LocalDate date_ouverture;
	
	private Adresse adresse;
	
	@OneToMany(mappedBy = "agence")
	private List<Conseiller> conseiller;
	
	@OneToOne(mappedBy = "agence")
	private Directeur directeur;
	
	@OneToMany(mappedBy = "agence")
	private List<Customer> customers;
	
	
}
