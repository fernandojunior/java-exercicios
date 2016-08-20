package exercises;

/**
 * Determine qual é a idade que o usuário faz no ano atual. Para isso solicite o
 * ano de nascimento do usuário e o ano atual.
 */
public class Exercise2 extends Exercise {

	void logic() {
		int anoAtual = parseInt(input("Entre com o ano atual:"));
		int anoNascimento = parseInt(input("Entre com o ano de nascimento:"));
		int idade = anoAtual - anoNascimento;
		print("Em", anoAtual, "você faz (ou já fez)", idade, "anos!");
	}

}
