/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.ArrayList;
import modelos.Movimentodedatas;

/**
 *
 * @author profe
 */
public interface IMovimentoDao {
    
   
    public ArrayList<Movimentodedatas> listar(Movimentodedatas movimentodedatas);
    public boolean cadastrar(Movimentodedatas movimentodedatas);
    public void buscar(Movimentodedatas movimentodedatas);
}
