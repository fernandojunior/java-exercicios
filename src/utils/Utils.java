package exercicios;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
 * library
 * 
 * Examples: <br>
 * <code> 
	print(input("Digite sua idade", Integer.class));
	print(parse(input("Digite sua idade"), Integer.class));
	print(parseInteger(input("Digite sua idade")));
	Stream.of("asas,asas".split(",")).forEach(Utils::print);
	System.out.println(parseBoolean("true"));
	System.out.println(stream(list(array(list("1", "2"), String.class))));
 * </code>
 * 
 * @author Fernando Felix do Nascimento Junior
 *
 */
public class Utils {

	public static <T> Class<?> getClass(String className) throws RuntimeException {
		try {
			return Class.forName(className);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static Method getAnyMethod(Class<?> type, String name, Class<?>... parameterTypes) throws RuntimeException {
		try {
			return type.getDeclaredMethod(name, parameterTypes);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static <T> T create(Class<T> type) throws RuntimeException {
		try {
			return type.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T create(String className) throws RuntimeException {
		return (T) create(getClass(className));
	}

	public static Object call(Object context, Class<?> type, String methodName, Object... args)
			throws RuntimeException {
		try {
			Class<?>[] parameters = stream(args).map(x -> x.getClass()).toArray(size -> new Class[size]);
			return getAnyMethod(type, methodName, parameters).invoke(context);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static Object call(Class<?> type, String methodName, Object... args) throws RuntimeException {
		return call(null, type, methodName, args);
	}

	public static Object call(Object context, String className, String methodName, Object... args)
			throws RuntimeException {
		return call(context, getClass(className), methodName, args);
	}

	public static Object call(String className, String methodName, Object... args) throws RuntimeException {
		return call(getClass(className), methodName, args);
	}

	public static Object call(Object context, String methodName, Object... args) throws RuntimeException {
		return call(context, context.getClass(), methodName, args);
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

	@SuppressWarnings("unchecked")
	public static <T> T parse(Class<T> type, String value) {
		String parserName = type.getSimpleName().toLowerCase();
		char lastChar = parserName.charAt(parserName.length() - 1);
		if (list('a', 'e', 'i', 'o', 'u').contains(lastChar))
			parserName = parserName.substring(0, parserName.length() - 1);
		parserName += "ify";
		try {
			Method method = getAnyMethod(Utils.class, parserName, String.class);
			return (T) method.invoke(null, value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T parse(String value, String className) {
		return (T) parse(getClass(className), value);
	}

	public static String stringify(Object value) {
		return value.toString();
	}

	public static Character characterify(char value) {
		return value;
	}

	public static Character characterify(String value) {
		return Character.valueOf(value.charAt(0));
	}

	public static Byte bytify(byte value) {
		return value;
	}

	public static Byte bytify(Number value) {
		return value.byteValue();
	}

	public static Byte bytify(String value) {
		return Byte.valueOf(value);
	}

	public static Short shortify(short value) {
		return value;
	}

	public static Short shortify(Number value) {
		return value.shortValue();
	}

	public static Short shortify(String value) {
		return Short.valueOf(value);
	}

	public static Integer integerify(int value) {
		return value;
	}

	public static Integer integerify(Number value) {
		return value.intValue();
	}

	public static Integer integerify(String value) {
		return Integer.valueOf(value);
	}

	public static Long longify(long value) {
		return value;
	}

	public static Long longify(Number value) {
		return value.longValue();
	}

	public static Long longify(String value) {
		return Long.valueOf(value);
	}

	public static Float floatify(float value) {
		return value;
	}

	public static Float floatify(Number value) {
		return value.floatValue();
	}

	public static Float floatify(String value) {
		return Float.valueOf(value);
	}

	public static Double doublify(double value) {
		return value;
	}

	public static Double doublify(Number value) {
		return value.doubleValue();
	}

	public static Double doublify(String value) {
		return Double.valueOf(value);
	}

	public static Boolean booleanify(Object value) {
		return list(1, '1', "1", "true").contains(value) ? true : false;
	}

	public static String join(CharSequence delimiter, Object... o) {
		return stream(o).map(Object::toString).collect(Collectors.joining(delimiter));
	}

	@SuppressWarnings("unchecked")
	public static <T> Stream<T> stream(T... o) {
		return Stream.of(o);
	}

	public static <T> Stream<T> stream(List<T> o) {
		return o.stream();
	}

	@SafeVarargs
	public static <T> List<T> list(T... o) {
		return Arrays.asList(o);
	}

	@SuppressWarnings("unchecked")
	public static <T> T[] array(T... o) {
		return o;
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
}
