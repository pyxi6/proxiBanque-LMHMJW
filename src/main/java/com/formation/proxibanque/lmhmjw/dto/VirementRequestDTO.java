package com.formation.proxibanque.lmhmjw.dto;

import lombok.Data;

@Data
public class VirementRequestDTO {

    // il suffit de mettre que les attributs dont on a besoin dans la requet, pour faire un virement
    // + getter, setter
    private Long codeSource;
    private Long codeDestination;
    private double montant;
}
