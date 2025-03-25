package org.java.shop;

import java.math.BigDecimal;
import java.util.Scanner;

public class Carrello {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean isCompleto = false; 
        
        Prodotto[] carrello = new Prodotto[0];

        while (!isCompleto) {
            System.out.println("Inserire il tipo di prodotto da aggiungere al carrello fra smartphone, televisore e cuffie (oppure: s, t, c):");
            String risposta = scan.nextLine().toLowerCase();

            if (risposta != null && !risposta.isEmpty()) {
                Prodotto nuovoProdotto = null;

                if (risposta.equals("s") || risposta.equals("smartphone")) {
                    nuovoProdotto = new Smartphone(342535, "Xiaomi Note 7", "Xiaomi",
                            new BigDecimal("499.99"), new BigDecimal("0.22"), 128, 37625358);
                } 
                
                else if (risposta.equals("t") || risposta.equals("televisore")) {
                    nuovoProdotto = new Televisori(23453523, "Xiaomi smart tv 55'' 4K OLED", "Xiaomi",
                            new BigDecimal("1200"), new BigDecimal("0.22"), 55, true);
                } 
                
                else if (risposta.equals("c") || risposta.equals("cuffie")) {
                    nuovoProdotto = new Cuffie(242521, "Xiaomi Buds 3", "Xiaomi", new BigDecimal("25.99"),
                            new BigDecimal("0.22"), "nero", false);
                } 
                
                else {
                    System.out.println("La risposta inserita non è valida.\n");
                    continue;
                }

                carrello = aggiungiProdotto(carrello, nuovoProdotto);
                System.out.println("Hai aggiunto: " + nuovoProdotto.getNome() + "\n");

                // Controlliamo se il carrello è pieno
                if (carrello.length == 10) {
                    carrelloPieno();
                    isCompleto = true;
                }

                stampaCarrello(carrello);
            } else {
                System.out.println("Nessuna opzione selezionata.\n");
            }
        }

        scan.close();
    }

    public static Prodotto[] aggiungiProdotto(Prodotto[] carrello, Prodotto nuovoProdotto) {
        Prodotto[] nuovoCarrello = new Prodotto[carrello.length + 1];


        // for (int i = 0; i < carrello.length; i++) {
        //     nuovoCarrello[i] = carrello[i];
        // }

        System.arraycopy(carrello, 0, nuovoCarrello, 0, carrello.length);

        nuovoCarrello[carrello.length] = nuovoProdotto;

        return nuovoCarrello;
    }

    public static void carrelloPieno() {
        System.out.println("Il carrello è già pieno. 10/10\n");
    }

    public static void stampaCarrello(Prodotto[] carrello) {
        System.out.println("\n--- Contenuto del Carrello ---");
        if (carrello.length == 0) {
            System.out.println("Il carrello è vuoto.");
        } else {
            for (Prodotto prodotto : carrello) {
                System.out.println(prodotto); 
            }
        }
        System.out.println("-----------------------------\n");
    }
    
}
