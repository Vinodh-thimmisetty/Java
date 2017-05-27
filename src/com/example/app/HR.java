package com.example.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class HR implements IHRFunctions {

	public String[] employeeList(String[] listOfEmployees) {
		String sortedEmployeeList[] = new String[5];
		for (int i = 0; i < sortedEmployeeList.length; i++) {
			sortedEmployeeList[i] = listOfEmployees[i];
		}

		Arrays.sort(sortedEmployeeList, (a, b) -> a.compareToIgnoreCase(b));
		return sortedEmployeeList;

	}

	public String[] topPerformers(String[] listOfEmployees, List<int[]> parameters) {
		return mappingResults(listOfEmployees, parameters, -999);
	}

	public String parameterTopper(String[] listOfEmployees, List<int[]> parameters, String parameterType) {
		String parameterTopper = "";
		switch (parameterType) {
		case "Creativity":
			parameterTopper = mappingResults(listOfEmployees, parameters, 0)[0];
			break;
		case "Communication":
			parameterTopper = mappingResults(listOfEmployees, parameters, 1)[0];
			break;
		case "TechnicalSkills":
			parameterTopper = mappingResults(listOfEmployees, parameters, 2)[0];
			break;
		case "PersonalHabits":
			parameterTopper = mappingResults(listOfEmployees, parameters, 3)[0];
			break;
		case "TakeInitiative":
			parameterTopper = mappingResults(listOfEmployees, parameters, 4)[0];
			break;
		default:
		}

		return parameterTopper;
	}

	public String[] lazyEmployees(String[] listOfEmployees, int[] attendenceList) {
		ArrayList<int[]> list = new ArrayList<>();
		list.add(attendenceList);
		return mappingResults(listOfEmployees, list, -111);
	}

	/***
	 * 
	 * Utility Method
	 * 
	 * @param listOfEmployees
	 * @param parameters
	 * @param factor
	 * @return
	 */
	public String[] mappingResults(String[] listOfEmployees, List<int[]> parameters, int factor) {
		int[] sorts = {};
		if (factor >= 0) {
			sorts = parameters.stream().mapToInt(x -> x[factor]).toArray();

		} else if (factor == -111) {
			sorts = parameters.get(0);

		} else {
			sorts = parameters.stream().mapToInt(x -> Arrays.stream(x).reduce(0, Integer::sum)).toArray();

		}
		Map<String, Integer> mapp = new LinkedHashMap<>();
		Map<String, Integer> result = new LinkedHashMap<>();
		for (int i = 0; i < sorts.length; i++) {
			mapp.put(listOfEmployees[i], sorts[i]);
		}
		Stream<Entry<String, Integer>> stream = mapp.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()));

		if (factor >= 0) {
			stream.limit(1).forEachOrdered(x -> result.put(x.getKey(), x.getValue()));
		} else if (factor == -111) {
			mapp.entrySet().stream().sorted(Map.Entry.comparingByValue())
					.forEach(x -> result.put(x.getKey(), x.getValue()));

		} else {
			stream.limit(3).forEachOrdered(x -> result.put(x.getKey(), x.getValue()));

		}

		//System.out.println(Arrays.toString(result.values().toArray()));
		return result.keySet().toArray(new String[3]);
	}

}
