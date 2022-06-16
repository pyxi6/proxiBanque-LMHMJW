package com.formation.proxibanque.lmhmjw.service;


import com.formation.proxibanque.lmhmjw.entity.Compte;
import com.formation.proxibanque.lmhmjw.entity.CompteCourant;
import com.formation.proxibanque.lmhmjw.entity.CompteEpargne;


import java.util.List;

// on definit le besoin fonctionnel
public interface CompteService {

     CompteCourant saveCompteCourrant (double initialSolde, double decouvert, long customerID);
     CompteEpargne saveCompteEpargne (double initialSolde, double taux, long customerID);

     Compte getCompte(Long compteId);

     List<CompteCourant> listComptesCourants();
     List<CompteEpargne> listeCompteEpargnes();
     List<Compte> listComptes();
    
     CompteCourant updateCompteCourant(Long compteCourantId, Compte compteCourant);
     Compte updateCompteEpargne(Long compteEpargneId, Compte compteEpargne);
          
     void deleatCompte (Long compteId);

     void debiter(Long compteId, double montant, String description);
     void crediter(Long compteId, double montant, String description);

     void virement(Long compteIdSource, Long compteIdDestinataire, double montant);
     
}
