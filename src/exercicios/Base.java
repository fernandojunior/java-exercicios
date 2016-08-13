package exercicios;

import java.util.Arrays;
import java.util.Scanner;

public class Base {

	public static Class<Integer> Inteiro = Integer.class;
	public static Class<String> Texto = String.class;
	public static Class<Float> Decimal = Float.class;
	public static Class<Boolean> Logico = Boolean.class;

	@SuppressWarnings("unchecked")
	public static <T> T ler(String mensagem, String tipo) {

		System.out.print(mensagem);
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		if (tipo.equals(Integer.class))
			return (T) new Integer(scanner.nextInt());
		if (tipo.equals(Float.class))
			return (T) new Float(scanner.nextFloat());
		if (tipo.equals(Double.class))
			return (T) new Double(scanner.nextDouble());
		if (tipo.equals(String.class))
			return (T) scanner.next();
		if (tipo.equals(Boolean.class)) {
			String value = scanner.next();
			if (Arrays.asList("verdadeiro", "true", "1").contains(value))
				return (T) new Boolean(true);
			if (Arrays.asList("false", "false", "0").contains(value))
				return (T) new Boolean(false);
			else
				return null;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static <T> T ler(String mensagem, Class<T> tipo) {
		if (mensagem != null)
			System.out.print(mensagem);
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String value = scanner.next();

		if (tipo.equals(Integer.class))
			return (T) Integer.valueOf(value);
		if (tipo.equals(Float.class))
			return (T) Float.valueOf(value.replace(",", "."));
		if (tipo.equals(Double.class))
			return (T) Double.valueOf(value.replace(",", "."));
		if (tipo.equals(String.class))
			return (T) value;
		if (tipo.equals(Boolean.class))
			if (Arrays.asList("verdadeiro", "true", "1").contains(value))
				return (T) new Boolean(true);
			else if (Arrays.asList("false", "false", "0").contains(value))
				return (T) new Boolean(false);
			else
				return null;
		return null;
	}

	public static String ler(String mensagem) {
		return ler(mensagem, String.class);
	}

	public static <T> T ler(Class<T> tipo) {
		return ler(null, tipo);
	}

	public static String ler() {
		return ler(null, String.class);
	}

	public static void escrever(String mensagem) {
		System.out.println(mensagem);
	}

	public static void main(String[] args) {
		// System.out.println(ler("Digite sua idade", Integer.class));
		Boolean a = ler("Digite sua idade", Logico);
		System.out.println(a);
	}

}
