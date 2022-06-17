package com.formation.proxibanque.lmhmjw.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formation.proxibanque.lmhmjw.dto.CreditDTO;
import com.formation.proxibanque.lmhmjw.dto.DebitDTO;
import com.formation.proxibanque.lmhmjw.dto.VirementDTO;
import com.formation.proxibanque.lmhmjw.entity.Compte;
import com.formation.proxibanque.lmhmjw.entity.CompteCourant;
import com.formation.proxibanque.lmhmjw.entity.CompteEpargne;
import com.formation.proxibanque.lmhmjw.entity.Customer;
import com.formation.proxibanque.lmhmjw.entity.Opperation;
import com.formation.proxibanque.lmhmjw.entity.enums.TypeOpperation;
import com.formation.proxibanque.lmhmjw.repository.CompteCourantRepository;
import com.formation.proxibanque.lmhmjw.repository.CompteEpargneRepository;
import com.formation.proxibanque.lmhmjw.repository.CompteRepository;
import com.formation.proxibanque.lmhmjw.repository.CustomerRepository;
import com.formation.proxibanque.lmhmjw.repository.OpperationRepository;

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
    public DebitDTO debiter(Long compteId, double montant, String description) {
    	
    	Compte compte= getCompte(compteId);

    	DebitDTO debitDTO = new DebitDTO();    	
    	debitDTO.setSoldesAvant(compte.getSolde());	    
    	
        if(compte.getSolde() < montant) {
        	debitDTO.setEtatVirement(false);
            throw new RuntimeException("Solde insuffisant");}

        Opperation opperation = new Opperation();
        
        opperation.setTypeOpperation(TypeOpperation.DEBIT);
        opperation.setMontant(montant);
        opperation.setDescription(description);
        opperation.setDateOperation(new Date());
        opperation.setCompte(compte);

        opperationRepository.save(opperation);
        compte.setSolde(compte.getSolde()-montant);
         compteRepository.save(compte);
         
         debitDTO.setSoldesApres(compte.getSolde());
            
         return debitDTO;

    }

    @Override
    public CreditDTO crediter(Long compteId, double montant, String description) {
   	    	
        Compte compte= getCompte(compteId);
        CreditDTO creditDTO= new CreditDTO();        
        Opperation opperation = new Opperation();        
        
        creditDTO.setSoldesAvantCredit(compte.getSolde());      
        
        opperation.setTypeOpperation(TypeOpperation.CREDIT);
        opperation.setMontant(montant);
              
        opperation.setDescription(description);
        opperation.setDateOperation(new Date());
        opperation.setCompte(compte);

        opperationRepository.save(opperation);
        compte.setSolde(compte.getSolde()+montant);
        compteRepository.save(compte);
        
        
        creditDTO.setSoldesApresCredit(compte.getSolde()); 
        return creditDTO;
    }
    

    @Override
    public VirementDTO virement(Long compteIdSource, Long compteIdDestinataire, double montant) {

    	VirementDTO virementDTO = new VirementDTO();
        DebitDTO debiter = debiter(compteIdSource,montant, "Transfer à "+compteIdDestinataire);
        CreditDTO crediter = crediter(compteIdDestinataire, montant, "Transfer depuis"+compteIdSource);
         virementDTO.setCreditDTO(crediter);
         virementDTO.setDebitDTO(debiter);
        return virementDTO;
    }

}
