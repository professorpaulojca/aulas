/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.usuario;

import command.ICommand;
import dao.UsuarioDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;
import utilidades.Md5;

/**
 *
 * @author alunocmc
 */
public class LoginUsuarioAction implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {

        if (request.getParameter("txtemail") != null && request.getParameter("txtsenha") != null) {

            Usuario usuario = new Usuario();

            UsuarioDao usuariodao = new UsuarioDao();

            usuario.setId(Integer.parseInt(request.getParameter("id")));

            usuariodao.login(usuario);

            HttpSession session = request.getSession();

            //aqui tem um segredo pois o usuario pode ter feito um sql injection
            if (usuario.getEmail().equals(request.getParameter("txtemail")) && usuario.getSenha().equals(Md5.senhamd5(request.getParameter("senha")))) {

                //como já encontrou o usuario podemos deixar a senha em branco
                //nós não queremos que ningué veja nem mesmo o hash da senha
                usuario.setSenha("");
                //colocamos o usuario na session
                session.setAttribute("usuario", usuario);

                return "/principal.jsp";
                
            } else {

                return "/login.jsp";
            }

        } else {

            return "/login.jsp";

        }

    }

}
