package Agencia;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class AgenciaBancaria {

	static ArrayList<Conta> contasBancarias;

	public static void main(String[] args) {
		contasBancarias = new ArrayList<Conta>();

		operacoes();
	}

	public static void operacoes() {

		int operacao = Integer.parseInt(JOptionPane.showInputDialog("---Selecione uma operação---\n" +

				"|   Opção 1 - Criar conta   |" + "|   Opção 2 - Depositar     |" + "|   Opção 3 - Sacar         |"
				+ "|   Opção 4 - Transferir    |" + "|   Opção 5 - Listar        |" + "|   Opção 6 - Sair          |"));

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
			JOptionPane.showMessageDialog(null, "Obrigado por usar nossa agencia");
			System.exit(0);
		default:
			JOptionPane.showMessageDialog(null, "Opção Inválida!");
			operacoes();
		}

	}

	public static void criarConta() {
		Cliente cliente = new Cliente();
		cliente.setNome(JOptionPane.showInputDialog("Nome: "));
		cliente.setCpf(JOptionPane.showInputDialog("CPF: "));
		cliente.setEmail(JOptionPane.showInputDialog("Email: "));

		Conta conta = new Conta(cliente);

		contasBancarias.add(conta);
		JOptionPane.showMessageDialog(null, "Sua conta foi criada com sucesso!");
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
		int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Numero Da conta para deposito: "));
		Conta conta = encontrarConta(numeroConta);

		if (conta != null) {
			Double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Qual é o valor que deseja depositar?"));
			conta.depositar(valorDeposito);
			JOptionPane.showMessageDialog(null, "Valor depositado com sucesso");
		} else {
			JOptionPane.showMessageDialog(null, "Sua conta não foi encontrada!");
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
			// System.out.println("Valor Sacado com sucesso! ");
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
			} else {
				System.out.println("A conta para deposito não foi encontrada");
			}
		} else {
			System.out.println("Conta para transferencia não encontrada! ");
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
