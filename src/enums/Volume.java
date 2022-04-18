package enums;

public enum Volume {
	GAL ("gal"), QT ("qt");

	private final String unit;
	
	Volume(String unit)
	{
		this.unit = unit;
	}
	
	public String getUnit()
	{
		return this.unit;
	}
}
