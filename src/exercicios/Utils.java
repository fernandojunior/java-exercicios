package exercicios;

import java.lang.reflect.Array;
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

	public static <T> void call(Object context, String methodName) throws RuntimeException {
		try {
			getAnyMethod(context.getClass(), methodName).invoke(context);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static <T> Class<?> getClass(String className) throws RuntimeException {
		try {
			return Class.forName(className);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static <T> void call(Object context, String className, String methodName) throws RuntimeException {
		try {
			call(context, methodName);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static Method getAnyMethod(Class<?> type, String name, Class<?>... parameterTypes)
			throws NoSuchMethodException, SecurityException {
		return type.getDeclaredMethod(name, parameterTypes);
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
		try {
			return (T) getClass(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static <T> T input(String message, Class<T> type) {
		print(message);
		return parse(input(), type);
	}

	public static String input(String message) {
		print(message);
		return input();
	}

	public static <T> T input(Class<T> type) {
		return parse(input(), type);
	}

	@SuppressWarnings("resource")
	public static String input() {
		return new Scanner(System.in).next();
	}

	@SuppressWarnings("unchecked")
	public static <T> T parse(String value, Class<T> type) {
		try {
			Method method = getAnyMethod(Utils.class, "parse" + type.getSimpleName(), String.class);
			return (T) method.invoke(null, value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T parse(String value, String className) {
		try {
			return (T) parse(value, Class.forName(className));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static String parseString(Object value) {
		return value.toString();
	}

	public static Character parseCharacter(String value) {
		return Character.valueOf(value.charAt(0));
	}

	public static Byte parseByte(String value) {
		return Byte.valueOf(value);
	}

	public static Byte parseByte(Number value) {
		return value.byteValue();
	}

	public static Short parseShort(String value) {
		return Short.valueOf(value);
	}

	public static Short parseShort(Number value) {
		return value.shortValue();
	}

	public static Integer parseInteger(String value) {
		return Integer.valueOf(value);
	}

	public static Integer parseInteger(Number value) {
		return value.intValue();
	}

	public static Long parseLong(String value) {
		return Long.valueOf(value);
	}

	public static Long parseLong(Number value) {
		return value.longValue();
	}

	public static Float parseFloat(String value) {
		return Float.valueOf(value);
	}

	public static Float parseFloat(Number value) {
		return value.floatValue();
	}

	public static Double parseDouble(String value) {
		return Double.valueOf(value);
	}

	public static Double parseDouble(Number value) {
		return value.doubleValue();
	}

	public static Boolean parseBoolean(Object value) {
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

	public static void print(Object... messages) {
		System.out.println(join(" ", messages));
	}

}
