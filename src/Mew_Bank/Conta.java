package Mew_Bank;


import java.io.Serializable;
import javax.swing.JOptionPane;

public abstract class Conta implements Serializable{ //Essa é a classe mãe de todas as contas (corrente, onificada, ou poupança)
//atrivutos 
    protected double saldo;
    private int numConta;
    private Cliente titular ;//Aqui forçamos que toda Conta necessáriamente precisa ter um cliente, por meio dessa referência
    private static int total = 0;

    public Conta(int numConta) { //Construtor da classe
        Conta.total++;
        this.numConta = numConta;
    }

    public abstract void deposita(double valor); //Esse método abstrato tem que ser implementado por todas as classes filhas

    public boolean saca(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    public boolean transfere(double valor, Conta destino) {
        if (this.saca(valor)) {//A busca e verificações serão tratadas no painel que utilizará desse método
            destino.deposita(valor);
            return true;
        } else {
            return false;
        }
    }
//getters e setters
    public double getSaldo() {
        return this.saldo;
    }

    public int getNumConta() {
        return this.numConta;
    }

    public void setNumConta(int numConta) {
        if (numConta <= 0) {
            JOptionPane.showMessageDialog(null, "Número da Conta Inválido");
            return;
        }
        this.numConta = numConta;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public Cliente getTitular() {
        return this.titular;
    }

    public static int getTotal() {
        return Conta.total;
    }

}
