/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder01;

import modelo.Paciente;

/**
 *
 * @author wolley
 */
public class App {
    
    
    public static void main(String[] args) {
        
        
        PacienteBuilder builder = new PacienteBuilder();
        
        builder.comNome("Jose da Silva");
        builder.comCPF("333.333.333-33");
        builder.nascidoEm("12/02/1970");
        
        Paciente paciente = builder.constroi();
               
        
        System.out.println(paciente);
        
        
    }
}
