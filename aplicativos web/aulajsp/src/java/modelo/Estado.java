/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author alunocmc
 */
public class Estado {
    
    private int id;
    private String descricao;
    private String sigla;
    private ArrayList<Cidade> arracidades;

    public ArrayList<Cidade> getArracidades() {
        return arracidades;
    }

    public void setArracidades(ArrayList<Cidade> arracidades) {
        this.arracidades = arracidades;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Estado() {
    }

    public Estado(int id, String descricao, String sigla) {
        this.id = id;
        this.descricao = descricao;
        this.sigla = sigla;
    }
    
    
    public ArrayList<Estado> listar(){
        
        ArrayList<Estado> arrestado = new ArrayList<Estado>();
        
        arrestado.add(new Estado(1,"São Paulo", "SP"));
        arrestado.add(new Estado(2,"Minas Gerais", "MG"));
        
        return arrestado;        
        
    }

    public void listarCidades() {
   
        Cidade objcidade = new Cidade();
        this.arracidades = objcidade.listar(id);
            
    }
    
}
