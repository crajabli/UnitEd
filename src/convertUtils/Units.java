package convertUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utilities.Operand;

/**
 * Units class.
 * 
 * @author Victor Aten
 * @version 05/04/2022
 */
public class Units {
	final static List<String> LENGTHS = Arrays.asList("in", "ft", "yd", "mi", "mm", "cm", "m", "km");
	final static List<String> WEIGHTS = Arrays.asList("oz", "lb", "ton", "g", "kg");
	final static List<String> VOLUMES = Arrays.asList("pt", "qt", "gal", "cc", "l");
	final static List<String> MONEY = Arrays.asList("c", "$");
	final static List<String> TIMES = Arrays.asList("sec", "hr", "day", "mon", "yr");
	final static List<String> SPEEDS = Arrays.asList("mi/sec", "mi/hr", "km/sec", "km/hr");
	private static final List<List<String>> UNITS = Arrays.asList(LENGTHS, WEIGHTS, VOLUMES, MONEY, TIMES, SPEEDS);

	/**
	 * Returns type list associated with the given Operands. Returns empty list if
	 * types don't match.
	 * 
	 * @param left  represents left Operand
	 * @param right represents right Operand
	 * @return List of Strings
	 */
	public static List<String> instanceOf(final Operand left, final Operand right) {
		List<String> result = new ArrayList<>();

		for (int i = 0; i < UNITS.size(); i++) {
			if (instanceOf(left, UNITS.get(i)) && instanceOf(right, UNITS.get(i))) {
				result.addAll(UNITS.get(i));
				break;
			}
		}

		return result;
	}

	/**
	 * Returns type list associated with the given Operand. Returns empty list if
	 * unit is unsupported.
	 * 
	 * @param left  represents left Operand
	 * @param right represents right Operand
	 * @return List of Strings
	 */
	public static List<String> instanceOf(final Operand op) {
		List<String> result = new ArrayList<>();

		for (int i = 0; i < UNITS.size(); i++) {
			if (instanceOf(op, UNITS.get(i))) {
				result.addAll(UNITS.get(i));
				break;
			}
		}

		return result;
	}

	/**
	 * Returns true if given String is in the given list.
	 * 
	 * @param other represents comparison object
	 * @param list  represents String list
	 * @return boolean
	 */
	public static boolean instanceOf(final String other, final List<String> list) {
		if (list.contains(other)) {
			return true;
		}

		return false;
	}

	/**
	 * Returns true if given Operand is in the given list.
	 * 
	 * @param other represents comparison object
	 * @param list  represents String list
	 * @return boolean
	 */
	public static boolean instanceOf(final Operand other, final List<String> list) {
		return instanceOf(other.getUnit(), list);
	}

	/**
	 * Returns true if the units are like units.
	 * 
	 * @param unit  first unit
	 * @param unit2 second unit
	 * @return boolean
	 */
	public static boolean instanceOf(final String left, final String right) {
		boolean result = false;
		if (left.contentEquals(right))
		{
			return true;
		}

		for (int i = 0; i < UNITS.size(); i++) {
			if (instanceOf(left, UNITS.get(i)) && instanceOf(right, UNITS.get(i))) {
				return true;
			}
		}

		return result;
	}

}
