package com.formation.proxibanque.lmhmjw.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Conseiller{
	
	@Id
	@GeneratedValue
	private Long id;
	@Embedded
	private Personne personne;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_agence")
	private Agence agence;
	
	@OneToMany(mappedBy = "conseiller", fetch = FetchType.EAGER)
	private List<Customer> customers;
	
	public Conseiller() {
	}

	public Conseiller(Long id, Personne personne) {
		this.id = id;
		this.personne = personne;
	}

	public Conseiller(Personne personne) {
		this.personne = personne;
	}
	
	

	public Conseiller(Personne personne, Agence agence) {
		this.personne = personne;
		this.agence = agence;
	}

	public Conseiller(Personne personne, Agence agence, List<Customer> customers) {
		this.personne = personne;
		this.agence = agence;
		this.customers = customers;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public List<Customer> getCustomers() {
		return customers;
	}
	
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "Conseiller [id=" + id + ", personne=" + personne + ", agence=" + agence + ", customers=" + customers
				+ "]";
	}

	
	
	
	
	
	
	
}
