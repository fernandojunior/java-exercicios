package utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * This class provides helper methods for Java reflection.
 */
public class Reflection {

	public static <T> Class<?> getClass(String className) {
		try {
			return Class.forName(className);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static Method getAnyMethod(Class<?> type, String name, Class<?>... parameterTypes) {
		try {
			return type.getDeclaredMethod(name, parameterTypes);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static <T> T create(Class<T> type, Object... args) {
		try {
			return type.getConstructor(getArgumentTypes(args)).newInstance(args);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T create(String className) {
		return (T) create(getClass(className));
	}

	public static Class<?>[] getArgumentTypes(Object... args) {
		return (Class<?>[]) Utils.stream(args).map(x -> x.getClass()).toArray(size -> new Class[size]);
	}

	public static Object call(Object context, Class<?> type, String methodName, Object... args) {
		try {
			return getAnyMethod(type, methodName, getArgumentTypes(args)).invoke(context, args);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static Object call(Class<?> type, String methodName, Object... args) {
		return call(null, type, methodName, args);
	}

	public static Object call(Object context, String className, String methodName, Object... args)
			throws RuntimeException {
		return call(context, getClass(className), methodName, args);
	}

	public static Object call(String className, String methodName, Object... args) {
		return call(getClass(className), methodName, args);
	}

	public static Object call(Object context, String methodName, Object... args) {
		return call(context, context.getClass(), methodName, args);
	}

}
