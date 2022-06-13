package com.formation.proxibanque.lmhmjw.entity;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("C")
public class Conseiller extends Employee {
	
}
