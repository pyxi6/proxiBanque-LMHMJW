package com.formation.proxibanque.lmhmjw.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long id;
	private String prenom;
	private String nom;
	private String numTel;
	@Embedded
	private Adresse adresse;

	//mapping relationnel, un client peut avoir plusieur compte
	// relation by directionnel donc utiliser mappedBy,
	// dans la classe compte le Customer est representer par  l'attribu customer
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // Ne serialise pas la liste des compte par json
   private List<Compte> comptes;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	public Customer() {
	}

	public Customer(Long id, String prenom, String nom, String numTel, Adresse adresse, List<Compte> comptes) {
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.numTel = numTel;
		this.adresse = adresse;
		this.comptes = comptes;
	}

	public Customer(String prenom, String nom, String numTel, Adresse adresse) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.numTel = numTel;
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"id=" + id +
				", prenom='" + prenom + '\'' +
				", nom='" + nom + '\'' +
				", numTel='" + numTel + '\'' +
				", adresse=" + adresse +
				", comptes=" + comptes +
				'}';
	}
}
