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

	// introduction de données en brute dans la base

	@PostConstruct
	public void dataloder() {
		List<CompteCourant> listeCompteCourant = List.of(
				new CompteCourant("A1200", 1200, LocalDate.now(), CompteStatus.ACTIVER, 1000),
				new CompteCourant("A1210", 130, LocalDate.now(), CompteStatus.SUPPRIMER, 1000),
				new CompteCourant("A1219", 13000, LocalDate.now(), CompteStatus.BLOQUER, 1000));

		List<CompteEpargne> listeCompteEpargne = List.of(
				new CompteEpargne("E1200", 1200, LocalDate.now(), CompteStatus.ACTIVER, 3.5),
				new CompteEpargne("E1210", 52300, LocalDate.now(), CompteStatus.ACTIVER, 2),
				new CompteEpargne("E1219", 300059, LocalDate.now(), CompteStatus.BLOQUER, 5.5));

		compteCourantRepository.saveAll(listeCompteCourant);

		compteEpargneRepository.saveAll(listeCompteEpargne);
	}

	public CompteRestController(CompteService compteService) {
		this.compteService = compteService;
	}

	@GetMapping(path = "/comptes")
	public List<Compte> listComptes() {
		return compteService.listComptes();
	}

	@GetMapping(path = "/comptes/courant")
	public List<CompteCourant> listComptesCourant() {
		return compteCourantRepository.findAll();
	}

	@GetMapping(path = "/comptes/epargne")
	public List<CompteEpargne> listeComptesEpargne() {
		return compteEpargneRepository.findAll();
	}

	@GetMapping(path = "/comptes/{compteId}")
	public Compte getCompte(@PathVariable Long compteId) {
		return compteService.getCompte(compteId);
	}

	@PostMapping(path = "/comptes/courant")
	public CompteCourant saveCompteCourant(@RequestBody CompteCourant compteCourant) {
		
		return compteCourantRepository.save(compteCourant);
	}

	@PostMapping(path = "/comptes/epargne")
	public CompteEpargne saveCompteEpargne(@RequestBody CompteEpargne compteEpargne) {
		
		return compteEpargneRepository.save(compteEpargne);
	}


	@PutMapping(path = "/comptes/courant/{countId}")
	
	public CompteCourant updateCompteCourant(@PathVariable Long countId,
											 @RequestBody CompteCourant compteCourant) {
        compteCourant.setId(countId);
		return compteRepository.save(compteCourant);
	}

	@PutMapping(path = "/comptes/epargne/{countId}")
	public CompteEpargne updateCompteEpargne(@PathVariable Long countId,
											 @RequestBody CompteEpargne compteEpargne) {
		
		return compteRepository.save(compteEpargne);
	}

	@DeleteMapping(path = "/comptes/{countId}")
	public void deleteCompte(@PathVariable Long countId) {
		compteRepository.deleteById(countId);
	}

	@PutMapping(path = "/comptes/virement")
	public void virement(@RequestBody VirementRequestDTO requestDTO) {
		compteService.virement(requestDTO.getCodeSource(), requestDTO.getCodeDestination(), requestDTO.getMontant());
	}

}
