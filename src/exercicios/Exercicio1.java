package exercicios;

/*
Determine qual é a idade que o usuário faz no ano atual. 
Para isso solicite o ano de nascimento do usuário e o ano atual.
 */
class Exercicio1 extends App {

	void logic() {
		Integer anoAtual = integerify(input("Entre com o ano atual:"));
		Integer anoNascimento = integerify(input("Entre com o ano de nascimento:"));
		Integer qtdeAnos = anoAtual - anoNascimento;
		print("Em", anoAtual, "você faz (ou já fez)", qtdeAnos, "anos!");
	}

	public static void main(String[] args) {
		create(Exercicio1.class);
	}

}
