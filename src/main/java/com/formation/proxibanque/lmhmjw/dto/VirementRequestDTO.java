package com.formation.proxibanque.lmhmjw.dto;

public class VirementRequestDTO {

    // il suffit de mettre que les attributs dont on a besoin dans la requet, pour faire un virement
    // + getter, setter
    private String codeSource;
    private String codeDestination;
    private double montant;

	public String getCodeSource() {
		return codeSource;
	}

	public void setCodeSource(String codeSource) {
		this.codeSource = codeSource;
	}

	public String getCodeDestination() {
		return codeDestination;
	}

	public void setCodeDestination(String codeDestination) {
		this.codeDestination = codeDestination;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}
}
