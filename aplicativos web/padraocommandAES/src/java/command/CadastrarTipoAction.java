/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import dao.TipoDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Tipo;

/**
 *
 * @author alunocmc
 */
public class CadastrarTipoAction implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Tipo tipo = new Tipo();

        tipo.setDescricao(request.getParameter("txtdescricao"));

        TipoDao tipodao = new TipoDao();

        tipodao.cadastrar(tipo);

        return "sucesso.jsp";
    }

}
