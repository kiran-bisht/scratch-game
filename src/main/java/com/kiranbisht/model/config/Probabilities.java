package com.kiranbisht.model.config;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Probabilities {
	
	@JsonProperty("standard_symbols")
	private List<StandardSymbolProbability> standardSymbols;
	
	@JsonProperty("bonus_symbols")
	private BonusSymbolProbability bonusSymbols;

	public Probabilities() {
		// TODO Auto-generated constructor stub
	}

	public List<StandardSymbolProbability> getStandardSymbols() {
		return standardSymbols;
	}

	public void setStandardSymbols(List<StandardSymbolProbability> standardSymbols) {
		this.standardSymbols = standardSymbols;
	}

	public BonusSymbolProbability getBonusSymbols() {
		return bonusSymbols;
	}

	public void setBonusSymbols(BonusSymbolProbability bonusSymbols) {
		this.bonusSymbols = bonusSymbols;
	}

}
