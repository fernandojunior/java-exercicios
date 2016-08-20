package exercises;

import utils.Window;

/**
 * Solicite o nome do usuário e a idade e escreva na tela usando janelas.
 */
public class Exercise1 extends Exercise {

	void main() {
		String nome = Window.input("Digite seu nome:");
		int idade = parseInt(Window.input("Digite sua idade:"));
		Window.alert("Seu nome é", nome, "e", "seu idade é", idade);
	}

}
