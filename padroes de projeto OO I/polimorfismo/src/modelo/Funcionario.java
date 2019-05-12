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
public abstract class Funcionario {
    
    private int id;  
    private double salario;
    private double bonificacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getBonificacao() {
        return bonificacao;
    }

    public void setBonificacao(double bonificacao) {
        this.bonificacao = bonificacao;
    }

    public Funcionario(int id, double salario, double bonificacao) {
        this.id = id;
        this.salario = salario;
        this.bonificacao = bonificacao;
    }

    public Funcionario() {
    }
   
    
    public abstract void calcularBonificacao();
  
    
    
}
