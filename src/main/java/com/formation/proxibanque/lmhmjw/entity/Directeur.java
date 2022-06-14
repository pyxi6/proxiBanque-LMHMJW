package com.formation.proxibanque.lmhmjw.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Directeur{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Embedded
	private Personne personne;
	
	public Directeur() {
	}
	
	public Directeur(Long id, Personne personne) {
		super();
		this.id = id;
		this.personne = personne;
	}
	
	public Directeur(Personne personne) {
		super();
		this.personne = personne;
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

	
}
