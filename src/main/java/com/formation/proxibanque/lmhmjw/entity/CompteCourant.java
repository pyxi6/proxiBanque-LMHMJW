package com.formation.proxibanque.lmhmjw.entity;

import com.formation.proxibanque.lmhmjw.entity.enums.TypeCompte;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("COURANT")
public class CompteCourant  extends  Compte{

    private double decouvert;

    public CompteCourant() { }

    public CompteCourant(Long code, double solde, Date dateCreation, TypeCompte type, Customer customer, double decouvert) {
        super(code, solde, dateCreation, type, customer);
        this.decouvert = decouvert;
    }

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }
}
