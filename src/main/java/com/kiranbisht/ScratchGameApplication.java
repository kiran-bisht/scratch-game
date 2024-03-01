package com.kiranbisht;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kiranbisht.model.config.Configuration;
import com.kiranbisht.model.config.StandardSymbolProbability;
import com.kiranbisht.model.config.WinCombination;
import com.kiranbisht.model.response.GameResponse;
import com.kiranbisht.util.SymbolUtil;

public class ScratchGameApplication {

	public static Configuration config = null;

	public static void main(String[] args) throws Exception {

		String jsonFilePath = null;
		int bettingAmount = 100;
		
		for (int i = 0; i < args.length; i++) {
			
			if (args[i].equals("--config")) {
				jsonFilePath = args[i + 1];
			}

			if (args[i].equals("--betting-amount")) {
				bettingAmount = Integer.parseInt(args[i + 1]);
			}
		}

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

		try {
			InputStream stream = ScratchGameApplication.class.getResourceAsStream("/" + jsonFilePath);

			config = objectMapper.readValue(stream, Configuration.class);

		} catch (Exception e) {
			e.printStackTrace();
		}

		StandardSymbolProbability[][] probabilityMatrix = new StandardSymbolProbability[config.getRows()][config
				.getColumns()];

		for (StandardSymbolProbability probability : config.getProbabilities().getStandardSymbols()) {
			probabilityMatrix[probability.getRow()][probability.getColumn()] = probability;
		}

		String[][] matrix = buildSymbolMatrix(probabilityMatrix);
		String bonusSymbol = addBounsSymbolInMatrix(matrix);

		Map<String, List<String>> winCombinations = findWinCombinations(matrix, bonusSymbol);

		int reward = calculateReward(winCombinations, bonusSymbol, bettingAmount);

		GameResponse response = new GameResponse();
		response.setMatrix(SymbolUtil.convertMatrixToList(matrix));

		if (reward != 0) {
			response.setAppliedSymbolBonus(bonusSymbol);
			
		}
		response.setAppliedWinningCombinations(winCombinations);
		response.setReward(reward);

		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

		System.out.println(objectMapper.writeValueAsString(response));

	}

	
	private static String addBounsSymbolInMatrix(String[][] matrix) {
		String bonusSymbol = SymbolUtil.generateRandomSymbol(config.getProbabilities().getBonusSymbols().getSymbols());
		Random random = new Random();
		int randomRow = random.nextInt(config.getRows());
		int randomColumn = random.nextInt(config.getColumns());

		matrix[randomRow][randomColumn] = bonusSymbol;
		return bonusSymbol;
	}

	private static String[][] buildSymbolMatrix(StandardSymbolProbability[][] probabilityMatrix) throws Exception {
		String[][] matrix = new String[config.getRows()][config.getColumns()];

		for (int i = 0; i < config.getRows(); i++) {
			for (int j = 0; j < config.getColumns(); j++) {

				if (probabilityMatrix[i][j] == null) {
					throw new Exception("Config File is not correct");
				}

				matrix[i][j] = SymbolUtil.generateRandomSymbol(probabilityMatrix[i][j].getSymbols());

			}
		}
		return matrix;
	}

	private static Map<String, List<String>> findWinCombinations(String[][] matrix, String bonusSymbol) {

		Map<String, Integer> symbolCount = new HashMap<String, Integer>();

		for (int i = 0; i < config.getRows(); i++) {
			for (int j = 0; j < config.getColumns(); j++) {
				if (matrix[i][j] != bonusSymbol) {
					calculateSymbolCount(symbolCount, matrix[i][j]);
				}

			}

		}

		Map<String, List<String>> symbolWinCombinations = null;

		for (String symbol : symbolCount.keySet()) {

			List<String> winCombinations = new ArrayList();

			for (Entry<String, WinCombination> combination : config.getWinCombinations().entrySet()) {

				if ((combination.getValue().getWhen().equals("linear_symbols")
						&& isValidLinearWinCombination(combination.getValue().getCoveredAreas(), matrix, symbol))
						|| (combination.getValue().getWhen().equals("same_symbols")
								&& isValidSameSymbolCombination(symbolCount.get(symbol), combination.getValue()))) {

					winCombinations.add(combination.getKey());
				}

			}

			if (!winCombinations.isEmpty()) {
				
				if(symbolWinCombinations == null) {
					symbolWinCombinations = new HashMap<String, List<String>>();
				}
				symbolWinCombinations.put(symbol, winCombinations);
			}
		}

		return symbolWinCombinations;
	}

	private static boolean isValidSameSymbolCombination(Integer count, WinCombination winCombination) {
		return count.equals(winCombination.getCount()) ? true : false;
	}

	private static boolean isValidLinearWinCombination(List<List<String>> coveredAreas, String[][] matrix,
			String symbol) {
		if (coveredAreas != null && !coveredAreas.isEmpty()) {

			for (List<String> areas : coveredAreas) {

				boolean isVaild = true;

				for (String location : areas) {

					int i = Character.getNumericValue(location.charAt(0));
					int j = Character.getNumericValue(location.charAt(2));

					if (matrix[i][j] != symbol) {
						isVaild = false;
						break;
					}

				}

				if (isVaild) {
					return true;
				}
			}
		}
		return false;
	}

	private static void calculateSymbolCount(Map<String, Integer> symbolCount, String symbol) {
		if (!symbolCount.containsKey(symbol)) {
			symbolCount.put(symbol, 1);
		} else {
			symbolCount.put(symbol, symbolCount.get(symbol) + 1);
		}

	}

	private static int calculateReward(Map<String, List<String>> winCombinations, String bonusSymbol,
			int bettingAmount) {
		
		if(winCombinations == null) {
			return 0;
		}

		int totalReward = 0;

		for (Entry<String, List<String>> entry : winCombinations.entrySet()) {

			double symbolReward = 0;

			if (entry.getValue().isEmpty()) {
				continue;
			}

			symbolReward = bettingAmount * config.getSymbols().get(entry.getKey()).getRewardMultiplier();

			for (String winCombination : entry.getValue()) {

				symbolReward *= config.getWinCombinations().get(winCombination).getRewardMultiplier();

			}

			totalReward += symbolReward;
		}

		if (config.getSymbols().get(bonusSymbol).getRewardMultiplier() != null) {
			totalReward *= config.getSymbols().get(bonusSymbol).getRewardMultiplier();

		}

		else if (config.getSymbols().get(bonusSymbol).getExtra() != null) {
			totalReward += config.getSymbols().get(bonusSymbol).getExtra();
		}

		return totalReward;
	}

}
