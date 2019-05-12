package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Calendar;
import modelo.Item;
import java.util.ArrayList;
import modelo.Pedido;

public final class listaItens_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" conten1:=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"css/estilo.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
        //
            Pedido pedido = (Pedido) request.getAttribute("pedido");
            Calendar cal = Calendar.getInstance();
            cal.setTime(pedido.getData());

            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(pedido.getHora());


        
      out.write("\n");
      out.write("\n");
      out.write("    <hl>Lista de Itens </hl>\n");
      out.write("        ");
        //recuperar a lista
            ArrayList<Item> listaItem = pedido.getItens();
        
      out.write("\n");
      out.write("    <table border=\"l\">\n");
      out.write("        <thead>\n");
      out.write("            <tr>\n");
      out.write("                <th>Pedido nº</th>\n");
      out.write("                <th>Data</th>\n");
      out.write("                <th>Hora</th>\n");
      out.write("                <th>Produto</th>\n");
      out.write("                <th>Foto</th>\n");
      out.write("                <th>Ferramentas</th>\n");
      out.write("\n");
      out.write("            </tr>\n");
      out.write("        </thead>\n");
      out.write("        <tbody>\n");
      out.write("            ");

                for (Item c : listaItem) {
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print( pedido.getId());
      out.write("</td>\n");
      out.write("                <td>");
      out.print( cal.get(Calendar.DAY_OF_MONTH) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR));
      out.write(" </td>\n");
      out.write("                <td>");
      out.print( cal2.get(Calendar.HOUR_OF_DAY) + ":" + cal2.get(Calendar.MINUTE) + ":" + cal2.get(Calendar.SECOND));
      out.write(" </td>\n");
      out.write("                <td>");
      out.print( c.getProduto().getNome());
      out.write(" </td>\n");
      out.write("                <td><img src=\"img/");
      out.print( c.getProduto().getFoto());
      out.write("\" width=\"50\"/> </td>\n");
      out.write("\n");
      out.write("                <td><a href=\"controlemovimento?iditem=");
      out.print( c.getId() );
      out.write("&idpedido=");
      out.print( pedido.getId() );
      out.write("\"><img src=\"img/baixar.png\" width=\"50\" alt=\"\"/></a></td>\n");
      out.write("\n");
      out.write("            </tr>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </tbody>\n");
      out.write("    </table>\n");
      out.write("</body>\n");
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
