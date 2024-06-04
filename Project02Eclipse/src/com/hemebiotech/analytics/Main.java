package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * This class is the entry point.
 * It calls methods to get the different symptoms, then count them, sort them and finally write them in a result file.
 */
public class Main {
	
	/**
	 * This is the main method.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		ISymptomWriter writer = new WriteSymptomDataToFile();
		AnalyticsCounter counter = new AnalyticsCounter(reader, writer);
		
		List<String> symptoms = counter.getSymptoms();
		
		Map<String, Integer> symptomsMap = counter.countSymptoms(symptoms);
		
		Map<String, Integer> symptomsSort = counter.sortSymptoms(symptomsMap);
		
		counter.writeSymptoms(symptomsSort);
	}

}
