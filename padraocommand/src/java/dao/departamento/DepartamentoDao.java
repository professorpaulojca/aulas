/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.departamento;

import Util.ConectaBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Departamento;

/**
 *
 * @author profe
 */
public class DepartamentoDao implements IDepartamentodao {

    private static final String SELECT_ALL = "SELECT * FROM departamento where descricao ilike ?;";
    private static final String INSERT = "INSERT INTO departamento(descricao) values(?);";
    private static final String DELETE = "DELETE FROM departamento where id=?";
    private static final String BUSCAR = "SELECT * FROM departamento WHERE id=?;";
    private static final String UPDATE = "UPDATE departamento set descricao=? WHERE id=?";

    private Object pstmt;
    private Connection conexao;

    @Override
    public ArrayList<Departamento> listar(Departamento departamento) {

        //cria uma array de obJ Departamento
        ArrayList<Departamento> listaDepartamento = new ArrayList<Departamento>();

        try {

            //Conexao
            conexao = ConectaBanco.getConexao();
            //cria comando SQL
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);
            
            
            pstmt.setString(1, "%" + departamento.getDescricao() + "%");
            
            //executa
            ResultSet rs = pstmt.executeQuery();
            
            

            while (rs.next()) {
                //a cada loop
                Departamento novoDepartamento = new Departamento();
                novoDepartamento.setId(rs.getInt("id"));
                novoDepartamento.setDescricao(rs.getString("descricao"));

                //add na lista
                listaDepartamento.add(novoDepartamento);
            }
            return listaDepartamento;

        } catch (Exception ex) {
            
            return listaDepartamento;

        } finally {
                       
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(DepartamentoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    @Override
    public void buscar(Departamento departamento) {

        try {
            //Conexao
            conexao = ConectaBanco.getConexao();
            //cria comando SQL
            PreparedStatement pstmt = conexao.prepareStatement(BUSCAR);

            pstmt.setInt(1, departamento.getId());
            //executa
            ResultSet rs = pstmt.executeQuery();

            // como a query ira retornar somente um registro, faremos o NEXT
            rs.next();

            departamento.setDescricao(rs.getString("descricao"));
         

        } catch (Exception e) {

            //
            
        } finally {
            
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(DepartamentoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    @Override
    public boolean alterar(Departamento departamento) {
       
         try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(UPDATE);

            pstmt.setString(1, departamento.getDescricao());
            pstmt.setInt(2, departamento.getId());

            
            pstmt.execute();
            return true;

        } catch (Exception ex) {

            return false;

        } finally {

             try {
                 conexao.close();
             } catch (SQLException ex) {
                 Logger.getLogger(DepartamentoDao.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        
    }

    @Override
    public boolean excluir(Departamento departamento) {
       
         try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(DELETE);

            pstmt.setInt(1, departamento.getId());

            pstmt.execute();

            return true;

        } catch (Exception ex) {

            return false;

        } finally {

             try {
                 conexao.close();
             } catch (SQLException ex) {
                 Logger.getLogger(DepartamentoDao.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        
        
    }

    @Override
    public boolean cadastrar(Departamento departamento) {

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(INSERT);

            pstmt.setString(1, departamento.getDescricao());

            pstmt.execute();
            
            return true;

        } catch (Exception ex) {

            return false;
            
        } finally {
            
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(DepartamentoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

    }

}
