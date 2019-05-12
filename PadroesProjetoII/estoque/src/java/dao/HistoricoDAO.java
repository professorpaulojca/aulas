/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Util.ConectaBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import modelo.Historico;

/**
 *
 * @author paulojca
 */
public class HistoricoDAO {
    
     private static final String INSERT = "INSERT INTO public.historico(\n" +
"	idpedido, data, hora, situacao, observacao)\n" +
"	VALUES (?, ?, ?, ?, ?);";
         
   
     private Object pstm;
     public boolean cadastrar(Historico historico) throws SQLException, ClassNotFoundException {

        Connection conexao = null;

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(INSERT);

            pstmt.setInt(1, historico.getPedido().getId());
            
            Calendar cal = Calendar.getInstance();
            
            cal.setTime(historico.getData());
            
            java.sql.Date data = new java.sql.Date(cal.getTimeInMillis());
            
            pstmt.setDate(2, data);
            pstmt.setTime(3, historico.getHora());
            pstmt.setInt(4, historico.getSituacao().getId());
            pstmt.setString(5,historico.getObservacao());
            
            pstmt.execute();
            return true;

        } catch (Exception ex) {

            return false;

        } finally {

            conexao.close();
        }
    }

    
}
