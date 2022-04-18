package enums;

public enum Time {
	DAY ("day");
	
	private final String unit;
	
	Time(String unit)
	{
		this.unit = unit;
	}
	
	public String getUnit()
	{
		return this.unit;
	}
}
