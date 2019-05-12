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
import modelo.Tipo;
import static utilidades.AES.decrypt;

/**
 *
 * @author alunocmc
 */
public class AlterarTipoAction implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Tipo tipo = new Tipo();

        tipo.setDescricao(request.getParameter("descricao"));
        
        String id = decrypt(request.getParameter("id"));
        
         if (id == null) {
                id = decrypt(URLDecoder.decode(request.getParameter("acao"), "UTF-8"));
            }

         tipo.setId(Integer.parseInt(id));
         
        TipoDao tipodao = new TipoDao();

        tipodao.alterar(tipo);

        return "/ControleTipo?acao=fRzggtDk94iqvfhCbUL%2Bxg%3D%3D";

    }

}
