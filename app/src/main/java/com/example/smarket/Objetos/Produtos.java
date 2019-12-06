package com.example.smarket.Objetos;

import java.io.Serializable;

public class Produtos implements Serializable {

    int id;
    String nome;
    String categoria;
    Double preco;
    String marca;
    String dataValidade;
    private boolean checked = false;

    public Produtos(String nome, String categoria, Double preco, String marca, String dataValidade) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.marca = marca;
        this.dataValidade = dataValidade;
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

    public Double getPreco() {
        return preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "Produtos{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", marca='" + marca + '\'' +
                ", dataValidade='" + dataValidade + '\'' +
                '}';
    }
}
