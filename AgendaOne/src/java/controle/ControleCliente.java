/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;
import modelo.DAO.ClienteDAO;
import modelo.DAO.TipoDAO;
import modelo.Tipo;

/**
 *
 * @author 11162101222
 */
@WebServlet(name = "ControleCliente", urlPatterns = {"/ControleCliente"})
public class ControleCliente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset:=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            //recupera param acao
            String acao = request.getParameter("acao");
            if (acao.equals("Cadastrar")) {
                String nome = request.getParameter("txtNome");
                String cpf = request.getParameter("txtCpf");
                String telefone = request.getParameter("txtTelefone");
                String endereco = request.getParameter("txtEndereco");
                int id_tipo = Integer.parseInt(request.getParameter("cmbtipocli"));
                
                

                Cliente cliente = new Cliente();
                cliente.setNome(nome);
                cliente.setCpf(cpf);
                cliente.setTelefone(telefone);
                cliente.setEndereco(endereco);
                cliente.setTipo(new Tipo(id_tipo));

                ClienteDAO cdao = new ClienteDAO();
                cdao.cadastrar(cliente);
                //redireciono
                request.setAttribute("mensagem", " cadastrado com sucesso!");
                RequestDispatcher rd = request.getRequestDispatcher("sucessoCli.jsp");
                rd.forward(request, response);

            } else if (acao.equals("Listar")) {
                //cria objeto
                ClienteDAO cDAO = new ClienteDAO();
                //executa o método listar
                ArrayList<Cliente> clientes = cDAO.listar();
                //add a lista no obJ eto request   
                request.setAttribute("listaCliente", clientes);
                //encaminha o request para o J SP
                RequestDispatcher rd = request.getRequestDispatcher("listaCliente.jsp");
                rd.forward(request, response);

            } else if (acao.equals("excluir")) {

                int id = Integer.parseInt(request.getParameter("id"));

                Cliente cliente = new Cliente();
                cliente.setId(id);

                ClienteDAO cdao = new ClienteDAO();

                cdao.excluir(cliente);
                //redireciono
                request.setAttribute("mensagem", " excluido com sucesso!");
                RequestDispatcher rd = request.getRequestDispatcher("sucessoCli.jsp");
                rd.forward(request, response);

            } else if (acao.equals("alterar")) {

                int id = Integer.parseInt(request.getParameter("id"));

                Cliente cliente = new Cliente();
                cliente.setId(id);

                ClienteDAO cdao = new ClienteDAO();

                cdao.buscar(cliente);
                //redireciono
                request.setAttribute("cliente", cliente);
                
                //passo os tipos de cliente
                 //cria objeto
                TipoDAO cDAO = new TipoDAO();
                //executa o método listar
                ArrayList<Tipo> tipos = cDAO.listar();
                //add a lista no obJ eto request   
                request.setAttribute("listaTipo", tipos);
                
                RequestDispatcher rd = request.getRequestDispatcher("alterarcli.jsp");
                rd.forward(request, response);

            } else if (acao.equals("Confirmar")) {
                
                String nome = request.getParameter("txtNome");
                String cpf = request.getParameter("txtCpf");
                String telefone = request.getParameter("txtTelefone");
                String endereco = request.getParameter("txtEndereco");
                int id_tipo = Integer.parseInt(request.getParameter("cmbtipocli"));
                
                int id = Integer.parseInt(request.getParameter("txtId"));
                

                Cliente cliente = new Cliente();
                cliente.setNome(nome);
                cliente.setCpf(cpf);
                cliente.setTelefone(telefone);
                cliente.setEndereco(endereco);
                cliente.setTipo(new Tipo(id_tipo));
                cliente.setId(id);

                ClienteDAO cdao = new ClienteDAO();
                cdao.alterar(cliente);
                //redireciono
                request.setAttribute("mensagem", " alterado com sucesso!");
                RequestDispatcher rd = request.getRequestDispatcher("sucessoCli.jsp");
                rd.forward(request, response);

            }  else if (acao.equals("interfaceCADCLI")) {
                
                //cria objeto
                TipoDAO cDAO = new TipoDAO();
                //executa o método listar
                ArrayList<Tipo> tipos = cDAO.listar();
                //add a lista no obJ eto request   
                request.setAttribute("listaTipo", tipos);
                //encaminha o request para o J SP
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);

            }
        } catch (Exception e) {
            request.setAttribute("erro", e);
            RequestDispatcher rd = request.getRequestDispatcher("erro.jsp");
            rd.forward(request, response);
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControleCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControleCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
