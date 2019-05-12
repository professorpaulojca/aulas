/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appjson;

import com.google.gson.Gson;
import java.util.ArrayList;
import modelo.*;

/**
 *
 * @author paulojca
 */
public class Appjson {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Modelo modelo1 = new Modelo(1, "Celta");
        Modelo modelo2 = new Modelo(2, "Opala");
        
        Carro carro1 = new Carro(1,modelo1,"CDS-1233");
        Carro carro2 = new Carro(2,modelo2,"ADS-1015");
        
        ArrayList<Carro> carros = new ArrayList<>();
        
        carros.add(carro1);
        carros.add(carro2);
        
        Gson objgson = new Gson();
        
        System.out.println(objgson.toJson(carros));
        
        
    }
    
}
