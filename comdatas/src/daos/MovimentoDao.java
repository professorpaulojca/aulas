/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import utilidade.ConectaBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Movimentodedatas;

/**
 *
 * @author profe
 */
public class MovimentoDao implements IMovimentoDao {
    
    
    ///////////////////////////
//    CREATE TABLE public.movimentadatas
//(
//    id integer NOT NULL DEFAULT nextval('movimentadatas_id_seq'::regclass),
//    somentedata date,
//    somentehora time without time zone,
//    dataehorajuntos timestamp without time zone,
//    CONSTRAINT movimentadatas_pkey PRIMARY KEY (id)
//)
    ///////////////////////////

    private static final String SELECT_ALL = "SELECT * from movimentadatas;";
    private static final String INSERT = "INSERT INTO public.movimentadatas(somentedata, somentehora, dataehorajuntos) VALUES ( ?, ?, ?);";
    private static final String BUSCAR = "SELECT * from movimentodatas where id=?;";

    @Override
    public ArrayList<Movimentodedatas> listar(Movimentodedatas movimentodedatas) {
        //cria uma array de obJ Cliente
        ArrayList<Movimentodedatas> listaMovimentodatas = new ArrayList<Movimentodedatas>();
        try {
            //Conexao
            Connection conexao = ConectaBanco.getConexao();
            //cria comando SQL

            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);
          

            //executa
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                //a cada loop
                Movimentodedatas novoMovimento = new Movimentodedatas();

                novoMovimento.setSomentedata(rs.getDate("somentedata"));
                novoMovimento.setSomentehora(rs.getTime("somentehora"));
                novoMovimento.setDataehorajuntos(rs.getTimestamp("dataehorajuntos"));

                //add na lista
                listaMovimentodatas.add(novoMovimento);
            }
        } catch (SQLException ex) {
            //
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(MovimentoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaMovimentodatas;

    }

    @Override
    public boolean cadastrar(Movimentodedatas movimentodedatas) {

        Connection conexao = null;
        try {
            conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(INSERT);
            Calendar cal = Calendar.getInstance();
            cal.setTime(movimentodedatas.getSomentedata());
            java.sql.Date somentedata = new java.sql.Date(cal.getTimeInMillis());
            pstmt.setDate(1, somentedata);
            pstmt.setTime(2, movimentodedatas.getSomentehora());
            pstmt.setTimestamp(3, new java.sql.Timestamp(movimentodedatas.getDataehorajuntos().getTime()));
            pstmt.execute();
            return true;
        } catch (Exception ex) {
            return false;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(MovimentoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void buscar(Movimentodedatas movimentodedatas) {

        Connection conexao = null;
        try {
            //Conexao
            conexao = ConectaBanco.getConexao();
            //cria comando SQL

            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);
            Calendar cal = Calendar.getInstance();
            cal.setTime(movimentodedatas.getSomentedata());

            pstmt.setDate(1, new java.sql.Date((cal.getTime()).getTime()));

            //executa
            ResultSet rs = pstmt.executeQuery();

            rs.next();

            movimentodedatas.setSomentedata(rs.getDate("data"));
            movimentodedatas.setSomentehora(rs.getTime("hora"));
            movimentodedatas.setDataehorajuntos(rs.getTime("hora"));

        } catch (SQLException ex) {
            //
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovimentoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
