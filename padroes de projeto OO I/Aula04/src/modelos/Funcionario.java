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
public abstract class Funcionario extends Pessoa{
    
    private String registro;
    private double salario;

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    

    public Funcionario(String registro, String nome) {
        super(nome);
        this.registro = registro;
    }

    public Funcionario() {
    }
        
    public abstract void calcularSalario();
      
}
