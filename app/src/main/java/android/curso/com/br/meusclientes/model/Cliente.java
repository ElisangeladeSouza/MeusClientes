package android.curso.com.br.meusclientes.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by root on 19/05/15.
 */
public class Cliente implements Serializable {

    private int id;
    private String nome;
    private boolean clienteAtivo;
    private ArrayList<Produto> produtos;

    public Cliente() {
    }

    public Cliente(int id, String nome, boolean clienteAtivo) {
        this.id = id;
        this.nome = nome;
        this.clienteAtivo = clienteAtivo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isClienteAtivo() {
        return clienteAtivo;
    }

    public void setClienteAtivo(boolean clienteAtivo) {
        this.clienteAtivo = clienteAtivo;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
}
