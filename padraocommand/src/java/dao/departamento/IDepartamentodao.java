/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.departamento;

import dao.departamento.*;
import java.util.ArrayList;
import modelo.Objeto;
import modelo.Departamento;

/**
 *
 * @author profe
 */
public interface IDepartamentodao {

    public ArrayList<Departamento> listar(Departamento departamento);

    public void buscar(Departamento departamento);

    public boolean alterar(Departamento departamento);

    public boolean excluir(Departamento departamento);
    
    public boolean cadastrar(Departamento departamento);

}
