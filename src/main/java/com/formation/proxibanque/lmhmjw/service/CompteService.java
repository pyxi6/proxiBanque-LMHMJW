package com.formation.proxibanque.lmhmjw.service;

import com.formation.proxibanque.lmhmjw.entity.Compte;
import com.formation.proxibanque.lmhmjw.entity.Opperation;
import org.springframework.data.domain.Page;

public interface CompteService {

    public Compte consulterCompte(Long codeCpte);
    public void versement (Long codeCpte, double montant);
    public  void retrait(Long codeCpte, double montant);

    // methode pour effectuer un virement
    // en pararm l'Id du compte qui effect le vireù, celui qui le recoi, le montant du virement
     public void virement(Long codeSource, Long codeDestination, double montant);

     public Page<Opperation> listOpperation (Long CodeCpte, int page, int size);
}
