/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author brend
 */
public class Login extends JFrame implements ActionListener {
 ImageIcon nome= new ImageIcon(getClass().getResource("java.jfif"));
 JLabel label= new JLabel(nome);
    public JButton ok;
    public JButton cancelar;
    public JLabel usuario;
    public JLabel Senha;
    public JTextField txt_user;
    public JTextField txt_pas;
        public JButton getOk() {
        return ok;
    }

    public JButton getCancelar() {
        return cancelar;
    }

    public JTextField getTxt_user() {
        return txt_user;
    }

    public JTextField getTxt_pas() {
        return txt_pas;
    }

   


    public Login() {
        ok = new JButton("Confirmaar");
        cancelar = new JButton("Cancelar");
        usuario = new JLabel("Usuário");
        Senha = new JLabel("Senha");
        txt_user = new JTextField(20);
        txt_pas = new JTextField(20);

        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
        add(usuario);
        add(txt_user);
        add(Senha);
        add(txt_pas);
        add(ok);
        add(cancelar);
        
        add(label);
        setSize(430, 400);
        setLocationRelativeTo(this);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getOk().addActionListener(this);
    }
 public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src= new Object();
                src=e.getSource();
        if(src==getOk()){
            if(txt_pas.getText().equals("1234")&& txt_user.getText().equals("brendon")){
                JOptionPane.showMessageDialog(null,"logi efetuado com sucesso");
                
               
                
            }
    }
    }

}
