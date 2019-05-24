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
import javax.servlet.http.HttpSession;
import modelo.Usuario;
import modelo.DAO.UsuarioDAO;
import modelo.DAO.TipoDAO;
import modelo.DAO.UsuarioDAO;
import modelo.Tipo;
import modelo.Usuario;

/**
 *
 * @author 11162101222
 */
@WebServlet(name = "ControleUsuario", urlPatterns = {"/ControleUsuario"})
public class ControleUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset:=UTF-8");
        try (PrintWriter out = response.getWriter()){
            //recupera param acao
            String acao = request.getParameter("acao");
            
            if (acao.equals("Logar")) {
                String usuario = request.getParameter("txtUsuario");
                String senha = request.getParameter("txtSenha");

                Usuario objusuario = new Usuario();
                objusuario.setLogin(usuario);
                objusuario.setSenha(senha);

                UsuarioDAO objusuariodao = new UsuarioDAO();

                if (objusuariodao.logar(objusuario)) {

                    HttpSession sessao = request.getSession();
                    sessao.setAttribute("iduser", objusuario.getId());
                    sessao.setAttribute("tipouser", objusuario.getTipo());
                    sessao.setAttribute("username", objusuario.getLogin());

                    if (objusuario.getTipo() == 1) {

                        RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
                        rd.forward(request, response);
                        

                    }
                    else {RequestDispatcher rd = request.getRequestDispatcher("erro.jsp");
                        rd.forward(request, response);}

                }
            }
            if (acao.equals("Cadastrar")) {
                String nome = request.getParameter("txtNome");
                String cpf = request.getParameter("txtCpf");
                String telefone = request.getParameter("txtTelefone");
                String login = request.getParameter("txtLogin");
                String senha = request.getParameter("txtSenha");

                Usuario user = new Usuario();
                user.setNome(nome);
                user.setCpf(cpf);
                user.setTelefone(telefone);
                user.setLogin(login);
                user.setSenha(senha);
                user.setTipo(1);

                UsuarioDAO cdao = new UsuarioDAO();
                cdao.cadastrar(user);
                //redireciono
                request.setAttribute("mensagem", " cadastrado com sucesso!");
                RequestDispatcher rd = request.getRequestDispatcher("sucessoUser.jsp");
                rd.forward(request, response);

            }  else if (acao.equals("excluir")) {

                int id = Integer.parseInt(request.getParameter("id"));

                Usuario user = new Usuario();
                user.setId(id);

                UsuarioDAO cdao = new UsuarioDAO();

                cdao.excluir(user);
                //redireciono
                request.setAttribute("mensagem", " excluido com sucesso!");
                RequestDispatcher rd = request.getRequestDispatcher("sucessoCli.jsp");
                rd.forward(request, response);

            } else if (acao.equals("alterar")) {

                int id = Integer.parseInt(request.getParameter("id"));

                Usuario user = new Usuario();
                user.setId(id);

                UsuarioDAO cdao = new UsuarioDAO();

                cdao.buscar(user);
                //redireciono
                request.setAttribute("user", user);
                
                //passo os tipos de user
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
                String login = request.getParameter("txtLogin");
                String senha = request.getParameter("txtSenha");
                
                int id = Integer.parseInt(request.getParameter("txtId"));
                

                Usuario user = new Usuario();
                user.setNome(nome);
                user.setCpf(cpf);
                user.setTelefone(telefone);
                user.setLogin(login);
                user.setSenha(senha);
                user.setId(id);

                UsuarioDAO cdao = new UsuarioDAO();
                cdao.alterar(user);
                //redireciono
                request.setAttribute("mensagem", " alterado com sucesso!");
                RequestDispatcher rd = request.getRequestDispatcher("sucessoCli.jsp");
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
            Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
