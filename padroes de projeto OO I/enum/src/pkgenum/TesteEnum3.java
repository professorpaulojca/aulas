/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgenum;

import java.util.Scanner;
import modelo.Frete;
import modelo.TipoFrete;

/**
 *
 * @author profe
 */
public class TesteEnum3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try (Scanner entrada = new Scanner(System.in)) {

            System.out.print("Informe a distância: ");

            int distancia = entrada.nextInt();

            System.out.print("Qual o tipo de frete (1) Normal, (2) Sedex: ");

            int opcaoFrete = entrada.nextInt();

            TipoFrete tipoFrete = TipoFrete.values()[opcaoFrete - 1];

            Frete frete = tipoFrete.obterFrete();

            frete.setDistancia(distancia);

            frete.calcularPreco();

            System.out.printf("O valor total é de R$%.2f", frete.getValor());

        }

    }

}
