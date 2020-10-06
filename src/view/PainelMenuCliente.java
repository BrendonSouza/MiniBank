package view;

import Mew_Bank.Conta;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.*;

/**
 *
 * @author brend
 */
public class PainelMenuCliente extends JPanel implements ActionListener {

    private JButton btn_Saldo;
    private JButton btn_Saque;
    private JButton btn_Tranferir;
    private JButton btn_Depositar;
    private JButton btn_voltar;

    
    private PainelSaldo Saldo;
    private PainelSaque Saque;
    private PainelDepositar Depositar;
    private PainelTransferir Transferir;
    private ArrayList<Conta> contas;
    public JButton getBtn_Transferir() {
        return btn_Tranferir;
    }
    
    public JButton getBtn_voltar() {
        return btn_voltar;
    }

    public JButton getBtn_Saldo() {
        return btn_Saldo;
    }
    

    public JButton getBtn_Saque() {
        return btn_Saque;
    }

    public JButton getBtn_Depositar() {
        return btn_Depositar;
    }

    public PainelMenuCliente(ArrayList<Conta> c) {
        contas= new ArrayList<>();
        contas=c;
        btn_Saldo = new JButton("Saldo");
        btn_Tranferir = new JButton("Transferir");
        btn_Saque = new JButton("Sacar");
        btn_Depositar = new JButton("Depositar");
        btn_voltar = new JButton("Voltar");
        Saldo = new PainelSaldo(contas);
        Depositar = new PainelDepositar(contas);
        Saque = new PainelSaque(contas);
        Transferir = new PainelTransferir(contas);
        LayoutManager lm2 = new GridLayout(5, 1);
        setLayout(lm2);
        //adição dos botçoes do menu do ckiente
        add(btn_Saldo);
        add(btn_Tranferir);
        add(btn_Saque);
        add(btn_Depositar);
        add(btn_voltar);
        getBtn_Saldo().addActionListener(this); // o actionLiestener é tratada no frm principal;
    }

    public JPanel actionSaldo() {
        return Saldo;

    }

    public JPanel actionSaque() {
        return Saque;

    }

    public JPanel actionDepositar() {
        return Depositar;

    }

    public JPanel actionTranferir() {
        return Transferir;

    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
    
          
      }
    }
   

