package com.formation.proxibanque.lmhmjw.controller;

import com.formation.proxibanque.lmhmjw.dto.VirementDTO;
import com.formation.proxibanque.lmhmjw.dto.VirementRequestDTO;
import com.formation.proxibanque.lmhmjw.entity.*;
import com.formation.proxibanque.lmhmjw.entity.enums.CompteStatus;
import com.formation.proxibanque.lmhmjw.repository.AgenceRepository;
import com.formation.proxibanque.lmhmjw.repository.CompteCourantRepository;
import com.formation.proxibanque.lmhmjw.repository.CompteEpargneRepository;
import com.formation.proxibanque.lmhmjw.repository.CompteRepository;
import com.formation.proxibanque.lmhmjw.repository.ConseillerRepository;
import com.formation.proxibanque.lmhmjw.repository.CustomerRepository;
import com.formation.proxibanque.lmhmjw.repository.DirecteurRepository;
import com.formation.proxibanque.lmhmjw.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

import java.time.LocalDate;
import java.util.List;

@RestController
public class CompteRestController {

	// on a besoin d'accedez a la base
	// eviter @Autowaired deprciller

	@Autowired
	private CompteRepository compteRepository;

	@Autowired
	private CompteCourantRepository compteCourantRepository;

	@Autowired
	private CompteEpargneRepository compteEpargneRepository;


     private CompteService compteService;
     
 	@Autowired
 	private AgenceRepository agenceRepository;
 	
	@Autowired
 	private DirecteurRepository directeurRepository;
	
	@Autowired
	private ConseillerRepository conseillerRepository;
	
	@Autowired
	private CustomerRepository customerRepository;


 	@PostConstruct
 	public void dataLoaderAgence() {
 		Adresse adresseAgence = new Adresse("6 rue de la République", "92800", "Puteaux");
 		Agence agence = new Agence(LocalDate.now(), adresseAgence);
 		agenceRepository.save(agence);
 		
 		Personne personne = new Personne("Tibah", "Shalhoub");
 		Directeur directeur = new Directeur(personne, agence);
 		directeurRepository.save(directeur);
 		
 		Personne personne1 = new Personne("Noël", "Regnier");
 		Personne personne2 = new Personne("Alice", "Dupont");
 		Personne personne3 = new Personne("Bowman", "Goodchild");
 		Conseiller conseiller1 = new Conseiller(personne1, agence);
 		Conseiller conseiller2 = new Conseiller(personne2, agence);
 		Conseiller conseiller3 = new Conseiller(personne3, agence);
 		conseillerRepository.save(conseiller1);
 		conseillerRepository.save(conseiller2);
 		conseillerRepository.save(conseiller3);
 		
 		Adresse adresse1 = new Adresse("123 rue Lepic", "92800", "Puteaux");
 		Adresse adresse2 = new Adresse("12 rue de la Liberté", "92800", "Puteaux");
 		Adresse adresse3 = new Adresse("15 rue du Jura", "92800", "Puteaux");
 		Adresse adresse4 = new Adresse("38 rue Lamine", "92800", "Puteaux");
 		Adresse adresse5 = new Adresse("52 boulevard France", "92800", "Puteaux");
 		Adresse adresse6 = new Adresse("1 rue Saint-Juste", "92800", "Puteaux");
 		Adresse adresse7 = new Adresse("78 avenue du Président Wilson", "92800", "Puteaux");
 		Adresse adresse8 = new Adresse("12 rue de Nanterre", "92800", "Puteaux");
 		Adresse adresse9 = new Adresse("97 rue Pyrennées", "92800", "Puteaux");
 		Adresse adresse10 = new Adresse("44 boulevard Secrétan", "92800", "Puteaux");
 		Adresse adresse11= new Adresse("9 rue Hurlant", "92000", "Nanterre");
 		Adresse adresse12= new Adresse("36 avenue Jean Jaurès", "92000", "Nanterre");
 		Adresse adresse13= new Adresse("8 rue des Alouettes", "92000", "Nanterre");
 		Adresse adresse14= new Adresse("9 rue Lepage", "92000", "Nanterre");
 		Adresse adresse15= new Adresse("65 avenue des Marques", "92000", "Nanterre");
 		
 		
 		Customer client1= new Customer("Marianne", "Guibert", "0123654789", adresse1, conseiller1,agence);
 		Customer client2= new Customer("Anouk", "Godard", "0156984321", adresse2, conseiller1,agence);
 		Customer client3= new Customer("Witołd", "Dudek", "0196325418", adresse3, conseiller1,agence);
 		Customer client4= new Customer("Nazih", "Nader", "0136589742", adresse4, conseiller1,agence);
 		Customer client5= new Customer("Yusraa ", "Anaan ", "0196325478", adresse5, conseiller1,agence);
 		Customer client6= new Customer("Honoré", "Jalbert", "0193214567", adresse6, conseiller1,agence);
 		Customer client7= new Customer("Mavise", "Jardine", "0178924536", adresse7, conseiller1,agence);
 		Customer client8= new Customer("Gérard", "Chartier", "0145632897", adresse8, conseiller2,agence);
 		Customer client9= new Customer("Rebeca", "Lima", "0122635547", adresse9, conseiller2,agence);
 		Customer client10= new Customer("Guang", "Tsui", "0133669985", adresse10, conseiller2,agence);
 		Customer client11= new Customer("Mathilde", "Lavoie", "0177896542", adresse11, conseiller3,agence);
 		Customer client12= new Customer("Russell", "Bonsaint", "0136998567", adresse12, conseiller3,agence);
 		Customer client13= new Customer("Vick", "Saucier", "0144785236", adresse13, conseiller3,agence);
 		Customer client14= new Customer("Jay", "Dagenais", "0133669987", adresse14, conseiller3,agence);
 		Customer client15= new Customer("Orson", "Perreault", "0123369549", adresse15, conseiller3,agence);
 		customerRepository.save(client1);
 		customerRepository.save(client2);
 		customerRepository.save(client3);
 		customerRepository.save(client4);
 		customerRepository.save(client5);
 		customerRepository.save(client6);
 		customerRepository.save(client7);
 		customerRepository.save(client8);
 		customerRepository.save(client9);
 		customerRepository.save(client10);
 		customerRepository.save(client11);
 		customerRepository.save(client12);
 		customerRepository.save(client13);
 		customerRepository.save(client14);
 		customerRepository.save(client15);
 		
 		CompteCourant compteCourant1 = new CompteCourant("A100", 360, LocalDate.now(), CompteStatus.ACTIVER, client1, 1000);
 		CompteCourant compteCourant2 = new CompteCourant("A101", -900, LocalDate.now(), CompteStatus.ACTIVER, client2, 1000);
 		CompteCourant compteCourant3 = new CompteCourant("A102", 8500, LocalDate.now(), CompteStatus.ACTIVER, client3, 1000);
 		CompteCourant compteCourant4 = new CompteCourant("A103", 2300, LocalDate.now(), CompteStatus.ACTIVER, client4, 1000);
 		CompteCourant compteCourant5 = new CompteCourant("A104", -6000, LocalDate.now(), CompteStatus.ACTIVER, client5, 1000);
 		CompteCourant compteCourant6 = new CompteCourant("A105", 800, LocalDate.now(), CompteStatus.ACTIVER, client6, 1000);
 		CompteCourant compteCourant7 = new CompteCourant("A106", -930, LocalDate.now(), CompteStatus.ACTIVER, client7, 1000);
 		CompteCourant compteCourant8 = new CompteCourant("A107", 7003, LocalDate.now(), CompteStatus.ACTIVER, client8, 1000);
 		CompteCourant compteCourant9 = new CompteCourant("A108", -1006, LocalDate.now(), CompteStatus.ACTIVER, client9, 1000);
 		CompteCourant compteCourant10 = new CompteCourant("A109", 4005, LocalDate.now(), CompteStatus.ACTIVER, client10, 1000);
 		CompteCourant compteCourant11= new CompteCourant("A110", -1500, LocalDate.now(), CompteStatus.ACTIVER, client11, 1000);
 		CompteCourant compteCourant12= new CompteCourant("A111", 9500, LocalDate.now(), CompteStatus.ACTIVER, client12, 1000);
 		CompteCourant compteCourant13= new CompteCourant("A112", 3604, LocalDate.now(), CompteStatus.ACTIVER, client13, 1000);
 		CompteCourant compteCourant14= new CompteCourant("A113", -6633, LocalDate.now(), CompteStatus.ACTIVER, client14, 1000);
 		CompteCourant compteCourant15= new CompteCourant("A114", 3247, LocalDate.now(), CompteStatus.ACTIVER, client15, 1000);


 		compteRepository.save(compteCourant1);
 		compteRepository.save(compteCourant2);
 		compteRepository.save(compteCourant3);
 		compteRepository.save(compteCourant4);
 		compteRepository.save(compteCourant5);
 		compteRepository.save(compteCourant6);
 		compteRepository.save(compteCourant7);
 		compteRepository.save(compteCourant8);
 		compteRepository.save(compteCourant9);
 		compteRepository.save(compteCourant10);
 		compteRepository.save(compteCourant11);
 		compteRepository.save(compteCourant12);
 		compteRepository.save(compteCourant13);
 		compteRepository.save(compteCourant14);
 		compteRepository.save(compteCourant15);
 		
 		CompteEpargne compteEpargne1 = new CompteEpargne("B100", 0, LocalDate.now(), CompteStatus.ACTIVER, client1, 3);
 		CompteEpargne compteEpargne2 = new CompteEpargne("B101", 500000, LocalDate.now(), CompteStatus.ACTIVER, client3, 3);
 		CompteEpargne compteEpargne3 = new CompteEpargne("B102", 0, LocalDate.now(), CompteStatus.ACTIVER, client5, 3);
 		CompteEpargne compteEpargne4 = new CompteEpargne("B103", 35000, LocalDate.now(), CompteStatus.ACTIVER, client8, 3);
 		CompteEpargne compteEpargne5 = new CompteEpargne("B104", 1200, LocalDate.now(), CompteStatus.ACTIVER, client2, 3);
 		
 		compteRepository.save(compteEpargne1);
 		compteRepository.save(compteEpargne2);
 		compteRepository.save(compteEpargne3);
 		compteRepository.save(compteEpargne4);
 		compteRepository.save(compteEpargne5);
 		
 		
 		


 		
 	}



    public CompteRestController(CompteService compteService) {
        this.compteService = compteService;
    }


    @GetMapping(path = "/comptes")
    public List<Compte> ListComptes(){
        return compteService.listComptes();
    }
    
    @GetMapping(path = "/comptes/courant")
    public List<CompteCourant> listComptesCourant(){
        return  compteService.listComptesCourants();
    }
    
    @GetMapping(path = "/comptes/epargne")
    public List<CompteEpargne> listComptesEpargnes(){
        return compteService.listeCompteEpargnes();
    }

    @GetMapping(path = "/comptes/{compteId}")
    public Compte getCompte(@PathVariable Long compteId){
    return compteService.getCompte(compteId);
    }

    @PostMapping(path = "/comptes/courant")
    public CompteCourant saveCompteCourant(@RequestBody CompteCourant compteCourant){
        return compteCourantRepository.save(compteCourant);
    }

    @PostMapping(path = "/comptes/epargne")
    public CompteEpargne saveCompteEpargne(@RequestBody CompteEpargne compteEpargne){        
        System.out.println(compteEpargne);
        return compteEpargneRepository.save(compteEpargne);
    }


    @PutMapping(path = "/comptes/{countId}")
    public Compte updateCompte(@PathVariable Long countId,@RequestBody Compte compte ){
//        compte.setId(countId);
        return compteRepository.save(compte);
    }

    @DeleteMapping(path = "/comptes/{countId}")
    public void deleteCompte(@PathVariable Long countId){
        compteRepository.deleteById(countId);
    }

    @PutMapping(path = "/comptes/virement")
    public VirementDTO virement(@RequestBody VirementRequestDTO requestDTO){
        VirementDTO virement = compteService.virement(requestDTO.getCodeSource(),
                requestDTO.getCodeDestination(), requestDTO.getMontant() );
        return virement;
    }

}
