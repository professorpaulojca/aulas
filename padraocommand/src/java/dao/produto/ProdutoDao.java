/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.produto;

import Util.ConectaBanco;
import dao.departamento.DepartamentoDao;
import dao.situacao.SituacaoDao;
import dao.tipo.TipoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Departamento;
import modelo.Produto;
import modelo.Situacao;
import modelo.Tipo;

/**
 *
 * @author profe
 */
public class ProdutoDao implements IProdutoDao {

    private static final String SELECT_ALL = "SELECT * FROM produto where descricao ilike ?;";
    private static final String INSERT = "INSERT INTO produto(descricao,quantidade,situacao,departamento,tipo) values(?,?,?,?,?);";
    private static final String DELETE = "DELETE FROM produto where id=?";
    private static final String BUSCAR = "SELECT * FROM produto WHERE id=?;";
    private static final String UPDATE = "UPDATE produto set descricao=?,quantidade=?,situacao=?,departamento=?,tipo=? WHERE id=?";

    private Object pstmt;
    private Connection conexao;

    @Override
    public ArrayList<Produto> listar(Produto produto) {

        //cria uma array de obJ Produto
        ArrayList<Produto> listaProduto = new ArrayList<Produto>();

        try {

            //Conexao
            conexao = ConectaBanco.getConexao();
            //cria comando SQL
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);

            pstmt.setString(1, "%" + produto.getDescricao() + "%");

            //executa
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                //a cada loop
                Produto novoProduto = new Produto();
                novoProduto.setId(rs.getInt("id"));
                novoProduto.setDescricao(rs.getString("descricao"));
                novoProduto.setQuantidade(rs.getInt("quantidade"));
                //parte importante, pois precisamos da situacao que esta agregada de produto
                //Precisao de uma modelo para levar os dados para a DAO]
                Situacao situacao = new Situacao();
                situacao.setId(rs.getInt("situacao"));
                //precisamos de uma dao que fara a busca dos dados junto ao banco de dados
                SituacaoDao situacaodao = new SituacaoDao();
                //desta forma teremos uma situacao para poder colocar no atributo situacao do produto
                situacaodao.buscar(situacao);
                //neste momento
                novoProduto.setSituacao(situacao);

                //agora que temos um produto 
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
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
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
            produto.setDescricao(rs.getString("descricao"));
            produto.setQuantidade(rs.getInt("quantidade"));
            //parte importante, pois precisamos da situacao que esta agregada de produto
            //Precisao de uma modelo para levar os dados para a DAO]
            Situacao situacao = new Situacao();
            situacao.setId(rs.getInt("situacao"));
            //precisamos de uma dao que fara a busca dos dados junto ao banco de dados
            SituacaoDao situacaodao = new SituacaoDao();
            //desta forma teremos uma situacao para poder colocar no atributo situacao do produto
            situacaodao.buscar(situacao);
            //neste momento
            produto.setSituacao(situacao);
            //departamento
            Departamento departamento = new Departamento();
            departamento.setId(rs.getInt("departamento"));
            //precisamos de uma dao que fara a busca dos dados junto ao banco de dados
            DepartamentoDao departamentodao = new DepartamentoDao();
            //desta forma teremos uma situacao para poder colocar no atributo departamento do produto
            departamentodao.buscar(departamento);
            produto.setDepartamento(departamento);
            //Tipo
            Tipo tipo = new Tipo();
            tipo.setId(rs.getInt("tipo"));
            //precisamos de uma dao que fara a busca dos dados junto ao banco de dados
            TipoDao tipodao = new TipoDao();
            //desta forma teremos uma situacao para poder colocar no atributo departamento do produto
            tipodao.buscar(tipo);

            //neste momento
            produto.setTipo(tipo);

            //agora que temos um produto 
        } catch (Exception e) {

            //
        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public boolean alterar(Produto produto) {

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(UPDATE);

            pstmt.setString(1, produto.getDescricao());
            pstmt.setInt(2, produto.getQuantidade());
            pstmt.setInt(3, produto.getSituacao().getId()); //percaba que neste ponto temos que pegar o id da situacao que esta dentro de produto
            pstmt.setInt(4, produto.getDepartamento().getId()); //id do departamento
            pstmt.setInt(5, produto.getTipo().getId()); //id do tipo
            pstmt.setInt(6, produto.getId());

            pstmt.execute();
            return true;

        } catch (Exception ex) {

            return false;

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public boolean cadastrar(Produto produto) {

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(INSERT);

            pstmt.setString(1, produto.getDescricao());
            pstmt.setInt(2, produto.getQuantidade());
            pstmt.setInt(3, produto.getSituacao().getId()); //perceba que neste ponto temos que pegar o id da situacao que esta dentro de produto
            pstmt.setInt(4, produto.getDepartamento().getId()); //id do departamento
            pstmt.setInt(5, produto.getTipo().getId()); //id do tipo

            pstmt.execute();

            return true;

        } catch (Exception ex) {

            return false;

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
