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
public class Localres {
    
    
    private int id;
    private Local local;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Localres() {
    }

    public Localres(int id, Local local) {
        this.id = id;
        this.local = local;
    }
    
    
    
}
