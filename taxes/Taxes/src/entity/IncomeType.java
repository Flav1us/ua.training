package entity;

import java.util.Arrays;

public enum IncomeType {
	primary_job, secondary_job, authors_reward(0.215), sale(0.05), gift,
		abroad_transfer, benefits_for_children, material_aid;
	
	double tax_rate = 0.18;
	
	public double getTaxRate() {
		return tax_rate;
	}

	private IncomeType(double tax_rate) {
		this.tax_rate = tax_rate;
	}
	
	private IncomeType(){};
	
	public static IncomeType getByName(String name) {
		return Arrays.asList(IncomeType.values())
				.stream()
				.filter(it -> it.name().equals(name))
				.findFirst().get();
	}
	
	
}