package com.formation.proxibanque.lmhmjw.service;


import com.formation.proxibanque.lmhmjw.entity.Compte;
import com.formation.proxibanque.lmhmjw.entity.CompteCourant;
import com.formation.proxibanque.lmhmjw.entity.CompteEpargne;


import java.util.List;

// on definit le besoin fonctionnel
public interface CompteService {

    // ne pas metre "public" dans l'interface
    //Customer saveCustomer (Customer customer);
     // List<Customer> listCustomers();

     CompteCourant saveCompteCourrant (double initialSolde, double decouvert, long customerID);
     CompteEpargne saveCompteEpargne (double initialSolde, double taux, long customerID);
     Compte getCompte(String compteId);

     List<Compte> listComptes();

     Compte updateCompte(String compteId, Compte compte);

     void deleatCompte (String compteId);

     void debiter(String compteId, double montant, String description);
     void crediter(String compteId, double montant, String description);

     void virement(String compteIdSource, String compteIdDestinataire, double montant);



}
