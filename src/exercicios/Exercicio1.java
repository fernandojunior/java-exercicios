package exercicios;

/*
Determine qual é a idade que o usuário faz no ano atual. 
Para isso solicite o ano de nascimento do usuário e o ano atual.
 */
public class Exercicio1 extends Base {

	public static void main(String[] args) {

		int anoAtual, anoNascimento, qtdeAnos;
		escrever("Entre com o ano atual:");
		anoAtual = ler(Inteiro);
		escrever("Entre com o ano de nascimento:");
		anoNascimento = ler(Inteiro);
		qtdeAnos = anoAtual - anoNascimento;
		escrever("Em " + anoAtual + " você faz (ou já fez) " + qtdeAnos + " anos!");
	}

}
