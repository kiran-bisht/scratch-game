package com.kiranbisht.model.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WinCombinations {

	@JsonProperty("same_symbol_3_times")
	private WinCombination sameSymbol3Times;

	@JsonProperty("same_symbol_4_times")
	private WinCombination sameSymbol4Times;

	@JsonProperty("same_symbol_5_times")
	private WinCombination sameSymbol5Times;

	@JsonProperty("same_symbol_6_times")
	private WinCombination sameSymbol6Times;

	@JsonProperty("same_symbol_7_times")
	private WinCombination sameSymbol7Times;

	@JsonProperty("same_symbol_8_times")
	private WinCombination sameSymbol8Times;

	@JsonProperty("same_symbol_9_times")
	private WinCombination sameSymbol9Times;

	@JsonProperty("same_symbols_horizontally")
	private WinCombination sameSymbolsHorizontally;

	@JsonProperty("same_symbols_vertically")
	private WinCombination sameSymbolsVertically;

	@JsonProperty("same_symbols_diagonally_left_to_right")
	private WinCombination sameSymbolsDiagonallyLeftToRight;

	@JsonProperty("same_symbols_diagonally_right_to_left")
	private WinCombination sameSymbolsSiagonallyRightToLeft;

	public WinCombinations() {
		// TODO Auto-generated constructor stub
	}

	public WinCombination getSameSymbol3Times() {
		return sameSymbol3Times;
	}

	public void setSameSymbol3Times(WinCombination sameSymbol3Times) {
		this.sameSymbol3Times = sameSymbol3Times;
	}

	public WinCombination getSameSymbol4Times() {
		return sameSymbol4Times;
	}

	public void setSameSymbol4Times(WinCombination sameSymbol4Times) {
		this.sameSymbol4Times = sameSymbol4Times;
	}

	public WinCombination getSameSymbol5Times() {
		return sameSymbol5Times;
	}

	public void setSameSymbol5Times(WinCombination sameSymbol5Times) {
		this.sameSymbol5Times = sameSymbol5Times;
	}

	public WinCombination getSameSymbol6Times() {
		return sameSymbol6Times;
	}

	public void setSameSymbol6Times(WinCombination sameSymbol6Times) {
		this.sameSymbol6Times = sameSymbol6Times;
	}

	public WinCombination getSameSymbol7Times() {
		return sameSymbol7Times;
	}

	public void setSameSymbol7Times(WinCombination sameSymbol7Times) {
		this.sameSymbol7Times = sameSymbol7Times;
	}

	public WinCombination getSameSymbol8Times() {
		return sameSymbol8Times;
	}

	public void setSameSymbol8Times(WinCombination sameSymbol8Times) {
		this.sameSymbol8Times = sameSymbol8Times;
	}

	public WinCombination getSameSymbol9Times() {
		return sameSymbol9Times;
	}

	public void setSameSymbol9Times(WinCombination sameSymbol9Times) {
		this.sameSymbol9Times = sameSymbol9Times;
	}

	public WinCombination getSameSymbolsHorizontally() {
		return sameSymbolsHorizontally;
	}

	public void setSameSymbolsHorizontally(WinCombination sameSymbolsHorizontally) {
		this.sameSymbolsHorizontally = sameSymbolsHorizontally;
	}

	public WinCombination getSameSymbolsVertically() {
		return sameSymbolsVertically;
	}

	public void setSameSymbolsVertically(WinCombination sameSymbolsVertically) {
		this.sameSymbolsVertically = sameSymbolsVertically;
	}

	public WinCombination getSameSymbolsDiagonallyLeftToRight() {
		return sameSymbolsDiagonallyLeftToRight;
	}

	public void setSameSymbolsDiagonallyLeftToRight(WinCombination sameSymbolsDiagonallyLeftToRight) {
		this.sameSymbolsDiagonallyLeftToRight = sameSymbolsDiagonallyLeftToRight;
	}

	public WinCombination getSameSymbolsSiagonallyRightToLeft() {
		return sameSymbolsSiagonallyRightToLeft;
	}

	public void setSameSymbolsSiagonallyRightToLeft(WinCombination sameSymbolsSiagonallyRightToLeft) {
		this.sameSymbolsSiagonallyRightToLeft = sameSymbolsSiagonallyRightToLeft;
	}

}
