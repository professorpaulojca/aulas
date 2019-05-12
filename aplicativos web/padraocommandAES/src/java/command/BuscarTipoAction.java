/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import dao.TipoDao;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Tipo;
import static utilidades.AES.decrypt;

/**
 *
 * @author alunocmc
 */
public class BuscarTipoAction implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
 
        Tipo tipo = new Tipo();
       
        TipoDao tipodao = new TipoDao();

       String id = decrypt(request.getParameter("id"));
        
         if (id == null) {
                id = decrypt(URLDecoder.decode(request.getParameter("id"), "UTF-8"));
            }

         tipo.setId(Integer.parseInt(id));
        
        tipodao.buscar(tipo);

        HttpSession session = request.getSession();

        session.setAttribute("tipo", tipo);
        
        return "/cadastros/tipo/alterar_tipo.jsp";
           
    }
    
}
