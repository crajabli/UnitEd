package enums;

public enum Length {
	KM ("km"), M ("m"), CM ("cm"), MM ("mm"), MI ("mi"), YD ("yd"), FT ("ft"), IN ("in");
	
	private final String unit;
	
	Length(String unit)
	{
		this.unit = unit;
	}
	
	public String getUnit()
	{
		return this.unit;
	}
}
