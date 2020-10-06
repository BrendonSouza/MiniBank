/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Mew_Bank.Cadastro;
import Mew_Bank.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author brend
 */
public class PainelBuscarConta extends JPanel implements ActionListener {

    private JLabel label_num;
    private JLabel label_cpf;
    private JLabel label_end;
    private JLabel label_nome;
    private JLabel label_tipo;
    private JTextField txt_num;
    private JTextField txt_nome;
    private JTextField txt_cpf;
    private JTextField txt_end;
    private JTextField txt_tipo;
    private JButton cancela;
    private JButton confirmar;
    private Cadastro cadastro;
    //Variáveis criadas para comparações posteriores
    private ContaCorrente cc;
    private ContaPoupanca cp;
    private ContaBonificada cb;

    private ArrayList<Conta> contas;
    private int numConta;
    private int indice;

    public JTextField getTxt_num() {
        return txt_num;
    }

    public JButton getCancela() {
        return cancela;
    }

    public JButton getConfirmar() {
        return confirmar;
    }

    public PainelBuscarConta(Cadastro c) {
        cadastro = c;
        contas = new ArrayList<>();
        //cc,cb,cp, são auxiliares. Utilizaremos para verificar qual o tipo da conta está sendo tratada aqui.
        cc = new ContaCorrente(-1);
        cb = new ContaBonificada(-2);
        cp = new ContaPoupanca(-3);
        label_nome = new JLabel("Nome");
        label_cpf = new JLabel("CPF");
        label_end = new JLabel("Endereço");
        label_num = new JLabel("Número da Conta");
        label_tipo = new JLabel("Tipo de Conta:");
        txt_nome = new JTextField(35);
        txt_cpf = new JTextField(35);
        txt_end = new JTextField(35);
        txt_num = new JTextField(35);
        txt_tipo = new JTextField(35);
        confirmar = new JButton("Confirmar");
        cancela = new JButton("Limpar");

        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
        add(label_num);
        add(txt_num);
        add(label_nome);
        add(txt_nome);
        add(label_cpf);
        add(txt_cpf);
        add(label_end);
        add(txt_end);
        add(label_tipo);
        add(txt_tipo);
        add(confirmar);
        add(cancela);
        //desativa todos os txtFields
        txt_nome.setEnabled(false);
        txt_cpf.setEnabled(false);
        txt_end.setEnabled(false);
        txt_tipo.setEnabled(false);
        //Adicionamos os Actions listeners dos botões
        getConfirmar().addActionListener(this);
        getCancela().addActionListener(this);
        setSize(430, 400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = new Object();
        src = e.getSource();
        if (src == getConfirmar()) {
            if (txt_num.getText().isEmpty() == false) { // se a caixa de texto com o número da conta não estiver vazia
                contas = cadastro.getContas();
                numConta = Integer.parseInt(txt_num.getText());
                indice = cadastro.procuraConta(numConta);
                if (indice != -1) {//-1 é o retorno padrão de erro do método procuraConta
                    txt_nome.setText(contas.get(indice).getTitular().getNome());
                    txt_cpf.setText(contas.get(indice).getTitular().getCpf());
                    txt_end.setText(contas.get(indice).getTitular().getEndereco());
                    
                    if (contas.get(indice).getClass() == cp.getClass()) {// se as classes são iguais, então são onjetos iguais
                        txt_tipo.setText("Conta Poupança");
                    } 
                    else if (contas.get(indice).getClass() == cb.getClass()) {
                        txt_tipo.setText("Conta Bonificada");
                    } 
                    else {
                        txt_tipo.setText("Conta Corrente");
                    }
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Conta não encontrada");
                }
            }
        }
        if (src == getCancela()) {
            txt_nome.setText("");
            txt_cpf.setText("");
            txt_end.setText("");
            txt_tipo.setText("");
            txt_num.setText("");
        }
    }

}
