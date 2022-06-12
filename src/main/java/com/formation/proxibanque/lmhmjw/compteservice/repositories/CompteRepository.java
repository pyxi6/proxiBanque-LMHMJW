package com.formation.proxibanque.lmhmjw.compteservice.repositories;

import com.formation.proxibanque.lmhmjw.compteservice.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

// la partie DAO
public interface CompteRepository  extends JpaRepository <Compte,Long > {
}
