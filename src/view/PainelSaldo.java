package view;

import Mew_Bank.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
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
public class PainelSaldo extends JPanel implements ActionListener {

    private JLabel num;
    private JTextField txt_num;
    private JButton confirmar;
    private JButton btn_cancela;
    private ArrayList<Conta> contas;
    private BuscaContaCliente bc;
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

    public PainelSaldo(ArrayList<Conta> c) {
        contas=new ArrayList<>();
        contas=c;
        bc= new BuscaContaCliente(contas);//classe auxiliar que procura a conta no array;
        num = new JLabel("Número da Conta");
        txt_num = new JTextField(35);
        confirmar = new JButton("Confirmar");
        btn_cancela = new JButton("Cancelar");
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 80));
        add(num);
        add(txt_num);
        add(confirmar);
       
        getConfirmar().addActionListener(this);//action do botão confirmar
        setSize(430, 400);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = new Object();
        src = e.getSource();
        if (src == getConfirmar()) {
            numConta = Integer.parseInt(txt_num.getText());
            int indice = bc.procuraConta(numConta);
            if(indice!=-1){
                JOptionPane.showMessageDialog(null,"Saldo: "+contas.get(indice).getSaldo());
            }
            //limpo os campos
            txt_num.setText("");
        }
    }

}
