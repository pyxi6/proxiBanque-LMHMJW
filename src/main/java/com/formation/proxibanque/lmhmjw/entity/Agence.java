package com.formation.proxibanque.lmhmjw.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Agence {
	@Id
	private String id;
	
	private LocalDate date_ouverture;
}
