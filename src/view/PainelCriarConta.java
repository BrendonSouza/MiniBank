/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import Mew_Bank.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author vrevy
 */
public class PainelCriarConta extends JPanel implements ActionListener {

    private Cadastro cadastro;
    private Cliente cliente;
    private ContaPoupanca cp;
    private ContaBonificada cb;
    private ContaCorrente cc;
    private Arquivo file;
    
    private JLabel label_nome;
    private JLabel label_cpf;
    private JLabel label_end;
    private JLabel label_saldo;
    private JLabel label_num;
    private JLabel label_tipo;
    private JTextField txt_nome;

    private JRadioButton poup;
    private JRadioButton bon;
    private JRadioButton cor;

    private JTextField txt_cpf;
    private JTextField txt_end;
    private JTextField txt_saldo;
    private JTextField txt_num;
    private JTextField txt_tipo;
    private JButton confirmar;
    private JButton salvar;
//getters
    public JTextField getTxt_nome() {
        return txt_nome;
    }

    public JTextField getTxt_cpf() {
        return txt_cpf;
    }

    public JTextField getTxt_end() {
        return txt_end;
    }

    public JTextField getTxt_saldo() {
        return txt_saldo;
    }

    public JTextField getTxt_num() {
        return txt_num;
    }

    public JTextField getTxt_tipo() {
        return txt_tipo;
    }

    public JButton getConfirmar() {
        return confirmar;
    }

    public JButton getVoltar() {
        return salvar;
    }

    public PainelCriarConta(Cadastro c) {
        int cont = 0;
        
        cadastro = c;
        ButtonGroup tipo_conta = new ButtonGroup();//criamos um grupo de botões, para organizar melhor
        poup = new JRadioButton("Poupança");
        bon = new JRadioButton("Conta Bonificada");
        cor = new JRadioButton("Conta Corrente");
        label_nome = new JLabel("Nome");
        label_cpf = new JLabel("CPF");
        label_end = new JLabel("Endereço");
        label_saldo = new JLabel("Saldo");
        label_num = new JLabel("Número da Conta");
        label_tipo = new JLabel("Tipo de Conta:");
        txt_nome = new JTextField(35);
        txt_cpf = new JTextField(35);
        txt_end = new JTextField(35);
        txt_saldo = new JTextField(35);
        txt_num = new JTextField(35);
        txt_tipo = new JTextField(35);
        confirmar = new JButton("Confirmar");
        salvar = new JButton("Salvar e Limpar Campos");

        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));

        add(label_nome);
        add(txt_nome);
        add(label_cpf);
        add(txt_cpf);
        add(label_end);
        add(txt_end);
        add(label_saldo);
        add(txt_saldo);
        add(label_num);
        add(txt_num);
        tipo_conta.add(poup);
        tipo_conta.add(bon);
        tipo_conta.add(cor);
        add(label_tipo);
        add(poup);
        add(bon);
        add(cor);
        add(confirmar);
        add(salvar);
       
        setSize(430, 400);
        setVisible(true);
        getConfirmar().addActionListener(this);
         getVoltar().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        Object src = new Object();
        src = e.getSource();

        if (src == getConfirmar()) {
            String nome = txt_nome.getText();
            String cpf = txt_cpf.getText();
            String endereco = txt_end.getText();
            Double saldo = Double.parseDouble(txt_saldo.getText());
            int numConta = Integer.parseInt(txt_num.getText());
            if(cadastro.procuraConta(numConta)!=-1|| numConta<0){ //-1 é o retoro padrão de erro do método procuraCOnta
                JOptionPane.showMessageDialog(null,"Conta já existente ou número inválido");
            }
            else{
            cliente = new Cliente();
            if (poup.isSelected()) { // verificamos qual tipo de conta será criado
                cp = new ContaPoupanca(numConta);
                cp.setTitular(cliente);
                cp.getTitular().setNome(nome);
                cp.getTitular().setCpf(cpf);
                cp.getTitular().setEndereco(endereco);
                cp.deposita(saldo);
                cadastro.criaConta(cp);
            } else if (bon.isSelected()) {
                cb = new ContaBonificada(numConta);
                cb.setTitular(cliente);
                cb.getTitular().setNome(nome);
                cb.getTitular().setCpf(cpf);
                cb.getTitular().setEndereco(endereco);
                cb.deposita(saldo);
                cadastro.criaConta(cb);
            } else {
                cc = new ContaCorrente(numConta);
                cc.setTitular(cliente);
                cc.getTitular().setNome(nome);
                cc.getTitular().setCpf(cpf);
                cc.getTitular().setEndereco(endereco);
                cc.deposita(saldo);
                cadastro.criaConta(cc);
            }
            JOptionPane.showMessageDialog(null,"Conta criada com Sucesso");
            }
        }
        if(src==getVoltar()){ //Esse é o botão que salva os arquivos
            file=new Arquivo(cadastro.getContas());
            try {
                file.escreveArquivo();
            } catch (IOException ex) {
                Logger.getLogger(PainelCriarConta.class.getName()).log(Level.SEVERE, null, ex);
            }
            txt_nome.setText("");
            txt_cpf.setText("");
            txt_end.setText("");
            txt_num.setText("");
            txt_saldo.setText("");
        
        }
    }
}
