package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import modelo.Agendamento;

public final class listaAgendamento_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" conten1:=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"css/estilo.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("<body>\n");
      out.write("    <hl>Lista de Agendamentos</hl>\n");
      out.write("    ");
        //recuperar a lista
        ArrayList<Agendamento> listaAgendamento = (ArrayList<Agendamento>) request.getAttribute("listaAgendamento");
    
      out.write("\n");
      out.write("    <table border=\"l\">\n");
      out.write("    <thead>\n");
      out.write("        <tr>\n");
      out.write("            <th>ID</th>\n");
      out.write("            <th>Nome</th>\n");
      out.write("            <th>Telefone</th>            \n");
      out.write("            <th>Data e Hora</th>\n");
      out.write("            <th>Tipo de Serviço</th>\n");
      out.write("            <th>Ferramentas</th>\n");
      out.write("            \n");
      out.write("        </tr>\n");
      out.write("    </thead>\n");
      out.write("    <tbody>\n");
      out.write("    ");

        for(Agendamento c : listaAgendamento ){
    
      out.write("\n");
      out.write("    <tr>\n");
      out.write("        <td>");
      out.print( c.getId() );
      out.write("</td>\n");
      out.write("        <td>");
      out.print( c.getCliente().getNome() );
      out.write("</td>\n");
      out.write("        <td>");
      out.print( c.getCliente().getTelefone());
      out.write("</td>\n");
      out.write("        <td>");
      out.print( c.getData().toString() + " " + c.getHora().toString() );
      out.write(" </td>\n");
      out.write("        <td>");
      out.print( c.getServico().getNome() );
      out.write(" </td>\n");
      out.write("        \n");
      out.write("        <td><a href=\"ControleAgendamento?acao=excluir&id=");
      out.print( c.getId() );
      out.write("\"><img src=\"img/excluir.png\" alt=\"\"/></a><a href=\"ControleAgandamento?acao=alterar&id=");
      out.print( c.getId() );
      out.write("\"><img src=\"img/editar.png\" alt=\"\"/></a></td>\n");
      out.write("            \n");
      out.write("    </tr>\n");
      out.write("     ");

         }
    
      out.write("\n");
      out.write("    </tbody>\n");
      out.write("        </table>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
