package com.kiranbisht.model.config;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class Configuration {

	private Integer rows;

	private Integer columns;

	private Map<String, SymbolBody> symbols;

	private Probabilities probabilities;

	@JsonProperty("win_combinations")
	private Map<String, WinCombination> winCombinations;

	public Configuration() {
		// TODO Auto-generated constructor stub
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getColumns() {
		return columns;
	}

	public void setColumns(Integer columns) {
		this.columns = columns;
	}

	public Map<String, SymbolBody> getSymbols() {
		return symbols;
	}

	public void setSymbols(Map<String, SymbolBody> symbols) {
		this.symbols = symbols;
	}

	public Probabilities getProbabilities() {
		return probabilities;
	}

	public void setProbabilities(Probabilities probabilities) {
		this.probabilities = probabilities;
	}

	
	public Map<String, WinCombination> getWinCombinations() {
		return winCombinations;
	}

	public void setWinCombinations(Map<String, WinCombination> winCombinations) {
		this.winCombinations = winCombinations;
	}

	@Override
	public String toString() {
		return "Configuration [rows=" + rows + ", columns=" + columns + ", symbols=" + symbols + ", probabilities="
				+ probabilities + ", winCombinations=" + winCombinations + "]";
	}

}