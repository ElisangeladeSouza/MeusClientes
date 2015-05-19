package android.curso.com.br.meusclientes.model;

import java.io.Serializable;

/**
 * Created by root on 19/05/15.
 */
public class Cliente implements Serializable {

    private String nome;
    private String produto;
    private float valor;

    public Cliente() {
    }

    public Cliente(String nome, String produto, float valor) {
        this.nome = nome;
        this.produto = produto;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
