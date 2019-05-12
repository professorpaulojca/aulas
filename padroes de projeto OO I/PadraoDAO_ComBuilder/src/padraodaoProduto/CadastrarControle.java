/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padraodaoProduto;

import dao.ProdutoDao;
import padraodaoTipo.*;
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
      
        Produto produto = new Produto("Microfone", "Microfone com fio", 22.5, 100, new Tipo(1), new Situacao(1));
        
        ProdutoDao produtodao = new ProdutoDao();
        
        produtodao.cadastrar(produto);
               
        ListarControle.main(args);
        
    }
    
}
