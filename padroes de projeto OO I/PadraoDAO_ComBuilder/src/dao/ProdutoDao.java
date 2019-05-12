/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Util.ConectaBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Produto;
import modelo.Situacao;
import modelo.Tipo;

/**
 *
 * @author alunocmc
 */
public class ProdutoDao implements IProdutodao {
    
    private static final String SELECT_ALL = "SELECT * FROM produtos where nome ilike ?;";
    private static final String INSERT = "INSERT INTO produtos (nome, descricao, qtd, preco, tipo,situacao) VALUES ( ?, ?, ?, ?, ?,?);";
    private static final String DELETE = "DELETE FROM produtos where id=?";
    private static final String BUSCAR = "SELECT * FROM produtos WHERE id=?;";
    private static final String UPDATE = "UPDATE produtos SET nome=?, descricao=?, qtd=?, preco=?, tipo=?, situacao=? WHERE id=?;";
    
    private Object pstmt;
    private Connection conexao;
    
    @Override
    public ArrayList<Produto> listar(Produto produto) {

        //cria uma array de obJ Tipo
        ArrayList<Produto> listaProduto = new ArrayList<Produto>();
        
        try {

            //Conexao
            conexao = ConectaBanco.getConexao();
            //cria comando SQL
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);
            
            pstmt.setString(1, "%" + produto.getNome() + "%");

            //executa
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                //a cada loop
                Produto novoProduto = new Produto();
                
                novoProduto.setId(rs.getInt("id"));
                novoProduto.setNome(rs.getString("nome"));
                novoProduto.setDescricao(rs.getString("descricao"));
                novoProduto.setPreco(rs.getDouble("preco"));
                novoProduto.setQtd(rs.getInt("qtd"));

                //busca o tipo
                Tipo tipo = new Tipo(rs.getInt("tipo"));
                TipoDao tipodao = new TipoDao();
                tipodao.buscar(tipo);
                
                novoProduto.setTipo(tipo);

                //busca a situacao
                Situacao situacao = new Situacao(rs.getInt("situacao"));
                SituacaoDao situacaodao = new SituacaoDao();
                situacaodao.buscar(situacao);
                
                novoProduto.setSituacao(situacao);
                //add na lista
                listaProduto.add(novoProduto);
            }
            return listaProduto;
            
        } catch (Exception ex) {
            
            return listaProduto;
            
        } finally {
            
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(TipoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
    @Override
    public void buscar(Produto produto) {
        
        try {
            //Conexao
            conexao = ConectaBanco.getConexao();
            //cria comando SQL
            PreparedStatement pstmt = conexao.prepareStatement(BUSCAR);
            
            pstmt.setInt(1, produto.getId());
            //executa
            ResultSet rs = pstmt.executeQuery();

            // como a query ira retornar somente um registro, faremos o NEXT
            rs.next();
            
            produto.setId(rs.getInt("id"));
            produto.setNome(rs.getString("nome"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setPreco(rs.getDouble("preco"));
            produto.setQtd(rs.getInt("qtd"));

            //busca o tipo
            Tipo tipo = new Tipo(rs.getInt("tipo"));
            TipoDao tipodao = new TipoDao();
            tipodao.buscar(tipo);

            //busca a situacao
            Situacao situacao = new Situacao(rs.getInt("situacao"));
            SituacaoDao situacaodao = new SituacaoDao();
            situacaodao.buscar(situacao);
            
            produto.setTipo(tipo);
            produto.setSituacao(situacao);
            
        } catch (Exception e) {

            //
        } finally {
            
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(TipoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    @Override
    public boolean alterar(Produto produto) {
        
        try {
            
            conexao = ConectaBanco.getConexao();
            
            PreparedStatement pstmt = conexao.prepareStatement(UPDATE);
            
            pstmt.setString(1, produto.getNome());
            pstmt.setString(2, produto.getDescricao());
            pstmt.setDouble(3, produto.getPreco());
            pstmt.setInt(4, produto.getQtd());
            pstmt.setInt(5, produto.getTipo().getId());
            pstmt.setInt(6, produto.getSituacao().getId());
            pstmt.setInt(7, produto.getId());
            
            pstmt.execute();
            return true;
            
        } catch (Exception ex) {
            
            return false;
            
        } finally {
            
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(TipoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    @Override
    public boolean excluir(Produto produto) {
        
        try {
            
            conexao = ConectaBanco.getConexao();
            
            PreparedStatement pstmt = conexao.prepareStatement(DELETE);
            
            pstmt.setInt(1, produto.getId());
            
            pstmt.execute();
            
            return true;
            
        } catch (Exception ex) {
            
            return false;
            
        } finally {
            
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(TipoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    @Override
    public boolean cadastrar(Produto produto) {
        
        try {
            
            conexao = ConectaBanco.getConexao();
            
            PreparedStatement pstmt = conexao.prepareStatement(INSERT);
            
            pstmt.setString(1, produto.getNome());
            pstmt.setString(2, produto.getDescricao());
            pstmt.setDouble(3, produto.getPreco());
            pstmt.setInt(4, produto.getQtd());
            pstmt.setInt(5, produto.getTipo().getId());
            pstmt.setInt(6, produto.getSituacao().getId());
            
            pstmt.execute();
            
            return true;
            
        } catch (Exception ex) {
            
            return false;
            
        } finally {
            
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(TipoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
}
