/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Mew_Bank.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author vrevy
 */
public class PainelSaque extends JPanel implements ActionListener {

    private JLabel num;
    private JTextField txt_num;
    private JLabel valor;
    private JTextField txt_valor;
    private JButton confirmar;
    private JButton btn_cancela;
    private ArrayList<Conta> contas;
    private int numConta;
    private BuscaContaCliente bc;
    private Arquivo file;

    public JButton getConfirmar() {
        return confirmar;
    }

    public JTextField getTxt_num() {
        return txt_num;
    }

    public JLabel getValor() {
        return valor;
    }

    public JTextField getTxt_valor() {
        return txt_valor;
    }

    public JButton getBtn_cancela() {
        return btn_cancela;
    }

    public PainelSaque(ArrayList<Conta> c) {
        contas = new ArrayList<>();
        contas = c;
        bc = new BuscaContaCliente(contas); // classe auxiliar para busca de contas
        num = new JLabel("Número da Conta");
        txt_num = new JTextField(35);
        valor = new JLabel("Valor que deseja Sacar");
        txt_valor = new JTextField(35);
        confirmar = new JButton("Confirmar");
        btn_cancela = new JButton("Limpar");
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 50));
        add(num);
        add(txt_num);
        add(valor);
        add(txt_valor);
        add(confirmar);
        add(btn_cancela);
        getConfirmar().addActionListener(this);
        getBtn_cancela().addActionListener(this);
        setSize(430, 400);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = new Object();
        src = e.getSource();
        if (src == getConfirmar()) {
            int valor = Integer.parseInt(txt_valor.getText());
            numConta = Integer.parseInt(txt_num.getText());
            int indice = bc.procuraConta(numConta);
            if (indice != -1) {
                contas.get(indice).saca(valor);
                JOptionPane.showMessageDialog(null, "Saque efetuado com sucesso!\n" + "Novo Saldo:  " + contas.get(indice).getSaldo());
                file = new Arquivo(contas); // salva as mudanças no arquivo
                try {
                    file.escreveArquivo();
                } catch (IOException ex) {
                    Logger.getLogger(PainelCriarConta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        if(src==getBtn_cancela()){
            //limpa os campos
            txt_num.setText("");
            txt_valor.setText("");
        }
    }

}
