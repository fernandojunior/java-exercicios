package exercicios;

/* Exercício 06
A partir de 3 notas fornecidas de um aluno, informe se ele foi aprovado, 
ficou de recuperação ou foi reprovado. 
A média de aprovação é >= 7.0; 
a média de recuperação é >= 5.0 e < 7.0; e 
a média do reprovado é < 5.0
*/
class Exercicio2 extends App {

	void logic() {
		print("Entre com a primeira nota:");
		float nota1 = parseFloat(input());
		float nota2 = parseFloat(input("Entre com a segunda nota:"));
		float nota3 = input("Entre com a terceira nota:", Float.class);
		float media = (nota1 + nota2 + nota3) / 3;
		if (media >= 7)
			print("Aprovado com média " + media);
		else if (media >= 5)
			print("Recuperação com média " + media);
		else
			print("Reprovado com média " + media);
	}

	public static void main(String[] args) {
		create("exercicios.Exercicio2");
	}

}
