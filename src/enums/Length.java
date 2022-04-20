package enums;

import java.util.Arrays;
import java.util.List;

import utilities.Operand;

public enum Length
{
  KM("km"), M("m"), CM("cm"), MI("mi"), FT("ft"), IN("in");

  private final String unit;
  private static final List<String> LENGTHS = Arrays.asList("km", "m", "cm", "mi", "ft", "in");

  Length(final String unit)
  {
    this.unit = unit;
  }

  public String getUnit()
  {
    return this.unit;
  }

  // Returns true if given String is a Length
  public static boolean instanceOf(final String other)
  {
    if (LENGTHS.contains(other))
    {
      return true;
    }

    return false;
  }

  // Returns true if given operand is a Length
  public static boolean instanceOf(final Operand other)
  {
    return instanceOf(other.getUnit());
  }
}
