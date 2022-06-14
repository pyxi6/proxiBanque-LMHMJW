package com.formation.proxibanque.lmhmjw.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("VERSEMENT")
public class Versement  extends Opperation{

    public Versement() {
    }

    public Versement(Date dateOperation, double montant, Compte compte) {
        super(dateOperation, montant, compte);
    }
}
