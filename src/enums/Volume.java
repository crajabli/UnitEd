package enums;

import java.util.Arrays;
import java.util.List;

import utilities.Operand;

public enum Volume
{
  GAL("gal"), L("l");

  private final String unit;
  private static final List<String> WEIGHTS = Arrays.asList("gal", "l");

  Volume(String unit)
  {
    this.unit = unit;
  }

  public String getUnit()
  {
    return this.unit;
  }

  // Returns true if given String is a Volume
  public static boolean instanceOf(final String other)
  {
    if (WEIGHTS.contains(other))
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
