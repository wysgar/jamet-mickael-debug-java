package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Interface for writing method.
 */
public interface ISymptomWriter {
	/**
	 * This method allows you to write the results to a file
	 * 
	 * @param symptoms List of symptoms that will be written to the result file.
	 */
	public void writeSymptoms(Map<String, Integer> symptoms);
}
