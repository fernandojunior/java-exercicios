package exercises;

import utils.Window;

/**
 * A partir de 3 notas fornecidas de um aluno, informe se ele foi aprovado,
 * ficou de recuperação ou foi reprovado. A média de aprovação é >= 7.0; a média
 * de recuperação é >= 5.0 e < 7.0; e a média do reprovado é < 5.0
 */
public class Exercise3 extends Exercise {

	void main() {
		float nota1 = parseFloat(Window.input("Entre com a primeira nota:"));
		float nota2 = parseFloat(Window.input("Entre com a segunda nota:"));
		float nota3 = parseFloat(Window.input("Entre com a terceira nota:"));
		float media = (nota1 + nota2 + nota3) / 3;
		if (media >= 7)
			Window.alert("Aprovado com média", media);
		else if (media >= 5)
			Window.alert("Recuperação com média", media);
		else
			Window.alert("Reprovado com média", media);
	}

}
