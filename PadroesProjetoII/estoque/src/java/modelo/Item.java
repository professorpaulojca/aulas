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
public class Item {
    
    private int id;
    private Produto produto;
    private double quantidade;
    private double precounitario;
       

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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

    public Item(int id, Produto produto, double quantidade, double precounitario) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.precounitario = precounitario;
    }

    public Item() {
    }
    
    
    
}
