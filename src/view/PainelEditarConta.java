/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Mew_Bank.Arquivo;
import Mew_Bank.Cadastro;
import Mew_Bank.Conta;
import Mew_Bank.ContaCorrente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author vrevy
 */
public class PainelEditarConta extends JPanel implements ActionListener {
    
    private Cadastro cadastro;
    private JLabel label_cpf;
    private JLabel label_end;
    private JLabel label_num;
    private JLabel label_tipo;
    private JTextField txt_nome;
    private JTextField txt_cpf;
    private JTextField txt_end;
    private JTextField txt_num;
    private JTextField txt_tipo;
    private JButton confirmar;
    private JButton Limpar;
    private JLabel label_nome;
    private ArrayList<Conta> contas;
    private String nome;
    private String Cpf;
    private String Endereco;
    private Arquivo file;
    private int numConta;
    private int indice;

    public JTextField getTxt_nome() {
        return txt_nome;
    }

    public JTextField getTxt_cpf() {
        return txt_cpf;
    }

    public JTextField getTxt_end() {
        return txt_end;
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

    public JButton getLimpar() {
        return Limpar;
    }

    public PainelEditarConta(Cadastro c) {
        cadastro = c;
        contas = new ArrayList<>(); // inicializo o arrayList que contem as informações dos clientes
        
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
        Limpar = new JButton("Limpar e Salvar Alterações");

        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));

        add(label_num);
        add(txt_num);
        add(label_nome);
        add(txt_nome);
        add(label_cpf);
        add(txt_cpf);
        add(label_end);
        add(txt_end);

        add(confirmar);
        add(Limpar);
        setSize(430, 400);
        getConfirmar().addActionListener(this);
        getLimpar().addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object src = new Object();
        src = e.getSource();
        if (src == getConfirmar()) {

            if (txt_num.getText().isEmpty() == false) {
                numConta = Integer.parseInt(txt_num.getText());
                indice = cadastro.procuraConta(numConta);
                if (indice != -1) {//-1 é o retorno padrão para erro do método procuraConta
                    contas = cadastro.getContas(); //Faz uma cópia de todas as contas cadastradas para uma variável local
                    JOptionPane.showMessageDialog(null, "Nome: " + contas.get(indice).getTitular().getNome() + "\n"
                            + "CPF: " + contas.get(indice).getTitular().getCpf() + "\n Endereço: " + contas.get(indice).getTitular().getEndereco());
                    //exibo em tela os dados atuais do cliente
                    nome = txt_nome.getText();
                    Cpf = txt_cpf.getText();
                    Endereco = txt_end.getText();
                    //verifico se os campos estão preenchidos, caso contrário, nada se faz a respeito
                  
                    if (nome.isEmpty() == false) {
                        contas.get(indice).getTitular().setNome(nome);
                    }
                    if (Cpf.isEmpty() == false) {
                        contas.get(indice).getTitular().setCpf(Cpf);
                    }
                    if (Endereco.isEmpty() == false) {
                        contas.get(indice).getTitular().setEndereco(Endereco);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Nenhuma conta cadastrada no sistema");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Informe o número da conta a ser editada");
            }
        }
        if (src == getLimpar()) {
//------------------ Limpo os campos de digitação e salvo as informações no arquivo------------------
            txt_nome.setText("");
            txt_cpf.setText("");
            txt_end.setText("");
            txt_num.setText("");
             file=new Arquivo(cadastro.getContas());
            try {
                file.escreveArquivo();
            } catch (IOException ex) {
                Logger.getLogger(PainelCriarConta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
