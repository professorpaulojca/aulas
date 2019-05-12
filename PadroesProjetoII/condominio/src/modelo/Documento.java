/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author paulojca
 */
public class Documento {
    
    private int id;
    private Tipodoc tipodoc;
    private Date dataemissao;
    private Date datavalidade;
    private String numero;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tipodoc getTipodoc() {
        return tipodoc;
    }

    public void setTipodoc(Tipodoc tipodoc) {
        this.tipodoc = tipodoc;
    }

    public Date getDataemissao() {
        return dataemissao;
    }

    public void setDataemissao(Date dataemissao) {
        this.dataemissao = dataemissao;
    }

    public Date getDatavalidade() {
        return datavalidade;
    }

    public void setDatavalidade(Date datavalidade) {
        this.datavalidade = datavalidade;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Documento() {
    }

    public Documento(int id, Tipodoc tipodoc, Date dataemissao, Date datavalidade, String numero) {
        this.id = id;
        this.tipodoc = tipodoc;
        this.dataemissao = dataemissao;
        this.datavalidade = datavalidade;
        this.numero = numero;
    }
    
    
    
    
    
}
