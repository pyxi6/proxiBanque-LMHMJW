package com.formation.proxibanque.lmhmjw.controller;

import com.formation.proxibanque.lmhmjw.dto.VirementRequestDTO;
import com.formation.proxibanque.lmhmjw.entity.*;
import com.formation.proxibanque.lmhmjw.entity.enums.CompteStatus;
import com.formation.proxibanque.lmhmjw.repository.CompteCourantRepository;
import com.formation.proxibanque.lmhmjw.repository.CompteEpargneRepository;
import com.formation.proxibanque.lmhmjw.repository.CompteRepository;
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
     @PostConstruct
public void dataloder(){
    List<CompteCourant> listeCompteCourant= List.of(
            new CompteCourant(1000),
            new CompteCourant(29899),
            new CompteCourant(122,LocalDate.now(),CompteStatus.ACTIVER));
    

    compteCourantRepository.saveAll(listeCompteCourant);

}


    public CompteRestController(CompteService compteService) {
        this.compteService = compteService;
    }


    @GetMapping(path = "/comptes")
    public List<Compte> ListComptes(){
        return compteService.listComptes();
    }

    @GetMapping(path = "/comptes/{compteId}")
    public Compte getCompte(@PathVariable String compteId){
    return compteService.getCompte(compteId);
    }

    @PostMapping(path = "/comptes/courant")
    public CompteCourant saveCompteCourant(@RequestBody CompteCourant compteCourant){
        return compteCourantRepository.save(compteCourant);
    }

    @PostMapping(path = "/comptes/epargne")
    public CompteEpargne saveCompteEpargne(@RequestBody CompteEpargne compteEpargne){
        System.out.println("------------------------------------");
        System.out.println("#####################################");
        System.out.println("------------------------------------");
        System.out.println(compteEpargne);
        return compteEpargneRepository.save(compteEpargne);
    }


    @PutMapping(path = "/comptes/{countId}")
    public Compte updateCompte(@PathVariable String countId,@RequestBody Compte compte ){
//        compte.setId(countId);
        return compteRepository.save(compte);
    }

    @DeleteMapping(path = "/comptes/{countId}")
    public void deleteCompte(String countId){
        compteRepository.deleteById(countId);
    }

    @PutMapping(path = "/comptes/virement")
    public void virement(@RequestBody VirementRequestDTO requestDTO){
        compteService.virement(requestDTO.getCodeSource(),
                requestDTO.getCodeDestination(), requestDTO.getMontant() );
    }

}
