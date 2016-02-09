package com.high_technology_software.framework;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceHolder {

	private Properties mProperties;
	private final String ERROR_NO_KEY = "<¿ Key: '{0}' doesn't exist ?>";
	private final String ERROR_NO_FOUND_FILE = "FILE_NOT_FOUND";

	public ResourceHolder(String basename) {
		InputStream file = choosePropertiesFile(basename, null, null);
		initialization(file);
	}

	public ResourceHolder(String basename, Locale locale) {
		InputStream file = choosePropertiesFile(basename, locale.getLanguage(), locale.getCountry());
		initialization(file);
	}

	private void initialization(InputStream file) {
		mProperties = new Properties();
		try {
			mProperties.load(file);
		} catch (IOException e) {
			System.out.println("ResourceHolder >> " + ERROR_NO_FOUND_FILE);
		}
	}

	public String getValue(String key) {
		String value;

		try {
			value = String.valueOf(mProperties.get(key));
		} catch (Exception e) {
			value = ERROR_NO_KEY.replace("{0}", key);
		}

		return value;
	}

	private InputStream choosePropertiesFile(String basename, String language, String country) {
		InputStream result = null;
		int intent = (language == null ? 1 : (country == null ? 2 : 3));

		while (intent > 0 && result == null) {
			StringBuilder filename = new StringBuilder();

			switch (intent) {
				case 3:
					filename = new StringBuilder("_").append(country);
				case 2:
					filename = new StringBuilder("_").append(language).append(filename);
				case 1:
					filename = new StringBuilder(basename).append(filename).append(".properties");
			}

			result = getClass().getClassLoader().getResourceAsStream(filename.toString());
			intent--;
		}

		return result;
	}

}
