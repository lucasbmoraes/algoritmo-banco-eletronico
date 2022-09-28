package segundoSemestre.prova1;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		Conta varConta = new Conta();

		criaConta(ler, varConta);
		acessaConta(ler, varConta);
	}

	private static void acessaConta(Scanner ler, Conta varConta) {
		int op = 0;

		do {
			op = operacao(ler);

			switch (op) {
			case 1:
				System.out.print(varConta.getSaldo());
				break;
			case 2:
				System.out.println("Informe o valor do depósito:");
				double valor = Double.parseDouble(ler.nextLine());
				varConta.deposita(valor);
				;
				break;
			case 3:
				System.out.println("Informe o valor para ser sacado:");
				valor = Double.parseDouble(ler.nextLine());
				varConta.saque(valor);

				if (varConta.isStatus() == true) {
					System.out.print("Saque realizado!");
				} else {
					System.out.println("Saldo insuficiente!");
				}
				break;
			case 4:
				System.out.println("Sistema encerrado!");
				break;

			default:
				System.out.println("Você escolheu uma opção inválida, tente novamente!");
				;
				break;
			}

		} while (op != 4);
	}

	private static void criaConta(Scanner ler, Conta varConta) {
		System.out.println("Informe o número da conta:");
		varConta.setNumero(Integer.parseInt(ler.nextLine()));
		System.out.println("Informe o nome do cliente");
		varConta.setCliente(ler.nextLine());
		System.out.println("Informe o tipo da conta: \nCorrente \nPoupança \nSalário");
		varConta.setTipoConta(ler.nextLine());
		varConta.setSaldo(0);
		varConta.setStatus(true);

	}

	private static int operacao(Scanner ler) {
		int escolhaMenu = 0;
		do {
			System.out.println("\n\nMENU \n1-Saldo \n2-Depositar \n3-Sacar \n4-Finalizar sistema");
			escolhaMenu = Integer.parseInt(ler.nextLine());

			return escolhaMenu;
		} while (escolhaMenu < 1 || escolhaMenu > 4);
	}
}