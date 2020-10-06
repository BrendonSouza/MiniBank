package Mew_Bank;

public class ContaCorrente extends Conta {//Classe filha de conta, portanto já implementa Serializable

    public ContaCorrente(int numConta) {
        super(numConta);//chamada do construtor da classe mãe
    }

    @Override
    public boolean saca(double valor) {
        double valorASacar = valor + 0.2;//cobramos uma taxa de 0,2 centavos para a operação de saque.
        return super.saca(valorASacar);//chamamos o método saca da classe mãe
    }

    @Override
    public void deposita(double valor) {
        super.saldo += valor;
    }
    //calculamos o Imposto
    public double getValorImposto() {
        return super.saldo * 0.01;
    }

}
