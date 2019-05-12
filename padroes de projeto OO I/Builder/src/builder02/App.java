/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder02;

import modelo.Paciente;

/**
 *
 * @author wolley
 */
public class App {
    
    
    
    public static void main(String[] args) {
        
        
        
       Paciente paciente=  PacienteBuilder.novoPacienteBuilder()
                                        .comNome("Jose da Silva")
                                        .comCPF("333.333.333-33")
                                        .nascidoEm("12/02/1970")
                                        .constroi();
               
        
        System.out.println(paciente);
        
        
    }
    
}
