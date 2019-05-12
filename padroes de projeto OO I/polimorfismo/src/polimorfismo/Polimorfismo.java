/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polimorfismo;

import java.util.ArrayList;
import modelo.*;

/**
 *
 * @author paulojca
 */
public class Polimorfismo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        
        //criar os objetos 
        
        Funcionario func1 = new Gerente();
        func1.setSalario(10000);
        func1.setId(1);
        
        Funcionario func2 = new Supervisor();
        func2.setSalario(20000);
        func2.setId(2);
        
        
        Funcionario func3 = new Diretor();
        func3.setSalario(50000);
        func3.setId(3);
        
        Secretaria sec = new Secretaria();
        sec.setSalario(1000);
        sec.setId(4);
        
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        
        funcionarios.add(func1);
        funcionarios.add(func2);
        funcionarios.add(func3);
        funcionarios.add(sec);
        
        
        for (Funcionario func : funcionarios) {
            
            func.calcularBonificacao();
            System.out.println("Bonificação: " + func.getId() + " -> " + func.getBonificacao());
                       
        }
        
        
        
        
        
    }
    
}
