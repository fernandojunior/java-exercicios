package exercicios;

/*
Determine qual é a idade que o usuário faz no ano atual. 
Para isso solicite o ano de nascimento do usuário e o ano atual.
 */
class Exercicio1 extends App {

	void logic() {
		print("Entre com o ano atual:");
		int anoAtual = input(Integer.class);
		print("Entre com o ano de nascimento:");
		int anoNascimento = input(Integer.class);
		int qtdeAnos = anoAtual - anoNascimento;
		print("Em " + anoAtual + " você faz (ou já fez) " + qtdeAnos + " anos!");
	}

	public static void main(String[] args) {
		create("exercicios.Exercicio1");
	}

}
