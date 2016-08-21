package exercises;

import utils.Utils;
import utils.Window;

public abstract class Exercise extends Utils {

	abstract void main();

	public static void main(String[] args) {
		int numeroExercicio = parseInt(Window.input("Digite o número do Exercício:"));
		String nomeExercicio = "exercises.Exercise" + numeroExercicio;
		Exercise exercicio = create(nomeExercicio);
		exercicio.main();
	}

}
