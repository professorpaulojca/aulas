/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author paulojca
 */
public class Produto {
    
    private int id;
    private String nome;
    private String descricao;
    private double quantidade;
    private double precounitario;
    private double qtdminima;
    private double qtdmaxima;
    private double qtdressuprimento;
    private String foto;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecounitario() {
        return precounitario;
    }

    public void setPrecounitario(double precounitario) {
        this.precounitario = precounitario;
    }

    public double getQtdminima() {
        return qtdminima;
    }

    public void setQtdminima(double qtdminima) {
        this.qtdminima = qtdminima;
    }

    public double getQtdmaxima() {
        return qtdmaxima;
    }

    public void setQtdmaxima(double qtdmaxima) {
        this.qtdmaxima = qtdmaxima;
    }

    public double getQtdressuprimento() {
        return qtdressuprimento;
    }

    public void setQtdressuprimento(double qtdressuprimento) {
        this.qtdressuprimento = qtdressuprimento;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Produto() {
    }

    public Produto(int id, String nome, String descricao, double quantidade, double precounitario, double qtdminima, double qtdmaxima, double qtdressuprimento, String foto) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.precounitario = precounitario;
        this.qtdminima = qtdminima;
        this.qtdmaxima = qtdmaxima;
        this.qtdressuprimento = qtdressuprimento;
        this.foto = foto;
    }

    public Produto(int id, String nome, String foto) {
        this.id = id;
        this.nome = nome;
        this.foto = foto;
    }

    public Produto(int id) {
        this.id = id;
    }
    
    
    
    
    
}
