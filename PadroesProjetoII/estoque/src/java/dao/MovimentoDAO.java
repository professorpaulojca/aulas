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
import modelo.Movimento;

/**
 *
 * @author paulojca
 */
public class MovimentoDAO {

    private static final String INSERT = "INSERT INTO public.movimento(\n"
            + "	 data, hora, idtipo, referencia, idproduto, quantidade)\n"
            + "	VALUES ( ?, ?, ?, ?, ?, ?);";

    private Object pstm;

    public boolean cadastrar(Movimento movimento) throws SQLException, ClassNotFoundException {

        Connection conexao = null;

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(INSERT);

            Calendar cal = Calendar.getInstance();

            cal.setTime(movimento.getData());

            java.sql.Date data = new java.sql.Date(cal.getTimeInMillis());

            pstmt.setDate(1, data);
            pstmt.setTime(2, movimento.getHora());
            pstmt.setInt(3, movimento.getTipo().getId());
            pstmt.setString(4, movimento.getReferencia());
            pstmt.setInt(5, movimento.getProduto().getId());
            pstmt.setDouble(6, movimento.getQuantidade());

            pstmt.execute();
            return true;

        } catch (Exception ex) {

            return false;

        } finally {

            conexao.close();
        }
    }

}
