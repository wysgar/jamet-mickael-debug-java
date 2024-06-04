package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Class that allows writing to a file.
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
	
	/**
	 * This method allows you to write the results to a file
	 * 
	 * @param symptoms List of symptoms that will be written to the result file.
	 */
	
	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		FileWriter writer;
		try {
			writer = new FileWriter ("result.out");
			
			for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
				writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
			}
			
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
