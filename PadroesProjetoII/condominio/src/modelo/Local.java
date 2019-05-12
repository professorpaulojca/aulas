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
public class Local {
    
    private int id;
    private Tipolocal tipol;
    private String nome;
    private Local localpai;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tipolocal getTipol() {
        return tipol;
    }

    public void setTipol(Tipolocal tipol) {
        this.tipol = tipol;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Local getLocalpai() {
        return localpai;
    }

    public void setLocalpai(Local localpai) {
        this.localpai = localpai;
    }

    public Local() {
    }

    public Local(int id, Tipolocal tipol, String nome, Local localpai) {
        this.id = id;
        this.tipol = tipol;
        this.nome = nome;
        this.localpai = localpai;
    }
    
    
    
    
}
