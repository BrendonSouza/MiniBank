package Mew_Bank;

public class ContaPoupanca extends Conta {//mais uma classe filha de contas

	public ContaPoupanca(int numConta) {
		super(numConta);//chama o construtor da classe mãe
	}

	@Override
	public void deposita(double valor) {
		super.saldo += valor;	
	}
	
}
