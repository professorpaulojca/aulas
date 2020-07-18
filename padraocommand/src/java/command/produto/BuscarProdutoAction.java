/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.produto;

import command.ICommand;
import dao.departamento.DepartamentoDao;
import dao.produto.ProdutoDao;
import dao.situacao.SituacaoDao;
import dao.tipo.TipoDao;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Departamento;
import modelo.Produto;
import modelo.Situacao;
import modelo.Tipo;

/**
 *
 * @author alunocmc
 */
public class BuscarProdutoAction implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            Situacao situacao = new Situacao();
            SituacaoDao situacaodao = new SituacaoDao();
            ArrayList<Situacao> arrsituacao = new ArrayList<>();
            situacao.setDescricao(""); //desta forma virão todos os registros
            arrsituacao = situacaodao.listar(situacao);
            HttpSession session = request.getSession();
            session.setAttribute("arrsituacao", arrsituacao);

        } catch (Exception ex) {
            //nada a fazer
        }

        Produto produto = new Produto();

        ProdutoDao produtodao = new ProdutoDao();

        produto.setId(Integer.parseInt(request.getParameter("id")));

        produtodao.buscar(produto);

        HttpSession session = request.getSession();

        //para os departamentos
        Departamento departamento = new Departamento();
        DepartamentoDao departamentodao = new DepartamentoDao();
        ArrayList<Departamento> arrdepartamento = new ArrayList<>();
        departamento.setDescricao(""); //desta forma virão todos os registros
        arrdepartamento = departamentodao.listar(departamento);
        session.setAttribute("arrdepartamento", arrdepartamento);

        //se vier o campo de departamento devemos criar o arraylist de tipos
        //um produto pode ter um departamento e um tipo
            //para os departamentos
            Tipo tipo = new Tipo();
            TipoDao tipodao = new TipoDao();
            ArrayList<Tipo> arrtipo = new ArrayList<>();
            tipo.setIdDepartamento(produto.getDepartamento().getId()); //precisaremos deste atributo pois um departamento pode ter mais que um tipo, pois estamos usando banco de dados relacional
            arrtipo = tipodao.listarpordepartamento(tipo);
            session.setAttribute("arrtipo", arrtipo);

        session.setAttribute("produto", produto);

        return "/cadastros/produto/alterar_produto.jsp";

    }

}
