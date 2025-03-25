package org.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Carrello {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean isCompleto = false;

        Prodotto[] carrello = new Prodotto[0];

        // Richiesta codice cliente
        System.out.println("Inserisci il codice cliente (lascia vuoto se non ne hai uno): ");
        String codiceCliente = scan.nextLine();
        boolean hasDiscount = CodiciCliente.isCodiceValido(codiceCliente); // Verifica se il codice è valido

        while (!isCompleto) {
            System.out.println(
                    "Inserire il tipo di prodotto da aggiungere al carrello fra smartphone, televisore e cuffie (oppure: s, t, c):");
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

                stampaCarrello(carrello, hasDiscount);
            } else {
                System.out.println("Nessuna opzione selezionata.\n");
            }
        }

        scan.close();
    }

    public static Prodotto[] aggiungiProdotto(Prodotto[] carrello, Prodotto nuovoProdotto) {
        Prodotto[] nuovoCarrello = new Prodotto[carrello.length + 1];

        System.arraycopy(carrello, 0, nuovoCarrello, 0, carrello.length);
        nuovoCarrello[carrello.length] = nuovoProdotto;

        return nuovoCarrello;
    }

    public static void carrelloPieno() {
        System.out.println("Il carrello è già pieno. 10/10\n");
    }

    public static void stampaCarrello(Prodotto[] carrello, boolean hasDiscount) {
        BigDecimal totale = BigDecimal.ZERO; // Variabile per il totale del carrello

        System.out.println("\n--- Contenuto del Carrello ---");
        if (carrello.length == 0) {
            System.out.println("Il carrello è vuoto.");
        } else {
            for (Prodotto prodotto : carrello) {
                // Prezzo base con IVA
                BigDecimal prezzoConIva = prodotto.getPrezzo();

                // Prezzo scontato (se applicabile)
                BigDecimal prezzoScontato = prezzoConIva;

                if (hasDiscount) {
                    prodotto.setDiscount();
                    prezzoScontato = prodotto.getPrezzo();
                }

                System.out.println(prodotto);
                System.out.println("Prezzo con IVA: " + prezzoConIva + " $");

                if (hasDiscount) {
                    System.out.println("Prezzo scontato con IVA: " + prezzoScontato + " $");
                }

                totale = totale.add(prezzoScontato);

                System.out.println("-----------------------------");
            }

            System.out.println("\nTotale Carrello: " + totale.setScale(2, RoundingMode.HALF_UP) + " $");

        }
        System.out.println();
    }

    class CodiciCliente {

        // Lista di codici cliente validi
        private static final List<String> codiciValidi = Arrays.asList("ABC123", "XYZ789", "DISCOUNT20");

        // Metodo per verificare se il codice inserito è valido
        public static boolean isCodiceValido(String codiceCliente) {
            return codiciValidi.contains(codiceCliente);
        }
    }

}
