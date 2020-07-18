/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author profe
 */
public class adptVisitaTecnica extends VisitaTecnica implements IDados{

    @Override
    public String getDados() {
       return getDestino();
    }

    public adptVisitaTecnica(String destino, String data, String interesse) {
        super(destino, data, interesse);
    }
    
}
