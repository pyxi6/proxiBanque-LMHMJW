package com.formation.proxibanque.lmhmjw.entity;

import com.formation.proxibanque.lmhmjw.entity.enums.TypeCompte;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data  // creation des gether setter via l'extention Lambok
@NoArgsConstructor // constructeur sans params
@AllArgsConstructor // Constructeur avec tous les args
public class Compte {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //incrim valeur +1
    private Long code;
    private double solde;
    private Date dateCreation;

    @Enumerated(EnumType.STRING) // dans la base le type va etre stocker sous forme de string
                                // Ordinaire c'est sous forme numeriques
    private TypeCompte type;

}
