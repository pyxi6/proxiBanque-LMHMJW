package com.formation.proxibanque.lmhmjw.dto;

public class DebitDTO {

	private double soldesAvant;
	private double soldesApres ;	
	private boolean etatVirement = true;

	
	public double getSoldesAvant() {
		return soldesAvant;
	}

	public void setSoldesAvant(double soldesAvant) {
		this.soldesAvant = soldesAvant;
	}

	public double getSoldesApres() {
		return soldesApres;
	}

	public void setSoldesApres(double soldesApres) {
		this.soldesApres = soldesApres;
	}

	public boolean isEtatVirement() {
		return etatVirement;
	}

	public void setEtatVirement(boolean etatVirement) {
		this.etatVirement = etatVirement;
	}

}
