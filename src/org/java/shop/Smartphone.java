package org.java.shop;

import java.math.BigDecimal;

public class Smartphone extends Prodotto {

    private int codiceIMEI;
    private int memoria;

    public Smartphone(int codice, String nome, String marca, BigDecimal prezzo, BigDecimal iva, int memoria, int codiceIMEI) {
        super(codice, nome, marca, prezzo, iva);

        this.memoria = memoria;
        this.codiceIMEI = codiceIMEI;
        
    }
    
    // metodo per aggiornare le variabili d'istanza della super classe "Prodotto" usando i suoi setter
    public void aggiornaDati(int codice, String nome, String marca, BigDecimal prezzo, BigDecimal iva) {
        setNome(nome);
        setMarca(marca);
        setPrezzo(prezzo);
        setIva(iva);
    }

    public void stampaDati() {
        System.out.println("Codice Prodotto: " + getCodice());
        System.out.println("Nome: " + getNome());
        System.out.println("Marca: " + getMarca());
        System.out.println("Prezzo: " + getPrezzo() + "$");
        System.out.println("IVA: " + ( getIva().multiply(new BigDecimal(100))) + "%");
        System.out.println("Memoria: " + getMemoria() + "GB");
        System.out.println("Codice IMEI: " + getCodiceIMEI());
    }

    public int getMemoria() {
        return memoria;
    }

    public int getCodiceIMEI() {
        return codiceIMEI;
    }

    public void setCodiceIMEI(int codiceIMEI) {
        this.codiceIMEI = codiceIMEI;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }
}
