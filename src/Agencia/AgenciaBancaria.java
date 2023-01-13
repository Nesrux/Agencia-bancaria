package Agencia;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {
	static Scanner entrada = new Scanner(System.in);
	static ArrayList<Conta> contasBancarias;

	public static void main(String[] args) {
		contasBancarias = new ArrayList<Conta>();

		operacoes();
	}

	public static void operacoes() {
		System.out.println("------------------------------------------------------");
		System.out.println("-------------Bem vindos a nossa Agência---------------");
		System.out.println("------------------------------------------------------");
		System.out.println("***** Selecione uma operação que deseja realizar *****");
		System.out.println("------------------------------------------------------");
		System.out.println("|   Opção 1 - Criar conta   |");
		System.out.println("|   Opção 2 - Depositar     |");
		System.out.println("|   Opção 3 - Sacar         |");
		System.out.println("|   Opção 4 - Transferir    |");
		System.out.println("|   Opção 5 - Listar        |");
		System.out.println("|   Opção 6 - Sair          |");

		int operacao = entrada.nextInt();
		switch (operacao) {
		case 1:
			criarConta();
			break;
		case 2:
			depositar();
			break;
		case 3:
			sacar();
			break;
		case 4:
			transferir();
			break;
		case 5:
			listas();
			break;
		case 6:
			System.out.println("Obrigado por usar nossa agencia");
			System.exit(0);
		default:
			System.out.println("Opção Inválida!");
			operacoes();
		}

	}

	public static void criarConta() {
		System.out.print("\nNome: ");
		String nome = entrada.next();

		System.out.print("\nCPF: ");
		String cpf = entrada.next();

		System.out.print("\nEmail: ");
		String email = entrada.next();

		Cliente cliente = new Cliente(nome, cpf, email);

		Conta conta = new Conta(cliente);

		contasBancarias.add(conta);
		System.out.println("Sua conta foi criada com sucesso!");

		operacoes();
	}

	private static Conta encontrarConta(int numeroConta) {
		Conta conta = null;
		if (contasBancarias.size() > 0) {
			for (Conta contaa : contasBancarias) {
				if (contaa.getNumeroConta() == numeroConta) {
					conta = contaa;
				}
			}
		}
		return conta;
	}

	public static void depositar() {
		System.out.println("Numero da conta: ");

		int numeroConta = entrada.nextInt();
		Conta conta = encontrarConta(numeroConta);

		if (conta != null) {
			System.out.println("Qual é o valor do deposito ?");
			Double valorDeposito = entrada.nextDouble();
			conta.depositar(valorDeposito);
			System.out.println("Valor depositado com Sucesso!");
		} else {
			System.out.println("A conta Não foi encontrada!");
		}
		operacoes();
	}

	public static void sacar() {
		System.out.println("Numero da conta: ");
		int numeroConta = entrada.nextInt();

		Conta conta = encontrarConta(numeroConta);

		if (conta != null) {
			System.out.println("Qual é o valor do saque ?");
			Double valorSaque = entrada.nextDouble();
			conta.sacar(valorSaque);
			System.out.println("Valor Sacado com sucesso! ");
		} else {
			System.out.println("A conta Não foi encontrada! ");
		}
		operacoes();
	}

	public static void transferir() {
		System.out.println("Numero da conta do remetente: ");
		int numeroContaRemetente = entrada.nextInt();

		Conta contaRemetente = encontrarConta(numeroContaRemetente);

		if (contaRemetente != null) {
			System.out.println("Número da conta do destinatário: ");
			int numeroContaDestinatario = entrada.nextInt();

			Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
			if (contaDestinatario != null) {
				System.out.println("valor da transferencia: ");
				Double valor = entrada.nextDouble();
				contaRemetente.trnasferir(contaDestinatario, valor);
			}
		}
		operacoes();
	}

	public static void listas() {
		if (contasBancarias.size() > 0) {
			for (Conta c : contasBancarias) {
				System.out.println(c);
			}
		} else {
			System.out.println("não existe contas disponiveis");
		}
		operacoes();
	}


}
