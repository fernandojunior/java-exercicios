package utils;

import java.lang.reflect.Method;

/**
 * This class provides helper methods to parse a value from a simple type from
 * java.lang to another.
 */
public class Parser {

	public static <T> T parse(Class<T> type, String value) {
		return parse("parse" + type.getSimpleName(), value);
	}

	@SuppressWarnings("unchecked")
	public static <T> T parse(String parseName, String value) {
		try {
			Method method = Reflection.getAnyMethod(Parser.class, parseName, value.getClass());
			return (T) method.invoke(null, value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static String parseString(Object value) {
		return value.toString();
	}

	public static Character parseCharacter(char value) {
		return value;
	}

	public static Character parseCharacter(String value) {
		return Character.valueOf(value.charAt(0));
	}

	public static Character parseChar(char value) {
		return parseChar(value);
	}

	public static Character parseChar(String value) {
		return parseChar(value);
	}

	public static Byte parseByte(byte value) {
		return value;
	}

	public static Byte parseByte(Number value) {
		return value.byteValue();
	}

	public static Byte parseByte(String value) {
		return Byte.valueOf(value);
	}

	public static Short parseShort(short value) {
		return value;
	}

	public static Short parseShort(Number value) {
		return value.shortValue();
	}

	public static Short parseShort(String value) {
		return Short.valueOf(value);
	}

	public static Integer parseInteger(int value) {
		return value;
	}

	public static Integer parseInteger(Number value) {
		return value.intValue();
	}

	public static Integer parseInteger(String value) {
		return Integer.valueOf(value);
	}

	public static Integer parseInt(int value) {
		return parseInteger(value);
	}

	public static Integer parseInt(Number value) {
		return parseInteger(value);
	}

	public static Integer parseInt(String value) {
		return parseInteger(value);
	}

	public static Long parseLong(long value) {
		return value;
	}

	public static Long parseLong(Number value) {
		return value.longValue();
	}

	public static Long parseLong(String value) {
		return Long.valueOf(value);
	}

	public static Float parseFloat(float value) {
		return value;
	}

	public static Float parseFloat(Number value) {
		return value.floatValue();
	}

	public static Float parseFloat(String value) {
		return Float.valueOf(value);
	}

	public static Double parseDouble(double value) {
		return value;
	}

	public static Double parseDouble(Number value) {
		return value.doubleValue();
	}

	public static Double parseDouble(String value) {
		return Double.valueOf(value);
	}

	public static Boolean parseBoolean(boolean value) {
		return value;
	}

	public static Boolean parseBoolean(Object value) {
		return Utils.list(1, '1', "1", "true").contains(value) ? true : false;
	}

}
