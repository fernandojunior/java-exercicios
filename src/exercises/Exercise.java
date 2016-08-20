package exercises;

import utils.Utils;
import utils.Window;

public abstract class Exercise extends Utils {

	public Exercise() {
		main();
	}

	abstract void main();

	public static void createExercice(int exerciceNumber) {
		create("exercises.Exercise" + exerciceNumber);
	}

	public static void main(String[] args) {
		createExercice(parseInt(Window.input("Digite o número do Exercício:")));
	}

}
