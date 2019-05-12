/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padraodao;

import modelo.*;
import dao.*;
/**
 *
 * @author profe
 */
public class AlterarControle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Tipo tipo = new Tipo();
        
        tipo.setId(4);
        tipo.setDescricao("Bacana");
        
        TipoDao tipodao = new TipoDao();
        
        tipodao.alterar(tipo);
        
        ListarControle.main(args);
        
        
        
    }
    
}
