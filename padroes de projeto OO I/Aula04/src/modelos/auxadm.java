/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author alunocmc
 */
public class auxadm extends Funcionario implements Bonificavel{

    @Override
    public void calcularSalario() {
 
        this.setSalario(1200);
    }

    @Override
    public double bonificar() {

          return this.getSalario() + 50.0;
    }
    
}
