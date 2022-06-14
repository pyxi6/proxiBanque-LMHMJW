package com.formation.proxibanque.lmhmjw.entity;

import com.formation.proxibanque.lmhmjw.entity.enums.TypeCompte;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("EPARGNE")
public class CompteEpargne extends Compte{

    private double taux;

    public CompteEpargne() { };

    public CompteEpargne(Long code, double solde, Date dateCreation, TypeCompte type, Customer customer, double taux) {
        super(code, solde, dateCreation, type, customer);
        this.taux = taux;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}
