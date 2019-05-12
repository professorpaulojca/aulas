/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builderProduto;

import padraodaoProduto.ListarControle;

/**
 *
 * @author alunocmc
 */
public class produtoTeste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        builderProduto.novoBuilderProduto().comNome("Celular LG")
                                           .comDescricao("Celular Smartphone LG 32GB")
                                           .comPreco(4000.50)
                                           .comQuantidade(50)
                                           .comTipo(2)
                                           .comSituacao(1)
                                           .constroi()
                                           .inserir();
                                           
        ListarControle.main(args);
        
    }
    
}
