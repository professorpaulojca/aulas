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
public class adptPalestra extends Palestra implements IDados{

    @Override
    public String getDados() {
        return this.getAssunto();
    }

    public adptPalestra(String assunto, String palestrante, String data) {
        super(assunto, palestrante, data);
    }    
    
}
