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
public class Historico {
    
    private int id;
    private Pedido pedido;
    private Date data;
    private Time hora;
    private Situacao situacao;
    private String observacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
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

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Historico() {
    }

    public Historico(int id, Pedido pedido, Date data, Time hora, Situacao situacao, String observacao) {
        this.id = id;
        this.pedido = pedido;
        this.data = data;
        this.hora = hora;
        this.situacao = situacao;
        this.observacao = observacao;
    }
    
    
    
    
}
