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
public class VisitaTecnica {

    private String destino;
    private String data;
    private String interesse;

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getInteresse() {
        return interesse;
    }

    public void setInteresse(String interesse) {
        this.interesse = interesse;
    }

    public VisitaTecnica(String destino, String data, String interesse) {
        this.destino = destino;
        this.data = data;
        this.interesse = interesse;
    }

    public VisitaTecnica() {
    }
}





