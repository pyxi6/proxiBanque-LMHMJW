package com.formation.proxibanque.lmhmjw;

import com.formation.proxibanque.lmhmjw.entity.Compte;
import com.formation.proxibanque.lmhmjw.entity.enums.TypeCompte;
import com.formation.proxibanque.lmhmjw.repository.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class CompteServiceLmhmjwApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompteServiceLmhmjwApplication.class, args);
    }

    // creation d'un Bean pour tester si les info s'enregistre dans la base
    // le bean se lance à la compilation
    @Bean
    CommandLineRunner Start(CompteRepository compteRepository){
      return args -> {
          compteRepository.save(new Compte(null, 10000,new Date(), TypeCompte.COURANT));
          compteRepository.save(new Compte(null, 20500,new Date(), TypeCompte.EPARGNE));
          compteRepository.save(new Compte(null, 3070,new Date(), TypeCompte.COURANT));
          // finAll recupere tous les compte
          //foreach parcour la liste
          compteRepository.findAll().forEach(cp->{
              System.out.println(cp.getType());
              System.out.println(cp.getSolde());


          });
      };

    }
}
