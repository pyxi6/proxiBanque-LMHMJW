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

    public CompteEpargne( double solde, LocalDate dateCreation, CompteStatus status, Customer customer,
                         List<Opperation> opperations, TypeCompte type, double taux) {
        super( solde, dateCreation, status, customer, opperations, type);
        this.taux = taux;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}
