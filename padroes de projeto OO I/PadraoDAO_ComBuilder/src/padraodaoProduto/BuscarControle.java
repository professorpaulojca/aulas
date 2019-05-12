/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padraodaoProduto;

import padraodaoProduto.*;
import dao.ProdutoDao;
import modelo.Produto;

/**
 *
 * @author profe
 */
public class BuscarControle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Produto produto = new Produto();

        produto.setId(2);

        ProdutoDao produtodao = new ProdutoDao();

        produtodao.buscar(produto);

        System.out.println("ID:" + produto.getId());
        System.out.println("Nome:" + produto.getNome());
        System.out.println("Descrição:" + produto.getDescricao());
        System.out.println("Preço:" + produto.getPreco());
        System.out.println("Estoque:" + produto.getQtd() + " peças");
        System.out.println("Tipo:" + produto.getTipo().getDescricao());
        System.out.println("Situação:" + produto.getSituacao().getDescricao());
        

    }

}
