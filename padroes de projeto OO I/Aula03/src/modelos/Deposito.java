/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.Date;

/**
 *
 * @author wolley
 */
public class Deposito extends Transacao{

    public Deposito(Date data, double valor, String descricao) {
        super(data, valor, descricao);
    }

    @Override
    public void executar() {
        System.out.println("Descrição: "+ this.getDescricao());
        System.out.println("Valor: " + this.getValor());
        System.out.println("Data: "+ this.getData());
    }
    
}
