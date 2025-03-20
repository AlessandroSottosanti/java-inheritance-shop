package org.java.shop;

import java.math.BigDecimal;
import java.util.Random;

public class Prodotto {

    Random random = new Random();

    private int codice = random.nextInt(99999);
    private String nome;
    private String marca;
    private BigDecimal prezzo;
    private BigDecimal iva;
    
    public Prodotto(int codice, String nome, String marca, BigDecimal prezzo, BigDecimal iva) {
        this.codice = codice;
        this.nome = nome;
        this.marca = marca;
        this.prezzo = prezzo;
        this.iva = iva;
    }
    

    // getters

    public int getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public BigDecimal getIva() {
        return iva;
    }

    // setters

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }


}
