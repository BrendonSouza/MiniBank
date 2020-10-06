/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author brend
 */
public class PainelMenu extends JPanel {
    
    private JButton btn_gerencia;
    private JButton btn_cliente;

    public PainelMenu(){
       
    btn_gerencia = new JButton("Gerencia");
    btn_cliente = new JButton("Cliente"); 
    //Utilizamos o GridLayout
    LayoutManager lm2 = new GridLayout(2, 1);
    setLayout(lm2);
    add(btn_gerencia);//adição de botões do menu principal
    add(btn_cliente);
    
 
    
    }

    public JButton getBtn_gerencia() {
        return btn_gerencia;
    }

    public JButton getBtn_cliente() {
        return btn_cliente;
    }

   


    
}

