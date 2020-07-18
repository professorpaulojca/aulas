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
public class Tipo extends Objeto{
    
    private String descricao;
    private int idDepartamento; //como estamos usando banco de dados relacinal, precisamos do id do departamento (pois é a chave estrangeira)

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Tipo(String descricao, int id) {
        super(id);
        this.descricao = descricao;
    }

    public Tipo() {
    }

    public Tipo(String descricao) {
        this.descricao = descricao;
    }
    
}
