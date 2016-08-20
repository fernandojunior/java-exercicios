package utils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class provides helper methods from different classes of java.lang and
 * java.util packages.
 * 
 * References: https://docs.python.org/3/library/functions.html
 * http://www.java-tips.org/java-se-tips-100019/24-java-lang.html
 * http://jscience.org/api/javax/measure/unit/Unit.html
 * http://english.stackexchange.com/questions/26751/suffixes-for-verbification-
 * ify-icise-ificate
 * http://stackoverflow.com/questions/1193810/java-metric-unit-conversion-
 * library Window from JS
 * 
 * Examples: <br>
 * <code> 
	print(input("Digite sua idade", Integer.class));
	print(parse(Window.input("Digite sua idade"), Integer.class));
	print(parseInteger(input("Digite sua idade")));
	stream("asas,asas".split(",")).forEach(Utils::print);
	System.out.println(parseBoolean("true"));
	System.out.println(stream(list(array(list("1", "2"), String.class))));
 * </code>
 * 
 * @author Fernando Felix do Nascimento Junior
 *
 */
public class Utils {

	public static <T> T create(Class<T> type, Object... args) {
		return Reflection.create(type, args);
	}

	public static <T> T create(String className) {
		return Reflection.create(className);
	}

	public static <T> T input(String message, Class<T> type) {
		print(message);
		return parse(type, input());
	}

	public static String input(String message) {
		print(message);
		return input();
	}

	public static <T> T input(Class<T> type) {
		return parse(type, input());
	}

	@SuppressWarnings("resource")
	public static String input() {
		return new Scanner(System.in).next();
	}

	public static String join(CharSequence delimiter, Object... object) {
		return stream(object).map(Object::toString).collect(Collectors.joining(delimiter));
	}

	@SuppressWarnings("unchecked")
	public static <T> Stream<T> stream(T... object) {
		return Stream.of(object);
	}

	public static <T> Stream<T> stream(List<T> object) {
		return object.stream();
	}

	@SafeVarargs
	public static <T> List<T> list(T... object) {
		return Arrays.asList(object);
	}

	@SuppressWarnings("unchecked")
	public static <T> T[] array(T... object) {
		return object;
	}

	@SuppressWarnings("unchecked")
	public static <T> T[] array(List<T> o, Class<T> type) {
		return o.toArray((T[]) Array.newInstance(type, o.size()));
	}

	public static void print(Object message) {
		System.out.println(message);
	}

	public static void print(Object... messages) {
		System.out.println(join(" ", messages));
	}

	public static <T> T parse(Class<T> type, String value) {
		return Parser.parse(type, value);
	}

	public static <T> T parse(String parseName, String value) {
		return Parser.parse(parseName, value);
	}

	public static String parseString(Object value) {
		return Parser.parseString(value);
	}

	public static Character parseChar(char value) {
		return Parser.parseChar(value);
	}

	public static Character parseChar(String value) {
		return Parser.parseChar(value);
	}

	public static Byte parseByte(byte value) {
		return Parser.parseByte(value);
	}

	public static Byte parseByte(Number value) {
		return Parser.parseByte(value);
	}

	public static Byte parseByte(String value) {
		return Parser.parseByte(value);
	}

	public static Short parseShort(short value) {
		return Parser.parseShort(value);
	}

	public static Short parseShort(Number value) {
		return Parser.parseShort(value);
	}

	public static Short parseShort(String value) {
		return Parser.parseShort(value);
	}

	public static Integer parseInt(int value) {
		return Parser.parseInt(value);
	}

	public static Integer parseInt(Number value) {
		return Parser.parseInt(value);
	}

	public static Integer parseInt(String value) {
		return Parser.parseInt(value);
	}

	public static Long parseLong(long value) {
		return Parser.parseLong(value);
	}

	public static Long parseLong(Number value) {
		return Parser.parseLong(value);
	}

	public static Long parseLong(String value) {
		return Parser.parseLong(value);
	}

	public static Float parseFloat(float value) {
		return Parser.parseFloat(value);
	}

	public static Float parseFloat(Number value) {
		return Parser.parseFloat(value);
	}

	public static Float parseFloat(String value) {
		return Parser.parseFloat(value);
	}

	public static Double parseDouble(double value) {
		return Parser.parseDouble(value);
	}

	public static Double parseDouble(Number value) {
		return Parser.parseDouble(value);
	}

	public static Double parseDouble(String value) {
		return Parser.parseDouble(value);
	}

	public static Boolean parseBool(Object value) {
		return Parser.parseBool(value);
	}

}
