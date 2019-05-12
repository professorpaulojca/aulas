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
public class Sexo {

    private int id;
    private String descricao;
    private String sigla;

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

    public Sexo(int id, String descricao, String sigla) {
        this.id = id;
        this.descricao = descricao;
        this.sigla = sigla;
    }

    public Sexo() {
    }

    public ArrayList<Sexo> listar() {

        ArrayList<Sexo> arrsexo = new ArrayList<Sexo>();

        arrsexo.add(new Sexo(1, "Feminino", "F"));
        arrsexo.add(new Sexo(2, "Masculino", "M"));
        arrsexo.add(new Sexo(3, "Não quero falar", "N"));

        return arrsexo;
    }

}
