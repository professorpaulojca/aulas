
package teste;

import java.sql.SQLException;
import modelo.Servico;
import modelo.DAO.ServicoDAO;


public class CadastrarCliente {
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
    
    Servico cliente = new Servico();
    cliente.setNome("fabio da Silva");
    //cliente.setCpf("555-555-555-55");
    //cliente.setTelefone("852-8543");
    cliente.setSituacao(1);
    
    ServicoDAO servicoDAO= new ServicoDAO();
    servicoDAO.cadastrar(cliente);
    System.out.println("Cadastrao com sucesso!!!");
    }
}
