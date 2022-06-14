package com.formation.proxibanque.lmhmjw.service;


import com.formation.proxibanque.lmhmjw.entity.Compte;
import com.formation.proxibanque.lmhmjw.entity.Opperation;
import com.formation.proxibanque.lmhmjw.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

// classe qui implement l'interface CompteService
@Service
@Transactional  // la methode est transactionnel
public class CompteServiceImpl implements CompteService {

    // injection des dependance par constructeur
    // avec Autowired fait le taff aussi
    @Autowired
    private CompteRepository compteRepository;


    @Override
    public Compte consulterCompte(Long codeCpte) {
        return null;
    }

    @Override
    public void versement(Long codeCpte, double montant) {

    }

    @Override
    public void retrait(Long codeCpte, double montant) {

    }

    @Override
    public void virement(Long codeSource, Long codeDestination, double montant) {
        // acce au compte qui envoi et à celui qui recoi
        Compte compteEmeteur = compteRepository.getById(codeSource);
        Compte compteDestinatere = compteRepository.getById(codeDestination);

        // operation solde compteEmeteur - montant
        compteEmeteur.setSolde(compteEmeteur.getSolde() - montant);

        //ajout du montant au compte destinataire
        compteDestinatere.setSolde(compteDestinatere.getSolde() + montant);

        // normalement pas besoin car on est en transactionnel
        // mise à jour des 2 comptes
        compteRepository.save(compteEmeteur);
        compteRepository.save(compteDestinatere);
    }

    @Override
    public Page<Opperation> listOpperation(Long CodeCpte, int page, int size) {
        return null;
    }
}
