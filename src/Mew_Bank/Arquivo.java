/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mew_Bank;

/**
 *
 * @author brend
 */
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author brend
 */
public class Arquivo implements Serializable { // Em java, Serializable é uma interface sem métodos. Funciona como uma anotação.

    private ArrayList<Conta> contas;

    public Arquivo(ArrayList<Conta> c) {
        contas = new ArrayList<>();
        contas = c;
    }

    public void escreveArquivo() throws IOException {
        try ( FileOutputStream arquivoGrav = new FileOutputStream("Dados.dat") //Aqui instanciamos o arquivo de gravação
                ) {
            try ( ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav) // instanciamos o objeto de gravação e encapsulamos o FOS
                    ) {
                objGravar.writeObject(contas);
                objGravar.flush(); //limpamos o buffer
            }
            arquivoGrav.flush();
        } // instanciamos o objeto de gravação e encapsulamos o FOS // instanciamos o objeto de gravação e encapsulamos o FOS
        System.out.println("Arquivo gravado sucesso!!");
    }

    public ArrayList lerArquivo() throws IOException, ClassNotFoundException {

        FileInputStream arquivoLeitura = new FileInputStream("Dados.dat");
        ObjectInputStream objLeitura = new ObjectInputStream(arquivoLeitura);
        contas = (ArrayList<Conta>) objLeitura.readObject(); //Cast, pois a função de leitura retorna um objeto
        objLeitura.close();
        arquivoLeitura.close();
        return contas;
    }

    public boolean podeLer() {
        return new File("Dados.dat").canRead();
    } //método auxiliar para sabermos se o arquivo existe ou não
}
