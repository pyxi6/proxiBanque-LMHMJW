package com.formation.proxibanque.lmhmjw.compteservice.service;

public interface CompteService {

    // methode pour effectuer un virement
    // en pararm l'Id du compte qui effect le vireù, celui qui le recoi, le montant du virement
     void virement(Long codeSource, Long codeDestination, double montant);
}
