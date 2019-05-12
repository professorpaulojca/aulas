/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padraodaoProduto;

import padraodaoProduto.*;
import dao.ProdutoDao;
import java.util.ArrayList;
import modelo.*;

/**
 *
 * @author profe
 */
public class ListarControle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<Produto> arr = new ArrayList<>();

        Produto produto = new Produto();

        produto.setNome("");

        ProdutoDao produtoDao = new ProdutoDao();

        arr = produtoDao.listar(produto);

        for (Produto obj : arr) {

            System.out.println("ID:" + obj.getId());
            System.out.println("Nome:" + obj.getNome());
            System.out.println("Descrição:" + obj.getDescricao());
            System.out.println("Preço:" + obj.getPreco());
            System.out.println("Estoque:" + obj.getQtd() + " peças");
            System.out.println("Tipo:" + obj.getTipo().getDescricao());
            System.out.println("Situação:" + obj.getSituacao().getDescricao());
        }

    }

}
