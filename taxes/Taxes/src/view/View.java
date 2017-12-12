package view;

import java.util.Map;
import java.util.ResourceBundle;

import entity.IncomeType;
import service.TaxCalculator;
import service.TaxSorter;

public class View {
	String ua_msg_source = "localization.messages_uk-UA";
	String en_msg_source = "localization.messages_en-US";
	
	//private static final String UNABLE_PARSE_ID = "ID should be integer";

	public ResourceBundle rb;
	private StringBuilder page = new StringBuilder();
	
	public View(String localeString) {
		switch (localeString) {
		case "uk-UA":
			rb = ResourceBundle.getBundle(ua_msg_source);
			break;
		default:
			rb = ResourceBundle.getBundle(en_msg_source);
			break;
		}
	}
	
	public void addSaved(String key) {
		if(!rb.containsKey(key)) {
			throw new RuntimeException("key " + key + " not found in " + rb.getBaseBundleName());
		}
		else {
			add(rb.getString(key));
			//System.out.println(rb.getString(key));
		}
	}
	
	public void addAllTaxes(Map<IncomeType, Double> all) {
		for(Map.Entry<IncomeType, Double> e : all.entrySet()) {
			addSaved(e.getKey().toString());
			add("\t");
			add(e.getValue().toString());
			add("\n");
		}
	}
	
	public void add(String s) {
		page.append(s);
	}
	
	public String getPage() {
		return page.toString();
	}

	public void addAllSortedTaxes(Map<IncomeType, Double> all) {
		addAllTaxes(TaxSorter.sort(all));
	}

}
