package com.formation.proxibanque.lmhmjw.service;

import com.formation.proxibanque.lmhmjw.entity.*;
import com.formation.proxibanque.lmhmjw.entity.enums.TypeCompte;
import com.formation.proxibanque.lmhmjw.entity.enums.TypeOpperation;
import com.formation.proxibanque.lmhmjw.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CompteServiceImpl implements CompteService{


    private CustomerRepository customerRepository;
    
    private CompteRepository compteRepository;
    private CompteCourantRepository compteCourantRepository;
    private CompteEpargneRepository compteEpargneRepository;
    
    private OpperationRepository opperationRepository;

    public CompteServiceImpl(CustomerRepository customerRepository,
                             CompteRepository compteRepository,
                             CompteCourantRepository compteCourantRepository,
                             CompteEpargneRepository compteEpargneRepository,
                             OpperationRepository opperationRepository) {

        this.customerRepository = customerRepository;
        this.compteRepository = compteRepository;
        this.compteCourantRepository = compteCourantRepository;
        this.compteEpargneRepository = compteEpargneRepository;
        this.opperationRepository = opperationRepository;
    }

    
    @Override
    public CompteCourant saveCompteCourrant(double initialSolde, double decouvert, long customerID) {

        //Verification de l'existance du client:
        Customer customer=customerRepository.findById(customerID).orElse(null);
        if(customer==null){
            throw new RuntimeException("Customer not Found");
        }

        CompteCourant compteCourant= new CompteCourant();

        compteCourant.setDateCreation(LocalDate.now());
        compteCourant.setSolde(initialSolde);
        compteCourant.setDecouvert(decouvert);
        compteCourant.setCustomer(customer);

        CompteCourant savedCompteCourant= compteCourantRepository.save(compteCourant);
        return savedCompteCourant;
    }

    @Override
    public CompteEpargne saveCompteEpargne(double initialSolde, double taux, long customerID) {
        //Verification de l'existance du client:
        Customer customer=customerRepository.findById(customerID).orElse(null);
        if(customer==null){
            throw new RuntimeException("Le client n'existe pas ");
        }

        CompteEpargne compteEpargne= new CompteEpargne();
        
        compteEpargne.setDateCreation(LocalDate.now());
        compteEpargne.setSolde(initialSolde);
        compteEpargne.setTaux(taux);
        compteEpargne.setCustomer(customer);

        CompteEpargne savedCompteEpargne=compteEpargneRepository.save(compteEpargne);
        return savedCompteEpargne;
    }

    @Override
    public List<Compte> listComptes() {
        return compteRepository.findAll();
    }
    
	@Override
	public List<CompteCourant> listComptesCourants() {
	
		return compteCourantRepository.findAll();
	}


	@Override
	public List<CompteEpargne> listeCompteEpargnes() {
		
		return compteEpargneRepository.findAll();
	}

    @Override
    public Compte getCompte(Long compteId) {

        Compte compte = compteRepository.findById(compteId).
                orElseThrow(()->new RuntimeException("Compte n'existe pas"));
        return compte;
    }

   
    @Override
    public CompteCourant updateCompteCourant(Long compteCourantId, Compte compteCourant) {
    	
  	CompteCourant compCourant = compteCourantRepository.findById(compteCourantId).
              orElseThrow(()->new RuntimeException("Compte n'existe pas"));
      return compteRepository.save(compCourant);
  }

    @Override
    public Compte updateCompteEpargne(Long compteEpargneId, Compte compteEpargne) {

    	CompteEpargne comptEpargne = compteEpargneRepository.findById(compteEpargneId).
                orElseThrow(()->new RuntimeException("Compte n'existe pas"));
        return compteEpargneRepository.save(comptEpargne);
    }


    @Override
    public void deleatCompte(Long compteId) {
        compteRepository.deleteById(compteId);
    }

    @Override
    public void debiter(Long compteId, double montant, String description) {

        Compte compte= getCompte(compteId);
        if(compte.getSolde()<montant)
            throw new RuntimeException("Solde insuffisant");

        Opperation opperation = new Opperation();
        opperation.setTypeOpperation(TypeOpperation.DEBIT);
        opperation.setMontant(montant);
        opperation.setDescription(description);
        opperation.setDateOperation(new Date());
        opperation.setCompte(compte);

        opperationRepository.save(opperation);
        compte.setSolde(compte.getSolde()-montant);
        compteRepository.save(compte);

    }

    @Override
    public void crediter(Long compteId, double montant, String description) {

        Compte compte= getCompte(compteId);
        Opperation opperation = new Opperation();
        
        opperation.setTypeOpperation(TypeOpperation.CREDIT);
        opperation.setMontant(montant);
        opperation.setDescription(description);
        opperation.setDateOperation(new Date());
        opperation.setCompte(compte);

        opperationRepository.save(opperation);
        compte.setSolde(compte.getSolde()+montant);
        compteRepository.save(compte);
    }
    

    @Override
    public void virement(Long compteIdSource, Long compteIdDestinataire, double montant) {

        debiter(compteIdSource,montant, "Transfer à "+compteIdDestinataire);
        crediter(compteIdDestinataire, montant, "Transfer depuis"+compteIdSource);
    }

}
