/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.util.ArrayList;
import modelos.Bonificavel;
import modelos.Diretor;
import modelos.Gerente;
import modelos.Terceirizado;

/**
 *
 * @author wolley
 */
public class Principal {
    
    
    
    
    // psvm + tab
    
    public static void main(String[] args) {
        
        ArrayList<Bonificavel> listaFuncionarios = new ArrayList<>();
        
        
        Diretor diretor = new Diretor("123", "Maria");
        diretor.setSalario(1500.0);
        
        Gerente gerente = new Gerente("456", "Pedro");
        gerente.setSalario(1000.0);

        
        listaFuncionarios.add(diretor);
        listaFuncionarios.add(gerente);
     
        
        for (Bonificavel funcionario : listaFuncionarios) {
            
            System.out.println("Bonificação: "+ funcionario.bonificar());
        }
        
        
        
        
        
        
    }
}
