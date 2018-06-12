package com.deloitte.helperclasses;

import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Class with helper functions for dealing with JSON strings, beyond
 * capabilities provided out of the box by Anypoint.
 * 
 * @author David Hunter (Deloitte)
 * @apiviz.landmark
 * @apiviz.uses com.fasterxml.jackson.databind.ObjectMapper
 */
public class JsonHelpers {

	/**
	 * Reads in a string, and returns an <code>ArrayList</code>, which, among other
	 * things, could be used to mock the results of a database call.
	 * 
	 * @param jsonString
	 *            The string to be converted to an <code>ArrayList</code>
	 * 
	 * @return <code>Object</code> (which, in this case, is an
	 *         <code>ArrayList</code>)
	 */
	public Object getArrayFromJson(String jsonString) {
		ObjectMapper mapper = new ObjectMapper();

		try {
			return mapper.readValue(jsonString, ArrayList.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Reads in a string, and returns a <code>HashMap</code>, which could be useful.
	 * 
	 * @param jsonString
	 *            The string to be converted to a <code>HashMap</code>
	 * 
	 * @return <code>Object</code> (which, in this case, is a <code>HashMap</code>
	 */
	public Object getMapFromJson(String jsonString) {
		ObjectMapper mapper = new ObjectMapper();

		try {
			return mapper.readValue(jsonString, HashMap.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
