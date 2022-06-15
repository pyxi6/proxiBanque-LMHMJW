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

    public CompteCourant( double solde, LocalDate dateCreation, CompteStatus status, Customer customer, List<Opperation> opperations, TypeCompte type, double decouvert) {
        super( solde, dateCreation, status, customer, opperations, type);
        this.decouvert = decouvert;
    }

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }
}
