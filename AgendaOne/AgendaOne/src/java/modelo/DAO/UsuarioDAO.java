/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import Util.ConectaBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Usuario;

/**
 *
 * @author user
 */
public class UsuarioDAO {
    
    private static final String INSERT = "INSERT INTO usuario(nome,cpf,telefone,login,senha,tipo,situacao) values(?,?,?,?,?,?,1)";
    private static final String DELETE = "UPDATE usuario set situacao=3 where id=?";
    private static final String BUSCAR = "SELECT * FROM usuario WHERE id=?;";
    private static final String UPDATE = "UPDATE usuario SET nome=?, cpf=?, telefone=?, login=?, senha=? WHERE id=?;";
    private static final String LOGIN = "SELECT * FROM usuario WHERE login=? and senha=?;";
    private Object pstm;

    public boolean cadastrar(Usuario user) throws SQLException, ClassNotFoundException {

        Connection conexao = null;

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(INSERT);

            pstmt.setString(1, user.getNome());
            pstmt.setString(2, user.getCpf());
            pstmt.setString(3, user.getTelefone());
            pstmt.setString(4, user.getLogin());
            pstmt.setString(5, user.getSenha());
            pstmt.setInt(6, user.getTipo());
            
            pstmt.execute();
            return true;

        } catch (Exception ex) {

            return false;

        } finally {

            conexao.close();
        }
    }

    public boolean logar(Usuario usuario) throws SQLException, ClassNotFoundException {
        try {
            //Conexao
            Connection conexao = ConectaBanco.getConexao();
            //cria comando SQL
            PreparedStatement pstmt = conexao.prepareStatement(LOGIN);

            pstmt.setString(1, usuario.getLogin());
            pstmt.setString(2, usuario.getSenha());
            //executa
            ResultSet rs = pstmt.executeQuery();

            // como a query ira retornar somente um registro, faremos o NEXT
            rs.next();

            usuario.setTipo(rs.getInt("tipo"));
            usuario.setId(rs.getInt("id"));
            
            //implementar a seguranca
           
            return true;

        } catch (Exception e) {

            //
            return false;
        }
    }
    
    public boolean excluir(Usuario user) throws SQLException {

        Connection conexao = null;

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(DELETE);

            pstmt.setInt(1, user.getId());

            pstmt.execute();

            return true;

        } catch (Exception ex) {

            return false;

        } finally {

            conexao.close();
        }

    }

    public void buscar(Usuario user) {

        try {
            //Conexao
            Connection conexao = ConectaBanco.getConexao();
            //cria comando SQL
            PreparedStatement pstmt = conexao.prepareStatement(BUSCAR);

            pstmt.setInt(1, user.getId());
            //executa
            ResultSet rs = pstmt.executeQuery();

            // como a query ira retornar somente um registro, faremos o NEXT
            rs.next();

            user.setNome(rs.getString("nome"));
            user.setCpf(rs.getString("cpf"));
            user.setTelefone(rs.getString("telefone"));
            user.setLogin(rs.getString("login"));
            user.setSenha(rs.getString("senha"));
            
        } catch (Exception e) {

            //
        }
    }

    public boolean alterar(Usuario user) throws SQLException {
        Connection conexao = null;

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(UPDATE);

            pstmt.setString(1, user.getNome());
            pstmt.setString(2, user.getCpf());
            pstmt.setString(3, user.getTelefone());
            pstmt.setString(4, user.getLogin());
            pstmt.setString(5, user.getSenha());
            pstmt.setInt(6, user.getId());

            
            pstmt.execute();
            return true;

        } catch (Exception ex) {

            return false;

        } finally {

            conexao.close();
        }

    }

}
