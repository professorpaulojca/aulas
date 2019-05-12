/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder01;

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
    
    private DadosFisicos    dadosFisicos    =  new DadosFisicos();
    private DadosPessoais   dadosPessoais   =  new DadosPessoais();
    private Documento       documento       =  new Documento();
    private Endereco        endereco        =  new Endereco();
    private Paciente        paciente        =  new Paciente();

    public void comNome(String nome){
        dadosPessoais.setNome(nome);
    }
    
    public void nascidoEm(String data){
        
        try {
            Date dataNasc = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            
            dadosPessoais.setDataNascimento(dataNasc);
        } catch (ParseException ex) {
            Logger.getLogger(PacienteBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doSexo(char sexo){
        dadosPessoais.setSexo(sexo);
    }
    
    public void comCPF(String cpf){
        documento.setCpf(cpf);
    }
    
    public Paciente constroi(){
        paciente.setDadosPessoais(dadosPessoais);
        paciente.setDocumento(documento);
        
        return paciente;
    }    
}
