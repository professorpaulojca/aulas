/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sembuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.DadosFisicos;
import modelo.DadosPessoais;
import modelo.Documento;
import modelo.Endereco;
import modelo.Paciente;

/**
 *
 * @author wolley
 */
public class App {
    
    
    //psvm + tab
    
    public static void main(String[] args) throws ParseException {
        
        
        Date dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse("10/02/1970");
        
        DadosPessoais dadosPessoais = new DadosPessoais("Joao da Silva", dataNascimento, 'M');        
        
        DadosFisicos dadosFisicos = new DadosFisicos("O+", 75.0, 1.80);
        
        Documento documento = new Documento("333.333.333-33", "11.111.111-11");
        
        Endereco endereco = new Endereco("0862-789", "Rua UMC", 45, "Mogi das Cruzes", "SP");
        
        Paciente paciente = new Paciente(123456, dadosPessoais, dadosFisicos, documento, endereco, true);
        
        System.out.println(paciente);
        
        
    }
    
}
