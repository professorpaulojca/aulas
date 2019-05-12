/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author profe
 */
public class Estagio {
    
    private String local;
    private String cargo;

  
    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Estagio(String local, String cargo) {
        this.local = local;
        this.cargo = cargo;
    }

    public Estagio() {
    }
    
}


