/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padraodao;

import dao.TipoDao;
import java.util.ArrayList;
import modelo.*;

/**
 *
 * @author profe
 */
public class ListarControle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<Tipo> arr = new ArrayList<>();

        Tipo tipo = new Tipo();

        tipo.setDescricao("b");

        TipoDao tipoDao = new TipoDao();

        arr = tipoDao.listar(tipo);

        for (Tipo obj : arr) {

            System.out.println("ID:" + obj.getId());
            System.out.println("Descrição:" + obj.getDescricao());

        }

    }

}
