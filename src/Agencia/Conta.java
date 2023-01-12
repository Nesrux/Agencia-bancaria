package Agencia;
import Utilitarios.Util;


public class Conta {

	private static int contadorDecontas = 1;

	private int numeroConta;
	private Cliente cliente;
	private Double saldo = 0.0;

	Conta(Cliente cliente) {
		this.numeroConta = contadorDecontas;
		this.cliente = cliente;
		contadorDecontas++;

	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String toString() {
		return "\nNúmero da conta: "+this.getNumeroConta()+
		"\nNome: "+this.cliente.getNome()+
		"\nCpf: "+this.cliente.getCpf()+
		"\nEmail: "+this.cliente.getEmail()+
		"\nNome: "+ Util.doubleToString(this.getSaldo())+
		"\n";
	}
	
	public void depositar(Double valor) {
		if(valor > 0) {
			setSaldo(getSaldo()+ valor);
			System.out.println("Seu deposito foi realizado com sucesso!");
		}else {
			System.out.println("Não foi possivel realizar o deposito!");
		}
	}
	
	public void sacar(Double valor) {
		if(valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			System.out.println("Seu saque foi realizado com sucesso!");
		}else {
			System.out.println("Não foi possivel realizar o saque!");
		}
	}
	
	public void trnasferir(Conta contaParaDeposito, double valor) {
		if(valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo()- valor);
			
			 contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
			System.out.println("Transferencia realizada com sucesso!");
		}
	}

}
