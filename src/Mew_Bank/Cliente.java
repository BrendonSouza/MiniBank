package Mew_Bank;

import java.io.Serializable;

public class Cliente implements Serializable { //essa classe "Assina o contrato" da Serialização. Ou seja, ´podemos gravá-la em um arquivo =

    private String nome;//Atributos do cliente
    private String cpf;
    private String endereco;

    //getters e Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
