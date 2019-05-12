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
public class Diretor extends Funcionario implements Bonificavel{
    
    @Override
    public void calcularSalario() {
        
        this.setSalario(3000.00);
        
    }

    @Override
    public double bonificar() {
       
        
        return this.getSalario() + 250.0;
    }

    
    

    public Diretor(String registro, String nome) {
        super(registro, nome);
    }
    
    
    
}
