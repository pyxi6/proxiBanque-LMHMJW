package com.formation.proxibanque.lmhmjw.entity;

import com.formation.proxibanque.lmhmjw.entity.enums.TypeCompte;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
@Data  // creation des gether setter via l'extention Lambok
@NoArgsConstructor // constructeur sans params
@AllArgsConstructor // Constructeur avec tous les args
public abstract class Compte {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) //incrim valeur +1
    private Long code;
    private double solde;
    private Date dateCreation;

    @Enumerated(EnumType.STRING) // dans la base le type va etre stocker sous forme de string
                                // Ordinaire c'est sous forme numeriques
    private TypeCompte type;

	public Compte() {
	}

	public Compte(Long code, double solde, Date dateCreation, TypeCompte type) {

		this.code = code;
		this.solde = solde;
		this.dateCreation = dateCreation;
		this.type = type;
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

	@Override
	public String toString() {
		return "Compte [code=" + code + ", solde=" + solde + ", dateCreation=" + dateCreation + ", type=" + type + "]";
	}
    
    
}
