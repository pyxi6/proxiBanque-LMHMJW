package com.formation.proxibanque.lmhmjw.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("RETRAIT")
public class Retrait  extends  Opperation{

    public Retrait() {
    }

    public Retrait(Date dateOperation, double montant, Compte compte) {
        super(dateOperation, montant, compte);
    }
}
