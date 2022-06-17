package com.formation.proxibanque.lmhmjw.dto;

public class VirementDTO {
	
	CreditDTO creditDTO;
	
	DebitDTO debitDTO;

	public CreditDTO getCreditDTO() {
		return creditDTO;
	}

	public void setCreditDTO(CreditDTO creditDTO) {
		this.creditDTO = creditDTO;
	}

	public DebitDTO getDebitDTO() {
		return debitDTO;
	}

	public void setDebitDTO(DebitDTO debitDTO) {
		this.debitDTO = debitDTO;
	}

	
}
