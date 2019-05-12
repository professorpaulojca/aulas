/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import modelo.Cliente;

/**
 *
 * @author alunocmc
 */
public interface IClientedao {

    public ArrayList<Cliente> listar(Cliente cliente);

    public void buscar(Cliente cliente);

    public boolean alterar(Cliente cliente);

    public boolean excluir(Cliente cliente);

    public boolean cadastrar(Cliente cliente);

}
