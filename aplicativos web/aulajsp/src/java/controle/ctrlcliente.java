/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.Clientedao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Cidade;
import modelo.Cliente;
import modelo.Sexo;

/**
 *
 * @author alunocmc
 */
@WebServlet(name = "ctrlcliente", urlPatterns = {"/ctrlcliente"})
public class ctrlcliente extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String nome = "";
            int idcidade = 0;
            int idsexo = 0;
            
            nome = request.getParameter("txtnome");
            idcidade = Integer.parseInt(request.getParameter("cmbcidade"));
            idsexo = Integer.parseInt(request.getParameter("cmbsexo"));
            
            Cliente objcliente = new Cliente(nome, new Cidade(idcidade, ""), new Sexo(idsexo, ""));
            
            //aqui vai cadastrar o cliente
            //e vai colocar o id gerado no objcliente
            Clientedao objclientedao = new Clientedao();
            objclientedao.cadastrar(objcliente);
            
            
            HttpSession session = request.getSession();
            
            session.setAttribute("cliente", objcliente);
            
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/cadastros/cliente/msgcadsucesso.jsp");
            dispatcher.forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
