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
public class AlterarProdutoAction implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        //precisamos antes colocar o vetor de situacaoes na session
        try {

            Situacao situacao = new Situacao();
            SituacaoDao situacaodao = new SituacaoDao();
            ArrayList<Situacao> arrsituacao = new ArrayList<>();
            situacao.setDescricao(""); //desta forma virão todos os registros
            arrsituacao = situacaodao.listar(situacao);

            session.setAttribute("arrsituacao", arrsituacao);

            //para os departamentos
            Departamento departamento = new Departamento();
            DepartamentoDao departamentodao = new DepartamentoDao();
            ArrayList<Departamento> arrdepartamento = new ArrayList<>();
            departamento.setDescricao(""); //desta forma virão todos os registros
            arrdepartamento = departamentodao.listar(departamento);
            session.setAttribute("arrdepartamento", arrdepartamento);

            //se vier o campo de departamento devemos criar o arraylist de tipos
            //um produto pode ter um departamento e um tipo
            if (request.getParameter("cmbdepartamento") != null) {
                //para os departamentos
                Tipo tipo = new Tipo();
                TipoDao tipodao = new TipoDao();
                ArrayList<Tipo> arrtipo = new ArrayList<>();
                tipo.setIdDepartamento(Integer.parseInt(request.getParameter("cmbdepartamento"))); //precisaremos deste atributo pois um departamento pode ter mais que um tipo, pois estamos usando banco de dados relacional
                arrtipo = tipodao.listarpordepartamento(tipo);
                session.setAttribute("arrtipo", arrtipo);
            }

        } catch (Exception ex) {
            //nada a fazer
        }

        if ("Alterar".equals(request.getParameter("btnalterar"))) {//se o usuário clicar no botão alterar

            Produto produto = new Produto();

            produto.setDescricao(request.getParameter("txtdescricao"));
            produto.setQuantidade(Integer.parseInt(request.getParameter("txtquantidade")));

            produto.setId(Integer.parseInt(request.getParameter("id")));

            Situacao situacao = new Situacao(); //perceba que procisamos criar um objeto situacao que será agregado ao produto
            situacao.setId(Integer.parseInt(request.getParameter("cmbsituacao")));
            produto.setSituacao(situacao); //aqui acontece a agregação
            //departamento
            Departamento departamento = new Departamento();
            departamento.setId(Integer.parseInt(request.getParameter("cmbdepartamento")));
            produto.setDepartamento(departamento); //aqui acontece a agregação
            //tipo
            Tipo tipo = new Tipo();
            tipo.setId(Integer.parseInt(request.getParameter("cmbtipo")));
            produto.setTipo(tipo); //aqui acontece a agregação

            ProdutoDao produtodao = new ProdutoDao();

            produtodao.alterar(produto);

            return "/ControleProduto?acao=Listar";
        } else {

            Produto produto = new Produto();
            //
            produto = (Produto) session.getAttribute("produto");
            //
            //precisamos alterar o departamento do produto, pois queremos que a combo marque como selecionado
            Departamento departamento = new Departamento();
            departamento.setId(Integer.parseInt(request.getParameter("cmbdepartamento")));
            produto.setDepartamento(departamento); //aqui acontece a agregação
            //
            session.setAttribute("produto", produto); //volta o produto para a sessão
            return "/cadastros/produto/alterar_produto.jsp";

        }

    }

}
