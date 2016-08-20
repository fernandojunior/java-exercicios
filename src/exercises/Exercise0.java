package exercises;

/**
 * Solicite o nome do usuário e a idade e escreva na tela usando o terminal.
 */
public class Exercise0 extends Exercise {

	void main() {
		String nome = input("Digite seu nome:");
		int idade = parseInt(input("Digite sua idade:"));
		print("Seu nome é", nome, "e", "seu idade é", idade);
	}

}
