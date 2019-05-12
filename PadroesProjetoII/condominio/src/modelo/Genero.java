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
public class Genero {
    
    private int id;
    private TGenero genero;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TGenero getGenero() {
        return genero;
    }

    public void setGenero(TGenero genero) {
        this.genero = genero;
    }

    public Genero() {
    }

    public Genero(int id, TGenero genero) {
        this.id = id;
        this.genero = genero;
    }
    
    
    
}
