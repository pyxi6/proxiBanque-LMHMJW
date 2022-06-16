package com.formation.proxibanque.lmhmjw.entity;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Directeur{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Embedded
	private Personne personne;
	
	@OneToOne
	@JoinColumn(name = "id_agence")
	private Agence agence;
	
	public Directeur() {
	}
	
	public Directeur(Long id, Personne personne) {
		this.id = id;
		this.personne = personne;
	}
	
	public Directeur(Personne personne) {
		this.personne = personne;
	}
	
	
	public Directeur(Personne personne, Agence agence) {
		this.personne = personne;
		this.agence = agence;
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

	@Override
	public String toString() {
		return "Directeur [id=" + id + ", personne=" + personne + ", agence=" + agence + "]";
	}
 
	

	
	
}
