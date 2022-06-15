package com.formation.proxibanque.lmhmjw.entity;

import com.formation.proxibanque.lmhmjw.entity.enums.TypeOpperation;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Opperation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date dateOperation;
    private double montant;
    @Enumerated(EnumType.STRING)
    private TypeOpperation typeOpperation;

    @ManyToOne
    @JoinColumn(name = "Code_Compte") // nom de la cle etrangere
    private Compte compte;
    private String description;

    public Opperation() {
    }

    public Opperation(long id, Date dateOperation, double montant,
                      TypeOpperation typeOpperation, Compte compte, String description) {
        this.id = id;
        this.dateOperation = dateOperation;
        this.montant = montant;
        this.typeOpperation = typeOpperation;
        this.compte = compte;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public TypeOpperation getTypeOpperation() {
        return typeOpperation;
    }

    public void setTypeOpperation(TypeOpperation typeOpperation) {
        this.typeOpperation = typeOpperation;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
