package com.formation.proxibanque.lmhmjw.entity;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conseiller{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Embedded
	private Personne personne;
	
	
	
	public Conseiller() {
	}

	public Conseiller(Long id, Personne personne) {
		this.id = id;
		this.personne = personne;
	}
	
	

	public Conseiller(Personne personne) {
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
