package exercises;

import utils.Utils;
import utils.Window;

public abstract class Exercise extends Utils {

	abstract void logic();

	public static void main(String[] args) {
		int numero = parseInt(Window.input("Digite o número do Exercício:"));
		String exercicioName = "exercises.Exercise" + numero;
		Exercise exercicio = create(exercicioName);
		exercicio.logic();
	}

}
