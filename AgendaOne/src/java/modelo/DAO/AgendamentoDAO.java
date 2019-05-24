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

    private static final String SELECT_PORDATA = "select agenda.*,cliente.id as idcliente,cliente.telefone,cliente.nome as nomecli,servico.nome as nomeserv,tiposervico.descricao as tiposerv from agenda \n"
            + "inner join cliente on (agenda.cliente = cliente.id)\n"
            + "inner join servico on (agenda.servico = servico.id)\n"
            + "inner join tiposervico on (servico.id_tipo = tiposervico.id) WHERE data=? order by data asc,hora asc,datafinal asc,horafinal asc;";

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

}
