/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author alunocmc
 */
public class Debito extends Formapag implements Calcular_ad {

    @Override
    public void calcularacrescimooudebito() {
         this.setValorcorrigido(this.getValor() - (this.getValor() * 0.05));
    }
       
    
}