package enums;

public enum Weight {
	KG ("kg"), G ("g"), MG ("mg"), T ("t"),  LB("lb"), OZ ("oz");
	
	private final String unit;
	
	Weight(String unit)
	{
		this.unit = unit;
	}
	
	public String getUnit()
	{
		return this.unit;
	}

}
