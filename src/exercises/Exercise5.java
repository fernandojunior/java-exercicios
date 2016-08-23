package exercises;

import utils.Window;

/**
 * A partir de 3 notas fornecidas de um aluno, informe se ele foi aprovado,
 * ficou de recuperação ou foi reprovado. A média de aprovação é >= 7.0; a média
 * de recuperação é >= 5.0 e < 7.0; e a média do reprovado é < 5.0. Utilize
 * funções e laços.
 */
public class Exercise5 extends Exercise {

	int inputInt(String message) {
		return parseInt(input(message));
	}

	float media(int[] notas) {
		float soma = 0;
		for (float nota : notas)
			soma += nota;
		return soma / len(notas);
	}

	String situacao(float media) {
		if (media >= 7)
			return "aprovado";
		else if (media >= 5)
			return "recuperação";
		else
			return "reprovado";
	}

	void main() {
		int[] notas = new int[3];

		for (int x : range(3))
			notas[x] = inputInt(join(" ", "Entre com a nota", x + 1, ":"));

		float media = media(notas);

		Window.alert("O aluno está", situacao(media), "com média", media);
	}

}
