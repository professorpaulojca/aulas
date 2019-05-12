/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padraodaoProduto;

import padraodaoProduto.*;
import modelo.*;
import dao.*;
/**
 *
 * @author profe
 */
public class ExcluirControle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Produto produto = new Produto();
        produto.setId(3);
        
        ProdutoDao produtodao = new ProdutoDao();
        produtodao.excluir(produto);
        
        ListarControle.main(args);
                      
       
    }
    
}
