package android.curso.com.br.meusclientes.model;

import java.io.Serializable;

/**
 * Created by root on 23/05/15.
 */
public class Produto implements Serializable {

    private String nome;
    private float valor;

    public Produto() {
    }

    public Produto(String nome, float valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}

