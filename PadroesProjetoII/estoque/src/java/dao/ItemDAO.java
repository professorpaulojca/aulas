package dao;

import Util.ConectaBanco;
import dao.ProdutoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Item;
import modelo.Pedido;
import modelo.Produto;
import modelo.Tipo;

public class ItemDAO {

    private static final String SELECT_ALL = "select item.id,item.idproduto,item.quantidade,item.precounitario from item where idpedido=?;";
    private static final String SELECT_ID = "select item.id,item.idproduto,item.quantidade,item.precounitario from item where id=?;";

    public ArrayList<Item> listar(Pedido pedido) throws SQLException, ClassNotFoundException {
        //cria uma array de obJ Cliente
        ArrayList<Item> listaCliente = new ArrayList<Item>();

        //Conexao
        Connection conexao = ConectaBanco.getConexao();
        //cria comando SQL
        PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);

        pstmt.setInt(1, pedido.getId());

        //executa
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            //a cada loop
            Item novoitem = new Item();

            novoitem.setId(rs.getInt("id"));
            novoitem.setPrecounitario(rs.getDouble("precounitario"));
            novoitem.setProduto(new Produto(rs.getInt("idproduto")));

            ProdutoDAO prodDAO = new ProdutoDAO();
            prodDAO.buscar(novoitem.getProduto());

            //add na lista
            listaCliente.add(novoitem);
        }
        return listaCliente;
    }

    public void buscar(Item item) throws ClassNotFoundException, SQLException {

        //Conexao
        Connection conexao = ConectaBanco.getConexao();
        //cria comando SQL
        PreparedStatement pstmt = conexao.prepareStatement(SELECT_ID);

        pstmt.setInt(1, item.getId());

        //executa
        ResultSet rs = pstmt.executeQuery();

        rs.next();
        //a cada loop

        item.setPrecounitario(rs.getDouble("precounitario"));
        item.setProduto(new Produto(rs.getInt("idproduto")));
        item.setQuantidade(rs.getDouble("quantidade"));

        ProdutoDAO prodDAO = new ProdutoDAO();
        prodDAO.buscar(item.getProduto());

    }

}
