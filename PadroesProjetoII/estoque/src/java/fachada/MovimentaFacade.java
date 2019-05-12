/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import dao.HistoricoDAO;
import dao.ItemDAO;
import dao.MovimentoDAO;
import dao.ProdutoDAO;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import modelo.Historico;
import modelo.Historico;
import modelo.Item;
import modelo.Item;
import modelo.Movimento;
import modelo.Movimento;
import modelo.Pedido;
import modelo.Pedido;
import modelo.Situacao;
import modelo.Situacao;
import modelo.Tipo;
import modelo.Tipo;

/**
 *
 * @author profe
 */
public class MovimentaFacade {

    protected Pedido pedido;
    protected Item item;
    protected Movimento movimento;
    protected Historico historico;
    protected HistoricoDAO historicodao;
    protected ItemDAO itemdao;
    protected MovimentoDAO movimentodao;
    protected ProdutoDAO produtodao;
    protected Date datahora;
    protected Calendar cal;
    protected SimpleDateFormat formato;
    protected String hora;
    protected ArrayList<Item> itens;

    public void Inicializar(int idpedido, int iditempedido) throws Exception {

        try {

            pedido = new Pedido();
            item = new Item();
            pedido.setId(idpedido);
            item.setId(iditempedido);
            itens = new ArrayList<>();
            historico = new Historico();
            datahora = new Date();
            cal = Calendar.getInstance();
            formato = new SimpleDateFormat("HH:mm:ss");
            historicodao = new HistoricoDAO();
            itemdao = new ItemDAO();
            movimento = new Movimento();
            movimentodao = new MovimentoDAO();
            produtodao = new ProdutoDAO();
            hora = cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);

          
        } catch (Exception ex) {

            throw new Exception();
           
        }

    }

    public void montarPedido() throws Exception {

        try {

           
            itens.add(item);
            pedido.setItens(itens);
            itemdao.buscar(item);
            cal.setTime(datahora);

           

        } catch (Exception ex) {

            throw new Exception();
        }

    }

    public void montarHistorico() throws Exception {

        try {

            historico.setPedido(pedido);
            cal.setTime(datahora);
            historico.setData(datahora);
            historico.setHora(new Time(formato.parse(hora).getTime()));
            historico.setObservacao("Pedido entregue parcialmente.");
            historico.setSituacao(new Situacao(3));
            historicodao.cadastrar(historico);

          

        } catch (Exception ex) {

            throw new Exception();

        }

    }

    public void montarMovimento() throws Exception {

        try {

            movimento.setData(datahora);

            movimento.setHora(new Time(formato.parse(hora).getTime()));
            movimento.setProduto(item.getProduto());
            movimento.setQuantidade(item.getQuantidade());
            movimento.setReferencia("Pedido número " + pedido.getId());
            movimento.setTipo(new Tipo(2));
            movimentodao.cadastrar(movimento);
          

        } catch (Exception ex) {

           throw new Exception();

        }

    }

    public void montarProduto() throws Exception {

        //atualizar a quantidade do produto
        try {
            item.getProduto().setQuantidade(item.getQuantidade());
            produtodao.baixa(item.getProduto());

        } catch (Exception ex) {

            throw new Exception();

        }

    }

}
