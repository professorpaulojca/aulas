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
public class Endereco {
    
    private int id;
    private Tipoend tipoend;
    private String cep;
    private String numero;
    private String complemento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tipoend getTipoend() {
        return tipoend;
    }

    public void setTipoend(Tipoend tipoend) {
        this.tipoend = tipoend;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Endereco() {
    }

    public Endereco(int id, Tipoend tipoend, String cep, String numero, String complemento) {
        this.id = id;
        this.tipoend = tipoend;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
    }
    
    
    
    
}
