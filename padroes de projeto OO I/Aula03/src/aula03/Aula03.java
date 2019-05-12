/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula03;

import java.util.Date;
import modelos.CaixaEletronico;
import modelos.Deposito;
import modelos.Saque;
import modelos.Transacao;

/**
 *
 * @author wolley
 */
public class Aula03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Transacao saque = new Saque(new Date(), 150.0, "Saque");
        Transacao deposito = new Deposito(new Date(), 750.0, "Deposito");
        
        
        CaixaEletronico caixa = new CaixaEletronico();
        caixa.efetuarTransacao(deposito);
        caixa.efetuarTransacao(saque);
        
    }
    
}
