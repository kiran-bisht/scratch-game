package com.kiranbisht.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SymbolUtil {
	
	public static List<List<String>> convertMatrixToList(String[][] matrix) {
		List<List<String>> listOfLists = new ArrayList<>();

		for (String[] rows : matrix) {

			List<String> listRow = new ArrayList<>();

			for (String value : rows) {
				listRow.add(value);
			}
			listOfLists.add(listRow);
		}

		return listOfLists;
	}

	public static String generateRandomSymbol(Map<String, Integer> symbolProbabilities) {
		List<String> symbols = new ArrayList<>();
		List<Integer> probailityPrefixSums = new ArrayList<>();

		int totalProbality = 0;

		for (Entry<String, Integer> entry : symbolProbabilities.entrySet()) {
			totalProbality += entry.getValue();
			symbols.add(entry.getKey());
			probailityPrefixSums.add(totalProbality);
		}

		int index = pickIndex(totalProbality, probailityPrefixSums);
		return symbols.get(index);
	}

	public static int pickIndex(int totalSum, List<Integer> prefixSums) {
		double target = totalSum * Math.random();

		int low = 0, high = prefixSums.size();
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (target > prefixSums.get(mid))
				low = mid + 1;
			else
				high = mid;
		}
		return low;
	}

	

}
