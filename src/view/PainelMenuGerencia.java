/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Mew_Bank.Cadastro;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.*;

/**
 *
 * @author brend
 */
public class PainelMenuGerencia extends JPanel {

    private JButton btn_criarConta;
    private JButton btn_editarConta;
    private JButton btn_excluirConta;
    private JButton btn_buscarConta;
    private JButton btn_voltar;
    private Cadastro cadastro;

    private PainelCriarConta CriarConta;
    private PainelExcluirConta ExcluirConta;
    private PainelBuscarConta BuscarConta;
    private PainelEditarConta EditarConta;

    public JButton getBtn_editarConta() {
        return btn_editarConta;
    }

    public JButton getBtn_voltar() {
        return btn_voltar;
    }

    public JButton getBtn_criarConta() {
        return btn_criarConta;
    }

    public JButton getBtn_buscarConta() {
        return btn_buscarConta;
    }

    public JButton getBtn_excluirConta() {
        return btn_excluirConta;
    }

    public PainelMenuGerencia() {
        cadastro = new Cadastro();
        btn_criarConta = new JButton("Criar Conta");
        btn_editarConta = new JButton("Editar Conta");
        btn_excluirConta = new JButton("Excluir Conta");
        btn_buscarConta = new JButton("Buscar Conta");
        btn_voltar = new JButton("Voltar");
        CriarConta = new PainelCriarConta(cadastro);
        BuscarConta = new PainelBuscarConta(cadastro);
        ExcluirConta = new PainelExcluirConta(cadastro);
        EditarConta = new PainelEditarConta(cadastro);

        LayoutManager lm2 = new GridLayout(5, 1);
        setLayout(lm2);
        //adição dos botoes
        add(btn_criarConta);
        add(btn_editarConta);
        add(btn_excluirConta);
        add(btn_buscarConta);
        add(btn_voltar);

    }
//todos os action serão tratados no frmPrincipal
    public JPanel actionCriarConta() {
        return CriarConta;

    }

    public JPanel actionBuscarConta() {
        return BuscarConta;

    }

    public JPanel actionExcluirConta() {
        return ExcluirConta;

    }

    public JPanel actionEditarConta() {
        return EditarConta;

    }
}
