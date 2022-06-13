package com.formation.proxibanque.lmhmjw.service;


import com.formation.proxibanque.lmhmjw.entity.Compte;
import com.formation.proxibanque.lmhmjw.repository.CompteRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

// classe qui implement l'interface CompteService
@Service
@Transactional  // la methode est transactionnel
public class CompteServiceImpl implements CompteService {

    // injection des dependance par constructeur
    private CompteRepository compteRepository;
    public CompteServiceImpl(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
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
}
