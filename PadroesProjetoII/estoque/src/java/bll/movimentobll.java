/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import fachada.MovimentaFacade;

/**
 *
 * @author paulojca
 */
public class movimentobll {

    public boolean baixar(int idpedido, int iditempedido) {

        try {

            MovimentaFacade fachada = new MovimentaFacade();

            fachada.Inicializar(idpedido, iditempedido);

            fachada.montarPedido();

            fachada.montarHistorico();
            
            fachada.montarMovimento();
            
            fachada.montarProduto();
            
            return true;

        } catch (Exception ex) {

            return false;

        }
    }

}
