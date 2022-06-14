package com.formation.proxibanque.lmhmjw.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
	
	private String numEtRue;

	private String codePostal;

	private String ville;
	
	public String getNumEtRue() {
		return numEtRue;
	}
	public void setNumEtRue(String numEtRue) {
		this.numEtRue = numEtRue;
	}

	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	

	public Adresse(String numEtRue, String codePostal, String ville) {

		this.numEtRue = numEtRue;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	public Adresse() {
	}

	@Override
	public String toString() {
		return "Adresse [numEtRue=" + numEtRue + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}
	
	
	
	
	
	
	
	

}
