/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgenum;

import modelo.Frete;
import java.util.Scanner;
import modelo.TipoFrete;

/**
 *
 * @author profe
 */
public class TesteEnum2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try (Scanner entrada = new Scanner(System.in)) {

            System.out.print("Informe a distância: ");

            int distancia = entrada.nextInt();

            System.out.print("Qual o tipo de frete (1) Normal, (2) Sedex: ");

            int opcaoFrete = entrada.nextInt();
            
            TipoFrete tipoFrete = TipoFrete.values()[opcaoFrete - 1];                    

            Frete frete = null;
            frete.setTipo(tipoFrete);
            frete = new Frete(distancia); 
            
            if (TipoFrete.Normal == tipoFrete) {
                               
                frete.calcularPreco();

            } else if (TipoFrete.Sedex == tipoFrete) {
    
                frete.calcularPreco();

            }

            System.out.printf("O valor total é de R$%.2f", frete.getValor());
            
        }

    }

}
