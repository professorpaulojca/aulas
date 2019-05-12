/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author wolley
 */
public class Ajudante extends Funcionario implements Bonificavel{
    
     @Override
    public void calcularSalario() {
        
        this.setSalario(1000.00);
        
    }

    @Override
    public double bonificar() {
       
        
        return this.getSalario() + 100.0;
    }
    
    
    
    

    public Ajudante(String registro, String nome) {
        super(registro, nome);
    }
    
}
