package utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
	public static <T> T[] array(T... objects) {
		return objects;
	}

	@SuppressWarnings("unchecked")
	public static <T> T[] array(Collection<T> objects) {
		return (T[]) objects.toArray();
	}

	@SuppressWarnings("unchecked")
	public static <T> T[] array(Stream<T> objects) {
		return (T[]) objects.toArray();
	}

	@SafeVarargs
	public static <T> List<T> list(T... objects) {
		return Arrays.asList(objects);
	}

	public static <T> List<T> list(Stream<T> objects) {
		return objects.collect(Collectors.toList());
	}

	@SuppressWarnings("unchecked")
	public static <T> Set<?> set(T... objects) {
		return set(list(objects));
	}

	public static <T> Set<?> set(Collection<T> objects) {
		return new HashSet<T>(objects);
	}

	@SuppressWarnings("unchecked")
	public static <T> Stream<T> stream(T... objects) {
		return Stream.of(objects);
	}

	public static <T> Stream<T> stream(Collection<T> objects) {
		return objects.stream();
	}

	public static List<Integer> range(int stop) {
		return range(0, stop);
	}

	// TODO step argument with IntStream.iterate(start, n->n+1).limit(stop-1)
	public static List<Integer> range(int start, int stop) {
		return IntStream.range(start, stop).boxed().collect(Collectors.toList());
	}

	public static void print(Object message) {
		System.out.println(message);
	}

	public static void print(Object... messages) {
		System.out.println(join(" ", messages));
	}

	public static Class<?> type(Object object) {
		return object.getClass();
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

	public static Boolean parseBoolean(boolean value) {
		return Parser.parseBoolean(value);
	}

	public static Boolean parseBoolean(Object value) {
		return Parser.parseBoolean(value);
	}

}
