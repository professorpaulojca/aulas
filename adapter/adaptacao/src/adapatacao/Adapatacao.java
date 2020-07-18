/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapatacao;
import java.util.ArrayList;
import modelo.*;

/**
 *
 * @author profe
 */
public class Adapatacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<IDados> arrdados = new ArrayList<>();
        
        adptEstagio estagio = new adptEstagio("Universidade X", "Monitor");
        adptVisitaTecnica visita = new adptVisitaTecnica("Aviário", "12/08", "Botanicos");
        adptPalestra palestra = new adptPalestra("Desafios do Tempo", "Joana", "14/09");
        adptPalestra palestra2 = new adptPalestra("Marketing Digital", "Silvia", "15/09");
        
        arrdados.add(estagio);
        arrdados.add(palestra);
        arrdados.add(visita);
        arrdados.add(palestra2);
      
        
        
        for (IDados dados : arrdados) {
            
            System.out.println("Evento:" + dados.getDados());
            
        }
        
    }
    
}
