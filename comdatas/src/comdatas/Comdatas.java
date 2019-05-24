/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comdatas;

import daos.MovimentoDao;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import modelos.Movimentodedatas;

/**
 *
 * @author profe
 */
public class Comdatas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ///atribuir valores ao objeto
        Movimentodedatas objmovimentodedatas = new Movimentodedatas();
        
        //pega a data e hora atual do sistema
        java.util.Date hoje = new java.util.Date();
        
        //pega a hora atual do sitema
        Time hora = new Time(hoje.getTime());
        
        objmovimentodedatas.setSomentedata(new java.sql.Timestamp(hoje.getTime()));
        objmovimentodedatas.setSomentehora(hora);
        objmovimentodedatas.setDataehorajuntos(hoje);
        
        MovimentoDao movimentodao = new MovimentoDao();
        movimentodao.cadastrar(objmovimentodedatas);
        
        ///////////////////////////////////////////////////////////////////////
        
        ArrayList<Movimentodedatas> arr = new ArrayList<Movimentodedatas>();
        arr = movimentodao.listar(objmovimentodedatas);
        
        for (Movimentodedatas obj : arr) {
            
            System.out.println("Data:" + obj.getSomentedata());
            System.out.println("Hora:" + obj.getSomentehora());
            System.out.println("Data e Hora Juntos:" + obj.getDataehorajuntos());
            
            //diferença
            long diferenca = hoje.getTime() - obj.getDataehorajuntos().getTime();
            long diferencaemminutos = diferenca / (60 * 1000); 
            long diferencaemhoras = diferenca / (60 * 60 * 1000); 
            
            
            System.out.println("Difereça em minutos:" + diferencaemminutos);
            System.out.println("Difereça em horas:" + diferencaemhoras);
            
            
        }
        
        //////////////////////////////////////////////////////////////////////
       
        
        
    }
    
}
