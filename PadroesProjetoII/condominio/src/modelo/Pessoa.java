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
public class Pessoa {
    
    private int id;
    private ArrayList<Documento> documentos;
    private ArrayList<Contato> contatos;
    private ArrayList<Endereco> enderecos;
    private Date datanasc;
    private Genero genero;
    private ArrayList<Localres> locaisres;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(ArrayList<Documento> documentos) {
        this.documentos = documentos;
    }

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(ArrayList<Contato> contatos) {
        this.contatos = contatos;
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Date getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(Date datanasc) {
        this.datanasc = datanasc;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public ArrayList<Localres> getLocaisres() {
        return locaisres;
    }

    public void setLocaisres(ArrayList<Localres> locaisres) {
        this.locaisres = locaisres;
    }

    public Pessoa(int id, ArrayList<Documento> documentos, ArrayList<Contato> contatos, ArrayList<Endereco> enderecos, Date datanasc, Genero genero, ArrayList<Localres> locaisres) {
        this.id = id;
        this.documentos = documentos;
        this.contatos = contatos;
        this.enderecos = enderecos;
        this.datanasc = datanasc;
        this.genero = genero;
        this.locaisres = locaisres;
    }

    public Pessoa() {
    }
    
    
    
}
