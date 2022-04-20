package enums;

import java.util.Arrays;
import java.util.List;

import utilities.Operand;

public enum Time
{
  MONTH ("months"), DAY("days"), HR("hr"), MIN("min");

  private final String unit;
  private static final List<String> TIMES = Arrays.asList("months", "days", "hr", "min", "person-months", "person-days");

  Time(String unit)
  {
    this.unit = unit;
  }

  public String getUnit()
  {
    return this.unit;
  }

  // Returns true if given String is a Time
  public static boolean instanceOf(final String other)
  {
    if (TIMES.contains(other))
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
