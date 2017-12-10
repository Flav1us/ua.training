package view;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {
	String ua_msg_source = "/Taxes/src/localization/messages_uk-UA.properties";
	String en_msg_source = "/Taxes/src/localization/messages_en-US.properties";
	
	private static final String UNABLE_PARSE_ID = "ID should be integer";

	private ResourceBundle res_bundle;
	
	private Locale locale;
	
	private StringBuilder htmlString = new StringBuilder();
	
	public void setLocale(String new_locale) {
		//if(equals) does not work: setLanguageTag requires "uk-UA", locale.toString returns "uk_UA".
		if(locale.toString().equals(new_locale)) return;
		locale = new Locale.Builder().setLanguageTag(new_locale).build();
	} 
	
	public void append(Object as_string) {
		htmlString.append(as_string + "\n");
	}

	/**
	 * adds error msg into the beginning of a page
	 */
	public void unableParseID() {
		htmlString.insert(0, UNABLE_PARSE_ID);
	}

	public CharSequence toHTML() {
		return htmlString.toString();
	}

	public void clear() {
		htmlString.delete(0, htmlString.length());
	}

}
