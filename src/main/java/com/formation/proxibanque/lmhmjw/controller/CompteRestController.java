package com.formation.proxibanque.lmhmjw.controller;

import com.formation.proxibanque.lmhmjw.entity.Compte;
import com.formation.proxibanque.lmhmjw.repository.CompteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompteRestController {

    // on a besoin d'accedez a la base
    // eviter @Autowaired deprciller
    private CompteRepository compteRepository;	

    // Faut generer un constructeur qui contient un param
    // injection via le constructeur (bonne pratique)
    public CompteRestController(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    // Creation des differentes methodes qui compose le CRUD

    // liste de tous les comptes acce en Get
    @GetMapping(path = "/comptes")
    public List<Compte> listComptes(){
        return compteRepository.findAll();
    };

    // Consulter un compte via l'ID
    @GetMapping(path="/comptes/{id}")
    //@PathVariable veut dire que le {id} est affecter à long id
    public Compte getCompte(@PathVariable Long id){
        return compteRepository.findById(id).get();
    };

    // Ajout compte via un post
    // le compte sont des donnees Json qui viennent du corp de la requet -> @RequestBody
    @PostMapping(path = "/comptes")
    public Compte save(@RequestBody Compte compte){
      return compteRepository.save(compte);
    };

    // Update d'un compte via put
    @PutMapping(path = "/comptes/{code}")
    public Compte update(@PathVariable Long code ,@RequestBody Compte compte){
        compte.setCode(code);
        return compteRepository.save(compte);
    };

    //Suppretion d'un compte avec Delete
    @DeleteMapping(path = "/comptes/{code}")
    public void delete(@PathVariable Long code){
        compteRepository.deleteById(code);
    };


}
