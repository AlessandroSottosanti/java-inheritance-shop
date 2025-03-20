package org.java.shop;

import java.math.BigDecimal;

public class Televisori extends Prodotto {

    private int pollici;
    private boolean isSmart;
    private String smart;

    public Televisori(int codice, String nome, String marca, BigDecimal prezzo, BigDecimal iva, int pollici, boolean isSmart) {
        super(codice, nome, marca, prezzo, iva);

        this.pollici = pollici;
        this.isSmart = isSmart;
        this.smart = isSmart? "Sì" : "No";

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
        System.out.println("Pollici: " + getPollici());
        System.out.println("Smart tv: " + smart);
    }

    public int getPollici() {
        return pollici;
    }

    public boolean getIsSmart() {
        return isSmart;
    }

    public void setPollici(int pollici) {
        this.pollici = pollici;
    }

    public void setSmart(boolean isSmart) {
        this.isSmart = isSmart;
    }
}
