package Mew_Bank;

import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author brend
 */
public class Cadastro {

    private static ArrayList<Conta> contas = new ArrayList<>(); //Criamos o arrayList que será a chave para a serialização/gravação de dados em disco
    private Cliente cliente;//referenciamos o cliente
    private static int tamanho; //Variável estática para não perdemos a referência toda vez que a classe for chamada

    public static void setContas(ArrayList<Conta> contas) {
        Cadastro.contas = contas;
    }

    public static int getTamanho() {
        return tamanho = contas.size();
    }

    public boolean criaConta(Conta conta) {
        contas.add(conta);

        return true;
    }

    public boolean removeConta(int numConta) {
        if (procuraConta(numConta) != -1) {
            int indice = procuraConta(numConta);
            contas.remove(indice);
            return true;
        }
        return false;
    }

    public int procuraConta(int numConta) {
        if (contas.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Não há contas cadastradas");
            return -1;
        } else {
            for (int i = 0; i < getTamanho(); i++) {
                if (contas.get(i).getNumConta() == numConta) {
                    System.out.println("Encontrei a conta  na posição" + i);
                    return i;
                }
            }
            return -1;//-1 é a saída padrão de erro do programa, como não há indices negativos num vetor.
        }
    }

    public static ArrayList<Conta> getContas() {
        return contas;
    }

}
