package org.java.shop;

import java.math.BigDecimal;
import java.util.Scanner;

public class Carrello {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        
        System.out.println("Inserire il tipo di prodotto da aggiungere al carrello fra smartphone, televisore e cuffie ( oppure: s, t, c):");
        String risposta = scan.nextLine().toLowerCase();

        if (risposta != null ) {


            if (risposta.equals("s") || risposta.equals("smartphone")) {
                Smartphone xiaomiSmartphone = new Smartphone(342535, "Xiaomi Note 7", "Xiaomi", new BigDecimal(499.99), new BigDecimal(0.22), 128, 37625358);

                System.out.println("hai aggiunto uno smartphone " + xiaomiSmartphone.getNome());
            }

            else if (risposta.equals("t") || risposta.equals("televisore")) {
                Televisori xiaomTelevisori = new Televisori(23453523, "Xiaomi smart tv 55'' 4k OLED", "Xiaomi", new BigDecimal(1200), new BigDecimal(0.22), 55, true);
                System.out.println("hai aggiunto un televisore " + xiaomTelevisori.getNome());
            }

            else if (risposta.equals("c") || risposta.equals("cuffie")) {
                Cuffie xiaomCuffie = new Cuffie(242521, "Xiaomi Buds 3", "Xiaomi", new BigDecimal(25.99), new BigDecimal(0.22), "nero",  false);
                System.out.println("hai aggiunto delle cuffie " + xiaomCuffie.getNome());

            }

            else {
                System.out.println("La risposta inserita non è valida");
            }
        }

        else {
            System.out.println("Nessuna opzione selezionata.");
        }
    }
}
