package exercises;

/**
 * Solicite ao usuário um valor inteiro x, depois escreva na tela de 1 até x.
 */
public class Exercise4 extends Exercise {

	int inputInt(String message) {
		return parseInt(input(message));
	}

	void main() {
		int x = inputInt("Entre com o valor de x:");
		for (int i : range(x))
			print(i + 1);
	}

}
