/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Agendamento;
import modelo.Cliente;
import modelo.DAO.AgendamentoDAO;
import modelo.DAO.ClienteDAO;
import modelo.DAO.ServicoDAO;
import modelo.Servico;

/**
 *
 * @author user
 */
@WebServlet(name = "controleAgendamento", urlPatterns = {"/controleAgendamento"})
public class controleAgendamento extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            String acao = request.getParameter("acao");
            if (acao.equals("Listar")) {
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                Date data = formato.parse(request.getParameter("txtdata"));

                Agendamento agendamento = new Agendamento();
                agendamento.setData(data);

                AgendamentoDAO agdao = new AgendamentoDAO();
                ArrayList<Agendamento> arragendamentos = new ArrayList<>();
                arragendamentos = agdao.listar(agendamento);

                request.setAttribute("listaAgendamentos", arragendamentos);
                //encaminha o request para o J SP
                RequestDispatcher rd = request.getRequestDispatcher("listaAgendamento.jsp");
                rd.forward(request, response);

            } else if (acao.equals("Agendar")) {

                //cria objeto
                ClienteDAO cDAO = new ClienteDAO();
                //executa o método listar
                ArrayList<Cliente> clientes = cDAO.listar();
                //add a lista no obJ eto request   
                request.setAttribute("listaCliente", clientes);

                ServicoDAO sDAO = new ServicoDAO();
                //executa o método listar
                ArrayList<Servico> servicos = sDAO.listar();
                //add a lista no obJ eto request   
                request.setAttribute("listaServico", servicos);

                //encaminha o request para o J SP
                RequestDispatcher rd = request.getRequestDispatcher("cadagendamento.jsp");
                rd.forward(request, response);

            } else if (acao.equals("Confirmar")) {

                int cliente = Integer.parseInt(request.getParameter("cmbCliente"));
                int servico = Integer.parseInt(request.getParameter("cmbServico"));

                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat formatoh = new SimpleDateFormat("HH:mm:ss");

                Date data = formato.parse(request.getParameter("txtData"));

                Time hora = new Time(formatoh.parse(request.getParameter("txtHora")).getTime());

                Date dataf = formato.parse(request.getParameter("txtDatafinal"));
                Time horaf = new Time(formatoh.parse(request.getParameter("txtHorafinal")).getTime());

                //criei aqui p tentar recuperar o valor do servico p salvar no agendamento
                Servico serv = new Servico(servico);
                serv.setId(servico);
                ServicoDAO sdao = new ServicoDAO();
                sdao.buscar(serv);
                Double valor = serv.getValor();

                Agendamento agendamento = new Agendamento();
                agendamento.setValor(valor);
                agendamento.setCliente(new Cliente(cliente));
                agendamento.setServico(new Servico(servico));
                agendamento.setData(data);
                agendamento.setHora(hora);
                agendamento.setDatafinal(dataf);
                agendamento.setHorafinal(horaf);

                AgendamentoDAO cdao = new AgendamentoDAO();

                if (!cdao.validar(agendamento)) {

                    cdao.cadastrar(agendamento);
                    //redireciono
                    request.setAttribute("mensagem", " efetuado com sucesso!");
                    RequestDispatcher rd = request.getRequestDispatcher("sucessoAgendamento.jsp");
                    rd.forward(request, response);

                } else {

                    request.setAttribute("mensagem", " Já Existe um agendamento para este horário");
                    RequestDispatcher rd = request.getRequestDispatcher("erroAgendamento.jsp");
                    rd.forward(request, response);
                }

            } else if (acao.equals("excluir")) {

                int id = Integer.parseInt(request.getParameter("id"));

                Agendamento agend = new Agendamento();
                agend.setId(id);

                AgendamentoDAO agdao = new AgendamentoDAO();

                agdao.excluir(agend);
                //redireciono
                request.setAttribute("mensagem", " excluido com sucesso!");
                RequestDispatcher rd = request.getRequestDispatcher("sucessoAgendamento.jsp");
                rd.forward(request, response);

            }
        } catch (ParseException ex) {
            Logger.getLogger(controleAgendamento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(controleAgendamento.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (Exception ex) {

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
        } catch (Exception ex) {
            Logger.getLogger(controleAgendamento.class.getName()).log(Level.SEVERE, null, ex);
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
