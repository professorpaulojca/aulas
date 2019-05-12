/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builderProduto;

import dao.ProdutoDao;
import modelo.Produto;
import modelo.Situacao;
import modelo.Tipo;

/**
 *
 * @author alunocmc
 */
public class builderProduto {
    
    private Tipo tipo = new Tipo();
    private Situacao situacao = new Situacao();
    private Produto produto = new Produto();
    private ProdutoDao produtodao = new ProdutoDao();
    
    public static builderProduto novoBuilderProduto(){
        
        return new builderProduto();
        
    }
    
    public builderProduto comTipo(int idTipo){
        
        tipo.setId(idTipo);
        
        return this;
        
    }
    
    public builderProduto comSituacao(int idSituacao){
        
        situacao.setId(idSituacao);
        
        return this;
    }
    
    public builderProduto comNome(String nome){
        
        produto.setNome(nome);
        
        return this;
    }
    
    public builderProduto comDescricao(String descricao){
        
        produto.setDescricao(descricao);
        
        return this;
    }
    
    public builderProduto comQuantidade(int quantidade){
        
        produto.setQtd(quantidade);
        
        return this;
    }
    
    public builderProduto comPreco(double preco){
        
        produto.setPreco(preco);
        
        return this;
    }
    
    public builderProduto constroi(){
        
        produto.setTipo(tipo);
        produto.setSituacao(situacao);
        return this;
    }
    
    public void  inserir() {
        
        produtodao.cadastrar(produto);
        
    }
}
