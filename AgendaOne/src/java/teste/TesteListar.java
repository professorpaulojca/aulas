
package teste;

import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Servico;
import modelo.DAO.ServicoDAO;



public class TesteListar {
    public static void main(String [] args) throws SQLException, ClassNotFoundException { 

    ServicoDAO cdao = new ServicoDAO();
    ArrayList<Servico> listaCliente =  cdao.listar ();

        for(Servico c : listaCliente){     
           System.out.println(c.getNome()); 
           //System.out.println(c.getCpf());
        }

    }

}
