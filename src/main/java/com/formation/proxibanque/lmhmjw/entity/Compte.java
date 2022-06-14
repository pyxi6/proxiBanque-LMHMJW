package com.formation.proxibanque.lmhmjw.entity;

import com.formation.proxibanque.lmhmjw.entity.enums.TypeCompte;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
// comme y a l'heritage INheritance
// Single_Table une table pour tous les herarchie de classe, probleme lorsqu'il ya bcq de collon null
// une seul table compte ou on met tout
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TypeCompte",
discriminatorType = DiscriminatorType.STRING, length = 12)
public abstract class Compte {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) //incrim valeur +1
    private Long code;
    private double solde;
    private Date dateCreation;
	//compte lié à un customer
	@ManyToOne
	@JoinColumn(name = "CODE_CLIENT") // nom de la jointure, cle etrangere sinon c' customer
	private Customer customer;

	@OneToMany(mappedBy = "compte")
	private Collection<Opperation> opperations;
    @Enumerated(EnumType.STRING) // dans la base le type va etre stocker sous forme de string
                                // Ordinaire c'est sous forme numeriques
    private TypeCompte type;

	public Compte() {
	}

	public Compte(Long code, double solde, Date dateCreation, TypeCompte type, Customer customer) {

		this.code = code;
		this.solde = solde;
		this.dateCreation = dateCreation;
		this.type = type;
		this.customer = customer;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public TypeCompte getType() {
		return type;
	}

	public void setType(TypeCompte type) {
		this.type = type;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Collection<Opperation> getOpperations() {
		return opperations;
	}

	public void setOpperations(Collection<Opperation> opperations) {
		this.opperations = opperations;
	}

	@Override
	public String toString() {
		return "Compte [code=" + code + ", solde=" + solde + ", dateCreation=" + dateCreation + ", type=" + type + "]";
	}

}
