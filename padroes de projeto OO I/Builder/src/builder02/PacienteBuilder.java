/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.DadosFisicos;
import modelo.DadosPessoais;
import modelo.Documento;
import modelo.Endereco;
import modelo.Paciente;

/**
 *
 * @author wolley
 */
public class PacienteBuilder {
    
    private DadosFisicos dadosFisicos = new DadosFisicos();
    private DadosPessoais dadosPessoais = new DadosPessoais();
    private Documento documento = new Documento();
    private Endereco endereco = new Endereco();
    private Paciente paciente =new Paciente();

    private PacienteBuilder(){
        
    }
    
    public static PacienteBuilder novoPacienteBuilder(){
        return new PacienteBuilder();
    }
    
    public PacienteBuilder comNome(String nome){
        dadosPessoais.setNome(nome);
        
        return this;
    }
    
    public PacienteBuilder nascidoEm(String data){
        
        try {
            Date dataNasc = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            
            dadosPessoais.setDataNascimento(dataNasc);
        } catch (ParseException ex) {
            Logger.getLogger(builder01.PacienteBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return this;
    }
    
    public PacienteBuilder doSexo(char sexo){
        dadosPessoais.setSexo(sexo);
        return this;
    }
    
    public PacienteBuilder comCPF(String cpf){
        documento.setCpf(cpf);
        return this;
    }
    
    public Paciente constroi(){
        paciente.setDadosPessoais(dadosPessoais);
        paciente.setDocumento(documento);
        return paciente;
    }
    
    
    
}
