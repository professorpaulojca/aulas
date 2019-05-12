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
public class Supervisor extends Funcionario{
    
    @Override
    public void calcularBonificacao() {
        
         this.setBonificacao(this.getSalario() * 0.1);
        
    }
    
}
