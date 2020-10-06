package Mew_Bank;

public class ContaBonificada extends Conta implements Bonificacao{// classe filha de Conta, essa classe assina o
                                                                  //contrato de bonificação e pode implementar os métodos de tal interface;

    private double bonus;
    
    public ContaBonificada(int numConta) {
        super(numConta);                    //utilizo aqui o método da classe mãe conta
    }

    @Override
    public void deposita(double valor) {
        bonus = (valor*0.01)+valor; 
        super.saldo += bonus ;   //credito o bonus na conta
    }
     
}
