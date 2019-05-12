/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio;

import java.util.Scanner;
import modelo.Calcular_ad;
import modelo.Formapag;
import modelo.TipoFormaPag;

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

            System.out.print("Informe o valor do pedido: ");

            int valor = entrada.nextInt();

            System.out.print("Qual a Forma de Pagamento (1) À Vista, (2) Crédito, (3) Débito, (4) Crediário ou (5) Boleto: ");

            int opcaofp = entrada.nextInt();

            TipoFormaPag TipoFormapag = TipoFormaPag.values()[opcaofp - 1];

            Formapag objformapag = TipoFormapag.obterFormapag();

            objformapag.setValor(valor);

            try {
                //faz a transformação para calcular o valor corrigido.
                Calcular_ad objcalc = (Calcular_ad) objformapag;

                objcalc.calcularacrescimooudebito();

                objformapag = (Formapag) objcalc;

                System.out.printf("O valor total corrigido é R$%.2f", objformapag.getValorcorrigido());

            } catch (Exception ex) {
                System.out.println("Forma de pagamento não permite correção!");
                System.out.printf("O valor total corrigido é R$%.2f", objformapag.getValor());

            }

        }

    }

}
