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
public class PainelDepositar extends JPanel implements ActionListener {

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

    public JTextField getTxt_num() {
        return txt_num;
    }

    public JTextField getTxt_valor() {
        return txt_valor;
    }

    public JButton getConfirmar() {
        return confirmar;
    }

    public JButton getBtn_cancela() {
        return btn_cancela;
    }

    public PainelDepositar(ArrayList<Conta> c) { //construtor que recebe o arrayList de contas
        contas = new ArrayList<>();
        contas = c;
        bc = new BuscaContaCliente(contas); //Instancia da classe BuscaContaCliente. Classe feita para auxiliar a busca de contas na janela do cliente

        num = new JLabel("Número da Conta");
        txt_num = new JTextField(35);
        valor = new JLabel("Valor que deseja Depositar");
        txt_valor = new JTextField(35);
        confirmar = new JButton("Confirmar");
        btn_cancela = new JButton("Cancelar");
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 50)); //aqui definimos o espaçamento entre os itens do painel
        add(num);
        add(txt_num);
        add(valor);
        add(txt_valor);
        add(confirmar);
        add(btn_cancela);
        getConfirmar().addActionListener(this);// adicionando o ActionListener do Botão Confirmar

        setSize(430, 400);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object src = new Object();
        src = e.getSource();
        if (src == getConfirmar()) {

            Double valor = Double.parseDouble(txt_valor.getText());
            numConta = Integer.parseInt(txt_num.getText());
            int indice = bc.procuraConta(numConta); //indice -1 é o retorno padrão de "Conta não encintrada"
            if (indice != -1) {
                contas.get(indice).deposita(valor);
                JOptionPane.showMessageDialog(null, "Deposito Efetuado Com sucesso");
                file = new Arquivo(contas);
                try {
                    file.escreveArquivo();
                } catch (IOException ex) {// trata a exceção do arquivo estar indisponivel
                    Logger.getLogger(PainelCriarConta.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Arquivo não disponível");
                }
            }

        }
    }

}
