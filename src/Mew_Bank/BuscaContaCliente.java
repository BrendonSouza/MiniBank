/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mew_Bank;
import java.util.ArrayList;

/**
 *
 * @author brend
 */
public class BuscaContaCliente {
    private ArrayList<Conta> contas;
    public BuscaContaCliente(ArrayList<Conta> c) {
        contas= new ArrayList<>();
        contas=c;
    }
        public int procuraConta(int numConta) {
        if (contas.isEmpty()) {
            System.out.println("Não tem nada");
            return -1;
        } else {
            for (int i = 0; i < contas.size(); i++) {
                if (contas.get(i).getNumConta() == numConta) {
                    System.out.println("Encontrei a conta  na posição " + i);
                    return i;
                }

            }
            return -1;
        }
    }
}
