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
public class Cidade {

    private int id;
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cidade(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Cidade() {
    }

    public ArrayList<Cidade> listar(int idestado) {

        ArrayList<Cidade> arrcidade = new ArrayList<Cidade>();

        if (idestado == 1) {
            arrcidade.add(new Cidade(1, "Mogi das Cruzes"));
            arrcidade.add(new Cidade(2, "Suzano"));
            arrcidade.add(new Cidade(3, "Poá"));
        } else {
            arrcidade.add(new Cidade(1, "Belo Horizonte"));
            arrcidade.add(new Cidade(2, "Itajubá"));
            arrcidade.add(new Cidade(3, "Piraporinha"));
        }

        return arrcidade;
    }

}
