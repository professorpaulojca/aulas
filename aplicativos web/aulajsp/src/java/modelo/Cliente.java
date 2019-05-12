/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author alunocmc
 */
public class Cliente {
    
    private int id;
    private String nome;
    private Cidade cidade;
    private Sexo sexo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Cliente(String nome, Cidade cidade) {
        this.nome = nome;
        this.cidade = cidade;
    }

    public Cliente(String nome, Cidade cidade, Sexo sexo) {
        this.nome = nome;
        this.cidade = cidade;
        this.sexo = sexo;
    }

    public Cliente(int id, String nome, Cidade cidade, Sexo sexo) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.sexo = sexo;
    }
    

    public Cliente() {
    }
            
}
