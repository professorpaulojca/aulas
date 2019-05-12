/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author paulojca
 */
public class Movimento {
    
    private int id;
    private Date data;
    private Time hora;
    private Tipo tipo;
    private String referencia;
    private Produto produto;
    private double quantidade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
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

    public Movimento() {
    }

    public Movimento(int id, Date data, Time hora, Tipo tipo, String referencia, Produto produto, double quantidade) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.tipo = tipo;
        this.referencia = referencia;
        this.produto = produto;
        this.quantidade = quantidade;
    }
    
    
    
}
