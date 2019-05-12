/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Util.ConectaBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Item;
import modelo.Pedido;

/**
 *
 * @author paulojca
 */
public class pedidoDAO {

    private static final String SELECT_ALL = "select pedido.id,pedido.data,pedido.hora from pedido where pedido.id=?";

    private Object pstm;

    public void buscar(Pedido pedido) throws SQLException {
        //cria uma array de obJ Item

        //Conexao
        Connection conexao;
        try {
            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);

            pstmt.setInt(1, pedido.getId());

            //executa
            ResultSet rs = pstmt.executeQuery();

            //ler dados do pedido
            rs.next();

            pedido.setData(rs.getDate("data"));
            pedido.setHora(rs.getTime("hora"));

            //ler dados dos itens
            ArrayList<Item> arritem = new ArrayList<>();

            ItemDAO itemdao = new ItemDAO();

            arritem = itemdao.listar(pedido);

            //associar os itens ao pedido
            pedido.setItens(arritem);

        } catch (Exception ex) {

            //
        }

    }

}
