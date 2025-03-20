package org.java.shop;

import java.math.BigDecimal;

public class Cuffie extends Prodotto {

    private String colore;
    private boolean cablate;
    private String collegamento; 


    public Cuffie(int codice, String nome, String marca, BigDecimal prezzo, BigDecimal iva, String colore, boolean cablate) {
        super(codice, nome, marca, prezzo, iva);

        this.colore = colore;
        this.cablate = cablate;
        this.collegamento = cablate? "Cablate" : "Wireless";
    }

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
        System.out.println("Colore: " + getColore());
        System.out.println("collegamento: " + this.collegamento);
    }

    public String getColore() {
        return colore;
    }

    public boolean getCablate() {
        return cablate;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public void setCablate(boolean cablate) {
        this.cablate = cablate;
    }
}
