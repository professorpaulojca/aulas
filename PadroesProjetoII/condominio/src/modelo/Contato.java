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
public class Contato {
    
    private int id;
    private Tipoc tipoc;
    private String valor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tipoc getTipoc() {
        return tipoc;
    }

    public void setTipoc(Tipoc tipoc) {
        this.tipoc = tipoc;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Contato() {
    }

    public Contato(int id, Tipoc tipoc, String valor) {
        this.id = id;
        this.tipoc = tipoc;
        this.valor = valor;
    }
    
    
    
}
