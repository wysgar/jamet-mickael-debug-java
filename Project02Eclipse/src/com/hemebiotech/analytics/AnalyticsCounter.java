package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	ISymptomReader symptomReader;
	ISymptomWriter symptomWriter;
	
	public AnalyticsCounter (ISymptomReader reader, ISymptomWriter writer) {
		symptomReader = reader;
		symptomWriter = writer;
	}
	
	public List<String> getSymptoms() {
		return symptomReader.getSymptoms();
	}
	
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomsList = new HashMap<String, Integer>();
		for (String symptom : symptoms) {
			if (symptomsList.putIfAbsent(symptom, 1) != null) {
				symptomsList.put(symptom, symptomsList.get(symptom) + 1);
			}
		}
		
		return symptomsList;
	}
	
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		TreeMap<String, Integer> sortMap = new TreeMap<>();
		sortMap.putAll(symptoms);
		return sortMap;
	}
	
	public void writeSymptoms(Map<String, Integer> symptoms) {
		symptomWriter.writeSymptoms(symptoms);
	}
}
