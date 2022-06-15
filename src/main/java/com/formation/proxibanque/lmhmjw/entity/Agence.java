package com.formation.proxibanque.lmhmjw.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Agence {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate date_ouverture;
	
	private Adresse adresse;
	
	@OneToMany(mappedBy = "agence")
	private List<Conseiller> conseiller;
	
	@OneToOne(mappedBy = "agence")
	private Directeur directeur;
	
//	@OneToMany(mappedBy = "agence")
//	private List<Customer> customers;

	public Agence() {
	
	}
	
	public Agence(Adresse adresse) {
		this.adresse = adresse;
	}

//	public Agence(Adresse adresse, List<Conseiller> conseiller,
//			Directeur directeur, List<Customer> customers) {
//		this.adresse = adresse;
//		this.conseiller = conseiller;
//		this.directeur = directeur;
//		this.customers = customers;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate_ouverture() {
		return date_ouverture;
	}

	public void setDate_ouverture(LocalDate date_ouverture) {
		this.date_ouverture = date_ouverture;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Agence [id=" + id + ", date_ouverture=" + date_ouverture + ", adresse=" + adresse + "]";
	}
	
	
	
	
	
}
