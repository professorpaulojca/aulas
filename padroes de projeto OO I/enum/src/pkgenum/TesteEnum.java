/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgenum;

import modelo.Frete;
import java.util.Scanner;

/**
 *
 * @author profe
 */
public class TesteEnum {

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

            Frete frete = null;
            
            if (opcaoFrete == 1) {

                frete = new Frete(distancia);
                frete.setTipo("Normal");
                frete.calcularPreco();

            } else if (opcaoFrete == 2) {

                frete = new Frete(distancia);
                frete.setTipo("Sedex");
                frete.calcularPreco();

            }

            System.out.printf("O valor total é de R$%.2f", frete.getValor());
            
        }

    }

}
