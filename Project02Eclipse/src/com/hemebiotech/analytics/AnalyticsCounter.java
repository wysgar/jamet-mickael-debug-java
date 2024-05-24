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
		return symptomReader.GetSymptoms();
	}
	
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> list = new HashMap<String, Integer>();
		for (String symptom : symptoms) {
			if (list.keySet().isEmpty()) {
				list.put(symptom, 1);
				System.out.println("vide");
			}
			else {
				for (String string : list.keySet()) {
					System.out.println(symptom + " : " + string);
					if (symptom == string) {
						System.out.println("+1");
						list.put(symptom, list.get(symptom) + 1);
					}
				}
			}
		}
		System.out.println(list);
		
		return list;
	}
	
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		TreeMap<String, Integer> sorted = new TreeMap<>();
		sorted.putAll(symptoms);
		return sorted;
	}
	
	public void writeSymptoms(Map<String, Integer> symptoms) {
		symptomWriter.writeSymptoms(symptoms);
	}
}
