/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padraodao;

import dao.TipoDao;
import modelo.*;

/**
 *
 * @author profe
 */
public class CadastrarControle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        Tipo tipo = new Tipo();
        
        tipo.setDescricao("Bom");
        
        TipoDao tipodao = new TipoDao();
        
        tipodao.cadastrar(tipo);
               
        ListarControle.main(args);
        
    }
    
}
