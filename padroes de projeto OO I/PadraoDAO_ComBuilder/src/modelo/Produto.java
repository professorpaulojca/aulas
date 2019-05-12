/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author alunocmc
 */
public class Produto extends Objeto{
    
    private String nome;
    private String descricao;
    private double preco;
    private int qtd;
    private Tipo tipo;
    private Situacao situacao;

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Produto(int id) {
        super(id);
    }

    public Produto(String nome, String descricao, double preco, int qtd, Tipo tipo, Situacao situacao, int id) {
        super(id);
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.qtd = qtd;
        this.tipo = tipo;
        this.situacao = situacao;
    }

    public Produto(String nome, String descricao, double preco, int qtd, Tipo tipo, Situacao situacao) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.qtd = qtd;
        this.tipo = tipo;
        this.situacao = situacao;
    }

    public Produto() {
    }

    
    
}
