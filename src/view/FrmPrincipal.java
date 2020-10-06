/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Mew_Bank.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brend
 */
public class FrmPrincipal extends JFrame implements ActionListener {
    private Cadastro c;
    private JSplitPane split;
    private PainelMenu menu;
    private PainelMenuGerencia menuGerencia;
    private PainelMenuCliente menuCliente;
    private Cadastro cadastro;
    private ArrayList<Conta> contas;
    public FrmPrincipal(ArrayList<Conta> c) {
        split = new JSplitPane();
        menu = new PainelMenu();
        cadastro=new Cadastro();
        contas = new ArrayList<>();
        contas=c;
        cadastro.setContas(contas);
        menuGerencia = new PainelMenuGerencia();
        //contas=cadastro.getContas();
        menuCliente = new PainelMenuCliente(contas);
        
        getContentPane().add(split);
        split.setLeftComponent(menu);
        split.setRightComponent(new JPanel());
        menu.getBtn_cliente().addActionListener(this);
        menu.getBtn_gerencia().addActionListener(this);

        menuGerencia.getBtn_voltar().addActionListener(this);
        menuGerencia.getBtn_criarConta().addActionListener(this);
        menuGerencia.getBtn_buscarConta().addActionListener(this);
        menuGerencia.getBtn_excluirConta().addActionListener(this);
        menuGerencia.getBtn_editarConta().addActionListener(this);

        getContentPane().add(split);
        split.setLeftComponent(menu);
        split.setRightComponent(new JPanel());
//adição de todos os ActionListeners
        menuCliente.getBtn_voltar().addActionListener(this);
        menuCliente.getBtn_Saldo().addActionListener(this);
        menuCliente.getBtn_Saque().addActionListener(this);
        menuCliente.getBtn_Transferir().addActionListener(this);
        menuCliente.getBtn_Depositar().addActionListener(this);

        setSize(555, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public JSplitPane getSplit() {
        return split;
    }

    public static void main(String args[]) throws IOException, ClassNotFoundException {
        ArrayList<Conta> contas;
        contas=new ArrayList<>();//criamos um array vazio
        
        Arquivo file=new Arquivo(contas); //Passamos o array para a classe Arquivo
        if(file.podeLer()){ //se o retorno for true, já existe um arquivo com contas no sistema e devemos recuperá-las
           contas=file.lerArquivo();
        }
        //caso não exista o arquivo, iniciamos o programa com o array vazio
        FrmPrincipal frm = new FrmPrincipal(contas);
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        //Aqui temos todos os ActionListeners dos botões do cliente e do gerente
        if (src == menu.getBtn_gerencia()) {
            split.remove(1);
            split.setLeftComponent(menuGerencia);
            split.setRightComponent(new JPanel());
        }
        if (src == menuGerencia.getBtn_voltar()) {
            split.remove(1);
            split.setLeftComponent(menu);
            split.setRightComponent(new JPanel());
        }
        if (src == menuGerencia.getBtn_criarConta()) {
            split.setRightComponent(menuGerencia.actionCriarConta());
        }
        if (src == menuGerencia.getBtn_buscarConta()) {
            split.remove(2);
            split.setLeftComponent(menuGerencia);
            split.setRightComponent(menuGerencia.actionBuscarConta());
        }
        if (src == menuGerencia.getBtn_excluirConta()) {
            split.remove(2);
            split.setLeftComponent(menuGerencia);
            split.setRightComponent(menuGerencia.actionExcluirConta());
        }
        if (src == menuGerencia.getBtn_editarConta()) {
            split.remove(2);
            split.setLeftComponent(menuGerencia);
            split.setRightComponent(menuGerencia.actionEditarConta());
        }

        if (src == menu.getBtn_cliente()) {
            split.remove(1);
            split.setLeftComponent(menuCliente);
            split.setRightComponent(new JPanel());
        }

        if (src == menuCliente.getBtn_Saldo()) {
            split.remove(2);
            split.setLeftComponent(menuCliente);
            split.setRightComponent(menuCliente.actionSaldo());
        }

        if (src == menuCliente.getBtn_Depositar()) {
            split.remove(2);
            split.setLeftComponent(menuCliente);
            split.setRightComponent(menuCliente.actionDepositar());
        }

        if (src == menuCliente.getBtn_Transferir()) {
            split.remove(2);
            split.setLeftComponent(menuCliente);
            split.setRightComponent(menuCliente.actionTranferir());
        }

        if (src == menuCliente.getBtn_Saque()) {
            split.remove(2);
            split.setLeftComponent(menuCliente);
            split.setRightComponent(menuCliente.actionSaque());
        }

        if (src == menuCliente.getBtn_voltar()) {
            split.remove(1);
            split.setLeftComponent(menu);
            split.setRightComponent(new JPanel());
        }
    }
}
