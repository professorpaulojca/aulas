package modelo.DAO;

import Util.ConectaBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Tipo;

public class TipoDAO {

    
    private static final String SELECT_ALL = "SELECT * FROM Tipo where situacao<>3;";
    private Object pstmt;

    

    public ArrayList<Tipo> listar() throws SQLException, ClassNotFoundException {
        //cria uma array de obJ Tipo
        ArrayList<Tipo> listaTipo = new ArrayList<Tipo>();

        //Conexao
        Connection conexao = ConectaBanco.getConexao();
        //cria comando SQL
        PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);
        //executa
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            //a cada loop
            Tipo novoTipo = new Tipo();
            novoTipo.setId(rs.getInt("id"));
            novoTipo.setDescricao(rs.getString("descricao"));

            //add na lista
            listaTipo.add(novoTipo);
        }
        return listaTipo;
    }

    
}
