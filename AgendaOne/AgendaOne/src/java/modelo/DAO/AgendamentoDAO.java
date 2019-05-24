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
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import modelo.Agendamento;
import modelo.Cliente;
import modelo.Servico;
import modelo.TipoServico;

/**
 *
 * @author user
 */
public class AgendamentoDAO {

    private static final String SELECT_PORDATA = "select agenda.*,cliente.id as idcliente,cliente.telefone,cliente.nome as nomecli,servico.nome as nomeserv, tiposervico.descricao as tiposerv from agenda \n"
            + "inner join cliente on (agenda.cliente = cliente.id)\n"
            + "inner join servico on (agenda.servico = servico.id)\n"
            + "inner join tiposervico on (servico.id_tipo = tiposervico.id) WHERE data=? order by data asc,hora asc,datafinal asc,horafinal asc;";
    private static final String BUSCAR = "SELECT * FROM agenda WHERE id=?;";
    private static final String INSERT = "INSERT INTO public.agenda(cliente, servico, data, hora, datafinal, horafinal, valor) VALUES ( ?, ?, ?, ?, ?, ?, ?);";
    private static final String DELETE = "DELETE from agenda  where id=?";
    private static final String VALIDAR = "SELECT id FROM agenda where (data >= ? and hora >= ?) and ((data <= ? and hora <= ?));";
    
    
    public ArrayList<Agendamento> listar(Agendamento agendamento) throws ClassNotFoundException {
        //cria uma array de obJ Cliente
        ArrayList<Agendamento> listaAgendamento = new ArrayList<Agendamento>();
        try {
            //Conexao
            Connection conexao = ConectaBanco.getConexao();
            //cria comando SQL

            PreparedStatement pstmt = conexao.prepareStatement(SELECT_PORDATA);
            Calendar cal = Calendar.getInstance();
            cal.setTime(agendamento.getData());

            pstmt.setDate(1, new java.sql.Date((cal.getTime()).getTime()));

            //executa
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                //a cada loop
                Agendamento novoAgendamento = new Agendamento();
                novoAgendamento.setId(rs.getInt("id"));
                novoAgendamento.setCliente(new Cliente(rs.getInt("cliente"),rs.getString("nomecli"), rs.getString("telefone")));
                novoAgendamento.setServico(new Servico(rs.getInt("servico"),rs.getString("nomeserv")));
                novoAgendamento.getServico().setTipo(new TipoServico(0, rs.getString("tiposerv")));
                novoAgendamento.setValor(rs.getDouble("valor"));
                novoAgendamento.setData(rs.getDate("data"));
                novoAgendamento.setHora(rs.getTime("hora"));
                novoAgendamento.setDatafinal(rs.getDate("datafinal"));
                novoAgendamento.setHorafinal(rs.getTime("horafinal"));

                //add na lista
                listaAgendamento.add(novoAgendamento);
            }
        } catch (SQLException ex) {
            //
        }
        return listaAgendamento;

    }
    
    public boolean cadastrar(Agendamento agendamento) throws SQLException, ClassNotFoundException {

        Connection conexao = null;

        try {
            
            

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(INSERT);

            pstmt.setInt(1, agendamento.getCliente().getId());
            pstmt.setInt(2, agendamento.getServico().getId());
            Calendar cal = Calendar.getInstance();
            cal.setTime(agendamento.getData());
            //pstmt.setString(3, cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH)+1) + "-" + cal.get(Calendar.DAY_OF_MONTH));
            java.sql.Date data = new java.sql.Date(cal.getTimeInMillis());
            pstmt.setDate(3, data );
            
            //String hora = agendamento.getHora().toString().replace("-3", "");
            
            pstmt.setTime(4, agendamento.getHora());
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(agendamento.getDatafinal());
        
            java.sql.Date datafinal = new java.sql.Date(cal2.getTimeInMillis());
            
            pstmt.setDate(5, datafinal);
            //String horafinal = agendamento.getHorafinal().toString().replace("-3", "");
            
            pstmt.setTime(6, agendamento.getHorafinal());
            
            pstmt.setDouble(7, agendamento.getValor());
            
            pstmt.execute();
            return true;

        } catch (Exception ex) {

            return false;

        } finally {

            conexao.close();
        }
    }
    
    public void buscar(Agendamento agendamento) {

        try {
            //Conexao
            Connection conexao = ConectaBanco.getConexao();
            //cria comando SQL
            PreparedStatement pstmt = conexao.prepareStatement(BUSCAR);

            pstmt.setInt(1, agendamento.getId());
            //executa
            ResultSet rs = pstmt.executeQuery();

            // como a query ira retornar somente um registro, faremos o NEXT
            rs.next();

            agendamento.setCliente(new Cliente(rs.getInt("cliente"),rs.getString("nomecli"), rs.getString("telefone")));
            agendamento.setServico(new Servico(rs.getInt("servico"), rs.getString("nomeserv")));
            agendamento.getServico().setTipo(new TipoServico(0, rs.getString("tiposerv")));
            agendamento.setData(rs.getDate("data"));
            agendamento.setHora(rs.getTime("hora"));
            agendamento.setDatafinal(rs.getDate("datafinal"));
            agendamento.setHorafinal(rs.getTime("horafinal"));

        } catch (Exception e) {

            //
        }
    }
    
    public boolean excluir(Agendamento agend) throws SQLException {

        Connection conexao = null;

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(DELETE);

            pstmt.setInt(1, agend.getId());

            pstmt.execute();

            return true;

        } catch (Exception ex) {

            return false;

        } finally {

            conexao.close();
        }

    }
    public boolean validar(Agendamento agendamento) throws ClassNotFoundException {
        
        try {
            //Conexao
            Connection conexao = ConectaBanco.getConexao();
            //cria comando SQL

            PreparedStatement pstmt = conexao.prepareStatement(VALIDAR);
            Calendar cal = Calendar.getInstance();
      
            cal.setTime(agendamento.getData());
            java.sql.Date data = new java.sql.Date(cal.getTimeInMillis());
            pstmt.setDate(1, data);
           
            
            cal.setTime(agendamento.getDatafinal());
            java.sql.Date datafinal = new java.sql.Date(cal.getTimeInMillis());
            
            
            pstmt.setDate(3, datafinal);
            
            pstmt.setTime(2, agendamento.getHora());
            pstmt.setTime(4, agendamento.getHorafinal());
            

            //executa
            ResultSet rs = pstmt.executeQuery();

            return rs.next();
            
        } catch (SQLException ex) {
            //
            return false;
        }
      

    }

}
