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
public abstract class Formapag{
    
    private double valor;
    private double valorcorrigido;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValorcorrigido() {
        return valorcorrigido;
    }

    public void setValorcorrigido(double valorcorrigido) {
        this.valorcorrigido = valorcorrigido;
    }
       
}
