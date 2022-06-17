package com.formation.proxibanque.lmhmjw.dto;

public class CreditDTO {

	private double soldesAvantCredit;
	private double soldesApresCredit ;	
	private boolean etatVirement = true;
	
	
	public double getSoldesAvantCredit() {
		return soldesAvantCredit;
	}
	
	public void setSoldesAvantCredit(double soldesAvantCredit) {
		this.soldesAvantCredit = soldesAvantCredit;
	}
	
	public double getSoldesApresCredit() {
		return soldesApresCredit;
	}
	
	public void setSoldesApresCredit(double soldesApresCredit) {
		this.soldesApresCredit = soldesApresCredit;
	}
	
	public boolean isEtatVirement() {
		return etatVirement;
	}
	
	public void setEtatVirement(boolean etatVirement) {
		this.etatVirement = etatVirement;
	}
	
		
	
	

}
