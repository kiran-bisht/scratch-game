package com.kiranbisht.model.response;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GameResponse {
	
	private List<List<String>> matrix;
	
	private int reward;
	
	@JsonProperty("applied_winning_combinations")
	private Map<String, List<String>> appliedWinningCombinations;
	
	@JsonProperty("applied_symbol_bonus")
	private String appliedSymbolBonus;

	public List<List<String>> getMatrix() {
		return matrix;
	}

	public void setMatrix(List<List<String>> matrix) {
		this.matrix = matrix;
	}

	public int getReward() {
		return reward;
	}

	public void setReward(int reward) {
		this.reward = reward;
	}

	public Map<String, List<String>> getAppliedWinningCombinations() {
		return appliedWinningCombinations;
	}

	public void setAppliedWinningCombinations(Map<String, List<String>> appliedWinningCombinations) {
		this.appliedWinningCombinations = appliedWinningCombinations;
	}

	public String getAppliedSymbolBonus() {
		return appliedSymbolBonus;
	}

	public void setAppliedSymbolBonus(String appliedSymbolBonus) {
		this.appliedSymbolBonus = appliedSymbolBonus;
	}

	@Override
	public String toString() {
		return "{  [matrix=" + matrix + ", reward=" + reward + ", appliedWinningCombinations="
				+ appliedWinningCombinations + ", appliedSymbolBonus=" + appliedSymbolBonus + "]";
	}
	
	
	
}
