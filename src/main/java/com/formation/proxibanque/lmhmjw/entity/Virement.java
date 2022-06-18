package com.formation.proxibanque.lmhmjw.entity;

public class Virement {
	private Long codeSource;
    private Long codeDestination;
    private double montant;
    
	public Long getCodeSource() {
		return codeSource;
	}
	public void setCodeSource(Long codeSource) {
		this.codeSource = codeSource;
	}
	public Long getCodeDestination() {
		return codeDestination;
	}
	public void setCodeDestination(Long codeDestination) {
		this.codeDestination = codeDestination;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
    
    
}
