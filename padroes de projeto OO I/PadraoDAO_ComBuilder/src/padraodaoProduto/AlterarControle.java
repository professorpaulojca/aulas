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
public class AlterarControle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Produto produto = new Produto();
        ProdutoDao produtodao = new ProdutoDao();
        
        produto.setId(3);
        produtodao.buscar(produto);
                        
        produto.setNome("Microfone Sony");
        produto.setTipo(new Tipo(2));
        
        produtodao.alterar(produto);
        
        ListarControle.main(args);
        
        
        
    }
    
}
