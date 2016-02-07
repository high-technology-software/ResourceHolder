package com.high_technology_software.framework;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceHolder {

	private ResourceBundle mResource;
	private final String ERROR_NO_KEY = "<¿ Key: '{0}' doesn't exist ?>";

	public ResourceHolder(String filename) {
		mResource = ResourceBundle.getBundle(filename);
	}

	public ResourceHolder(String filename, Locale locale) {
		mResource = ResourceBundle.getBundle(filename, locale);
	}

	public String getValue(String key) {
		String value;
		
		try {
			value = mResource.getString(key);
		} catch (Exception e) {
			value = ERROR_NO_KEY.replace("{0}", key);
		}
		
		return value;
	}

}
