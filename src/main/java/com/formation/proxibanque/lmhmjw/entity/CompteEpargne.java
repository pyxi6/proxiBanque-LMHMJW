package com.formation.proxibanque.lmhmjw.entity;

import com.formation.proxibanque.lmhmjw.entity.enums.CompteStatus;
import com.formation.proxibanque.lmhmjw.entity.enums.TypeCompte;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
/*@DiscriminatorValue("EPARGNE")*/
public class CompteEpargne extends Compte{

    private double taux;

    public CompteEpargne() { };


    public CompteEpargne(String numCompte, double solde, LocalDate dateCreation, CompteStatus status, Customer customer, double taux) {
		super(numCompte, solde, dateCreation, status, customer);
		this.taux = taux;
	}



	public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }


	@Override
	public String toString() {
		return "CompteEpargne [taux=" + taux + "]";
	}
    
    
}
