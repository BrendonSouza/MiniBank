/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Mew_Bank.Arquivo;
import Mew_Bank.Cadastro;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author brend
 */
public class PainelExcluirConta extends JPanel implements ActionListener {

    private JLabel num;
    private JTextField txt_num;
    private JButton confirmar;
    private JButton btn_cancela;
    private Cadastro cadastro;
    private Arquivo file;
    private int numConta;

    public JTextField getTxt_num() {
        return txt_num;
    }

    public JButton getConfirmar() {
        return confirmar;
    }

    public JButton getBtn_cancela() {
        return btn_cancela;
    }

    public PainelExcluirConta(Cadastro c) {
        cadastro = c;
        num = new JLabel("Número da Conta que Deseja Excluir");
        txt_num = new JTextField(35);
        confirmar = new JButton("Confirmar");
        btn_cancela = new JButton("Cancelar");
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 80));
        add(num);
        add(txt_num);
        add(confirmar);
        
        getConfirmar().addActionListener(this);

        setSize(430, 400);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = new Object();
        src = e.getSource();
        if (src == getConfirmar()) {
            if (txt_num.getText().isEmpty() == false) {
                numConta = Integer.parseInt(txt_num.getText());
                if (cadastro.removeConta(numConta)) { //removeConta retorna true ou false
                    JOptionPane.showMessageDialog(null, "Conta deletada com sucesso!!!");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro, conta não encontrada");
                }
                //salvamos as alterações no arquivo
                file = new Arquivo(cadastro.getContas());
                try {
                    file.escreveArquivo();
                } catch (IOException ex) {
                    Logger.getLogger(PainelCriarConta.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, informe o nome da conta a ser excluída");
            }

        }
      
    }

}
