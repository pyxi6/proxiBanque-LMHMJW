package com.formation.proxibanque.lmhmjw.entity;

import com.formation.proxibanque.lmhmjw.entity.enums.CompteStatus;
import com.formation.proxibanque.lmhmjw.entity.enums.TypeCompte;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
/*@DiscriminatorValue("COURANT")*/
public class CompteCourant  extends  Compte{

    private double decouvert;

    public CompteCourant() { }

    public CompteCourant(double decouvert) {
        this.decouvert = decouvert;
    }
    

	public CompteCourant(String numCompte, double solde, LocalDate dateCreation, CompteStatus status, Customer customer,
			double decouvert) {
		super(numCompte, solde, dateCreation, status, customer);
		this.decouvert = decouvert;
	}

	public CompteCourant(String numCompte, double solde, LocalDate dateCreation, CompteStatus status, Customer customer,
			TypeCompte type, double decouvert) {
		super(numCompte, solde, dateCreation, status, customer, type);
		this.decouvert = decouvert;
	}

	public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }

	@Override
	public String toString() {
		return "CompteCourant [decouvert=" + decouvert + ", getId()=" + getId() + ", getSolde()=" + getSolde()
				+ ", getDateCreation()=" + getDateCreation() + ", getStatus()=" + getStatus() + ", getNumCompte()="
				+ getNumCompte() + "]";
	}

	

	

    
    
}
