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
		switch(operacao) {
		case 1 :
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
	
	public static void criarConta(){
		System.out.println("\nNome: ");
		String nome = entrada.nextLine();
		
		System.out.println("\nCPF: ");
		String cpf = entrada.nextLine();
		
		System.out.println("\nEmail: ");
		String email = entrada.nextLine();
		
		
		Cliente cliente = new Cliente(nome, cpf, email);
		
		Conta conta = new Conta(cliente);
		
		contasBancarias.add(conta);
		System.out.println("Sua conta foi criada com sucesso!");
		
		operacoes();
	}
	
	public static void depositar() {}
	public static void sacar() {}
	public static void transferir() {}
	public static void listas() {}
	
}
