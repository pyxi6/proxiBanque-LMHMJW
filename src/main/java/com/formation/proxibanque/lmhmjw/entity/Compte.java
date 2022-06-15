package com.formation.proxibanque.lmhmjw.entity;

import com.formation.proxibanque.lmhmjw.entity.enums.CompteStatus;
import com.formation.proxibanque.lmhmjw.entity.enums.TypeCompte;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
// comme y a l'heritage INheritance
// Single_Table une table pour tous les herarchie de classe, probleme lorsqu'il ya bcq de collon null
// une seul table compte ou on met tout
@Inheritance(strategy = InheritanceType.JOINED)
/*@DiscriminatorColumn(name = "TypeCompte", length = 15) */// nom de la colone type avec nom caractere <12
public  class Compte {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numCompte;
    private double solde;
    private LocalDate dateCreation;

	@Enumerated(EnumType.STRING) // Enregistre le type au format string en base
	private CompteStatus status;


	//compte lié à un customer
	@ManyToOne
	@JoinColumn(name = "CODE_CLIENT") // nom de la jointure, cle etrangere sinon c' customer
	private Customer customer;

	@OneToMany(mappedBy = "compte", fetch = FetchType.LAZY)
	private List<Opperation> opperations;
    @Enumerated(EnumType.STRING) // dans la base le type va etre stocker sous forme de string  // Ordinaire c'est sous forme numeriques
    private TypeCompte type;

	public Compte() {
	}


	
	

	public Compte(String numCompte, double solde, LocalDate dateCreation, CompteStatus status) {
		super();
		this.numCompte = numCompte;
		this.solde = solde;
		this.dateCreation = dateCreation;
		this.status = status;
	}





	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	public CompteStatus getStatus() {
		return status;
	}

	public void setStatus(CompteStatus status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Opperation> getOpperations() {
		return opperations;
	}

	public void setOpperations(List<Opperation> opperations) {
		this.opperations = opperations;
	}

	public TypeCompte getType() {
		return type;
	}

	public void setType(TypeCompte type) {
		this.type = type;
	}
	

	public String getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(String numCompte) {
		this.numCompte = numCompte;
	}





	@Override
	public String toString() {
		return "Compte [id=" + id + ", numCompte=" + numCompte + ", solde=" + solde + ", dateCreation=" + dateCreation
				+ ", status=" + status + ", customer=" + customer + ", opperations=" + opperations + ", type=" + type
				+ "]";
	}
	
	


}
