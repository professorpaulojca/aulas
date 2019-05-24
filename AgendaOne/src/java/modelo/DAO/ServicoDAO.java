package modelo.DAO;

import Util.ConectaBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Servico;
import modelo.Tipo;
import modelo.TipoServico;

public class ServicoDAO {

    private static final String INSERT = "INSERT INTO servico(nome,cpf,telefone,situacao,id_tipo) values(?,?,?,?,?);";
    private static final String SELECT_ALL = "SELECT servico.*,tipo.descricao FROM servico inner join tipo on (servico.id_tipo = tipo.id and servico.situacao<>3);";
    private static final String DELETE = "UPDATE servico set situacao=3 where id=?";
    private static final String BUSCAR = "SELECT * FROM servico WHERE id=?;";
    private static final String UPDATE = "UPDATE servico set nome=?, cpf=?, telefone=?, situacao=?, id_tipo=? WHERE id=?";

    private Object pstm;

    public boolean cadastrar(Servico servico) throws SQLException, ClassNotFoundException {

        Connection conexao = null;
        

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(INSERT);

            pstmt.setString(1, servico.getNome());
         
            pstmt.setInt(4, servico.getSituacao());
            pstmt.setInt(5, servico.getTipo().getId());
            pstmt.execute();
            return true;

        } catch (Exception ex) {
            

            return false;

        } finally {

            conexao.close();
        }
    }

    public ArrayList<Servico> listar() throws SQLException, ClassNotFoundException {
        //cria uma array de obJ Servico
        ArrayList<Servico> listaServico = new ArrayList<Servico>();

        //Conexao
        Connection conexao = ConectaBanco.getConexao();
        //cria comando SQL
        PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);
        //executa
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            //a cada loop
            Servico novoServico = new Servico();
            novoServico.setId(rs.getInt("id"));
            novoServico.setNome(rs.getString("nome"));
          
            novoServico.setSituacao(rs.getInt("situacao"));
            novoServico.setTipo(new TipoServico(rs.getInt("id_tipo"),rs.getString("descricao")));
            //add na lista
            listaServico.add(novoServico);
        }
        return listaServico;
    }

    public boolean excluir(Servico servico) throws SQLException {

        Connection conexao = null;

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(DELETE);

            pstmt.setInt(1, servico.getId());

            pstmt.execute();

            return true;

        } catch (Exception ex) {

            return false;

        } finally {

            conexao.close();
        }

    }

    public void buscar(Servico servico) {

        try {
            //Conexao
            Connection conexao = ConectaBanco.getConexao();
            //cria comando SQL
            PreparedStatement pstmt = conexao.prepareStatement(BUSCAR);

            pstmt.setInt(1, servico.getId());
            //executa
            ResultSet rs = pstmt.executeQuery();

            // como a query ira retornar somente um registro, faremos o NEXT
            rs.next();

            servico.setNome(rs.getString("nome"));
         
            servico.setSituacao(rs.getInt("situacao"));
            servico.setTipo(new TipoServico(rs.getInt("id_tipo")));

        } catch (Exception e) {

            //
        }
    }

    public boolean alterar(Servico servico) throws SQLException {
        Connection conexao = null;

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(UPDATE);

            pstmt.setString(1, servico.getNome());
        
            pstmt.setInt(4, servico.getSituacao());
            pstmt.setInt(5, servico.getTipo().getId());
            pstmt.setInt(6, servico.getId());

            
            pstmt.execute();
            return true;

        } catch (Exception ex) {

            return false;

        } finally {

            conexao.close();
        }

    }
}
