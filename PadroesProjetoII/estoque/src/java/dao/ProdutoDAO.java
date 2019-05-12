package dao;

import Util.ConectaBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Item;
import modelo.Pedido;
import modelo.Produto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author paulojca
 */
public class ProdutoDAO {
    
    

    private static final String SELECT_ALL = "select id,nome,foto from produto where id=?;";
    private static final String UPDATE = "UPDATE public.produto\n" +
"	SET  quantidade=quantidade - ?\n" +
"	WHERE id=?;";
    
    private Object pstm;

  
    public void buscar(Produto produto) throws SQLException, ClassNotFoundException {
        //cria uma array de obJ Item
        

        //Conexao
        Connection conexao = ConectaBanco.getConexao();
        //cria comando SQL
        PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);
        
        pstmt.setInt(1, produto.getId());
        
        //executa
        ResultSet rs = pstmt.executeQuery();

        //ler dados do pedido
                       
        rs.next();        
           
        produto.setId(rs.getInt("id"));
        produto.setNome(rs.getString("nome"));
        produto.setFoto(rs.getString("foto"));
        
        
    }
    
    public boolean baixa(Produto produto) throws SQLException {
        Connection conexao = null;

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(UPDATE);

            pstmt.setDouble(1, produto.getQuantidade());
            pstmt.setInt(2, produto.getId());
            
                      
            pstmt.execute();
            return true;

        } catch (Exception ex) {

            return false;

        } finally {

            conexao.close();
        }

    }
    
    
}
