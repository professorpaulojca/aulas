/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author paulojca
 */
public class Pedido {
    
    private int id;
    private Date data;
    private Date hora;
    private ArrayList<Item> itens;
    private ArrayList<Historico> historico;

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

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

    public ArrayList<Historico> getHistorico() {
        return historico;
    }

    public void setHistorico(ArrayList<Historico> historico) {
        this.historico = historico;
    }

    public Pedido(int id, Date data, Date hora, ArrayList<Item> itens, ArrayList<Historico> historico) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.itens = itens;
        this.historico = historico;
    }

    public Pedido() {
    }
    
    
    
}
