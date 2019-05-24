package modelo.DAO;

import Util.ConectaBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Cliente;
import modelo.Tipo;

public class ClienteDAO {

    private static final String INSERT = "INSERT INTO cliente(nome,cpf,telefone,endereco,situacao,id_tipo) values(?,?,?,?,1,?)";
    private static final String SELECT_ALL = "SELECT cliente.*,tipo.descricao FROM cliente inner join tipo on (cliente.id_tipo = tipo.id and cliente.situacao<>3);";
    private static final String DELETE = "UPDATE cliente set situacao=3 where id=?";
    private static final String BUSCAR = "SELECT * FROM cliente WHERE id=?;";
    private static final String UPDATE = "UPDATE cliente SET nome=?, cpf=?, telefone=?, endereco=?, id_tipo=? WHERE id=?;";

    private Object pstm;

    public boolean cadastrar(Cliente cliente) throws SQLException, ClassNotFoundException {

        Connection conexao = null;

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(INSERT);

            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getCpf());
            pstmt.setString(3, cliente.getTelefone());
            pstmt.setString(4, cliente.getEndereco());
            pstmt.setInt(5,cliente.getTipo().getId());
            
            pstmt.execute();
            return true;

        } catch (Exception ex) {

            return false;

        } finally {

            conexao.close();
        }
    }

    public ArrayList<Cliente> listar() throws SQLException, ClassNotFoundException {
        //cria uma array de obJ Cliente
        ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();

        //Conexao
        Connection conexao = ConectaBanco.getConexao();
        //cria comando SQL
        PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);
        //executa
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            //a cada loop
            Cliente novoCliente = new Cliente();
            novoCliente.setId(rs.getInt("id"));
            novoCliente.setNome(rs.getString("nome"));
            novoCliente.setCpf(rs.getString("cpf"));
            novoCliente.setTelefone(rs.getString("telefone"));
            novoCliente.setEndereco(rs.getString("endereco"));
            novoCliente.setTipo(new Tipo(rs.getInt("id_tipo"),rs.getString("descricao")));
            //add na lista
            listaCliente.add(novoCliente);
        }
        return listaCliente;
    }

    public boolean excluir(Cliente cliente) throws SQLException {

        Connection conexao = null;

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(DELETE);

            pstmt.setInt(1, cliente.getId());

            pstmt.execute();

            return true;

        } catch (Exception ex) {

            return false;

        } finally {

            conexao.close();
        }

    }

    public void buscar(Cliente cliente) {

        try {
            //Conexao
            Connection conexao = ConectaBanco.getConexao();
            //cria comando SQL
            PreparedStatement pstmt = conexao.prepareStatement(BUSCAR);

            pstmt.setInt(1, cliente.getId());
            //executa
            ResultSet rs = pstmt.executeQuery();

            // como a query ira retornar somente um registro, faremos o NEXT
            rs.next();

            cliente.setNome(rs.getString("nome"));
            cliente.setCpf(rs.getString("cpf"));
            cliente.setTelefone(rs.getString("telefone"));
            cliente.setEndereco(rs.getString("endereco"));
            cliente.setTipo(new Tipo(rs.getInt("id_tipo")));

        } catch (Exception e) {

            //
        }
    }

    public boolean alterar(Cliente cliente) throws SQLException {
        Connection conexao = null;

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(UPDATE);

            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getCpf());
            pstmt.setString(3, cliente.getTelefone());
            pstmt.setString(4, cliente.getEndereco());
            pstmt.setInt(5, cliente.getTipo().getId());
            pstmt.setInt(6, cliente.getId());

            
            pstmt.execute();
            return true;

        } catch (Exception ex) {

            return false;

        } finally {

            conexao.close();
        }

    }
}
