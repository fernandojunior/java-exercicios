package exercicios;

/* Exercício 06
A partir de 3 notas fornecidas de um aluno, informe se ele foi aprovado, 
ficou de recuperação ou foi reprovado. 
A média de aprovação é >= 7.0; 
a média de recuperação é >= 5.0 e < 7.0; e 
a média do reprovado é < 5.0
*/
public class Exercicio2 extends Base {

	public static void main(String[] args) {

		Float nota1, nota2, nota3, media;
		escrever("Entre com a primeira nota:");
		nota1 = ler(Decimal);
		System.out.println("Entre com a segunda nota:");
		nota2 = ler(Decimal);
		System.out.println("Entre com a terceira nota:");
		nota3 = ler(Decimal);
		media = (nota1 + nota2 + nota3) / 3;
		if (media >= 7) {
			escrever("Aprovado com média " + media);
		} else if (media >= 5) {
			escrever("Recuperação com média " + media);
		} else {
			escrever("Reprovado com média " + media);
		}
	}

}
