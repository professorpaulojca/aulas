/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import dao.TipoDao;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Tipo;

/**
 *
 * @author alunocmc
 */
public class ListarTipoAction implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ArrayList<Tipo> arr = new ArrayList<Tipo>();

        Tipo tipo = new Tipo();

        tipo.setDescricao("");
        
        TipoDao tipoDao = new TipoDao();

        arr = tipoDao.listar(tipo);

        HttpSession session = request.getSession();

        session.setAttribute("arrtipo", arr);

        return "/cadastros/tipo/lista_tipo.jsp";

    }

}
