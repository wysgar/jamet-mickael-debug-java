package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * This class uses methods to get, count, sort and write a list of symptoms.
 */

public class AnalyticsCounter {
	ISymptomReader symptomReader;
	ISymptomWriter symptomWriter;
	
	/**
	 * Constructor with reader and writer parameter.
	 * 
	 * @param reader object of type ISymptomReader
	 * @param writer object of type ISymptomWriter
	 */
	public AnalyticsCounter (ISymptomReader reader, ISymptomWriter writer) {
		symptomReader = reader;
		symptomWriter = writer;
	}
	
	/**
	 * This method calls getSymptoms through the ISymptomReader interface.
	 * 
	 * @return returns a list of symptoms
	 */
	public List<String> getSymptoms() {
		return symptomReader.getSymptoms();
	}
	
	/**
	 * This method allows to count the number of occurrences of each symptom.
	 * 
	 * @param symptoms a list of symptoms.
	 * @return returns a map with symptoms as key and their number of occurrences as value.
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomsList = new HashMap<String, Integer>();
		for (String symptom : symptoms) {
			if (symptomsList.putIfAbsent(symptom, 1) != null) {
				symptomsList.put(symptom, symptomsList.get(symptom) + 1);
			}
		}
		return symptomsList;
	}
	
	/**
	 * This method sorts a map alphabetically.
	 * 
	 * @param symptoms a map of symptoms.
	 * @return returns the sorted map.
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		TreeMap<String, Integer> sortMap = new TreeMap<>();
		sortMap.putAll(symptoms);
		return sortMap;
	}
	
	/**
	 * This method calls writeSymptoms through the ISymptomWriter interface.
	 * 
	 * @param symptoms a map of symptoms.
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		symptomWriter.writeSymptoms(symptoms);
	}
}
