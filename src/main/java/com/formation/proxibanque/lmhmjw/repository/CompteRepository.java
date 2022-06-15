package com.formation.proxibanque.lmhmjw.repository;

import com.formation.proxibanque.lmhmjw.entity.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

// la partie DAO
public interface CompteRepository  extends JpaRepository <Compte,String > {
}
