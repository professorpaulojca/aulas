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
public class adptEstagio extends Estagio implements IDados{

    @Override
    public String getDados() {
        return this.getCargo();
    }

    public adptEstagio(String local, String cargo) {
        super(local, cargo);
    }
    
}
