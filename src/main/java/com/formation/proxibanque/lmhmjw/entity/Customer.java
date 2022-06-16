package com.formation.proxibanque.lmhmjw.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String prenom;
	private String nom;
	private String numTel;
	@Embedded
	private Adresse adresse;

	// mapping relationnel, un client peut avoir plusieur compte
	// relation by directionnel donc utiliser mappedBy,

	// dans la classe compte le Customer est representer par  l'attribu customer
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	private Collection<Compte> comptes;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_conseiller")
	private Conseiller conseiller;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_agence")
	private Agence agence;

	public Customer() {

	}

	public Customer(String prenom, String nom, String numTel) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.numTel = numTel;
	}

	public Customer(Long id, String prenom, String nom, String numTel, Adresse adresse) {
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.numTel = numTel;
		this.adresse = adresse;
	}

	public Customer(String prenom, String nom, String numTel, Adresse adresse) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.numTel = numTel;
		this.adresse = adresse;
	}

	public Customer(Long id, String prenom, String nom, String numTel, Adresse adresse, Conseiller conseiller,
			Agence agence) {
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.numTel = numTel;
		this.adresse = adresse;
		this.conseiller = conseiller;
		this.agence = agence;
	}

	public Customer(String prenom, String nom, String numTel, Adresse adresse, Conseiller conseiller) {
		this.prenom = prenom;
		this.nom = nom;
		this.numTel = numTel;
		this.adresse = adresse;
		this.conseiller = conseiller;
	}

	public Customer(String prenom, String nom, String numTel, Adresse adresse, 
			Conseiller conseiller, Agence agence) {
		this.prenom = prenom;
		this.nom = nom;
		this.numTel = numTel;
		this.adresse = adresse;
		this.conseiller = conseiller;
		this.agence = agence;
	}


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
	public Collection<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}
	
	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", numTel=" + numTel + ", adresse="
				+ adresse + ", conseiller=" + conseiller + ", agence=" + agence + "]";
	}


}
