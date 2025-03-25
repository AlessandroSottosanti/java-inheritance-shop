package org.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Prodotto {

    Random random = new Random();

    private int codice = random.nextInt(99999);
    private String nome;
    private String marca;
    private BigDecimal prezzoBase;  // Prezzo senza IVA
    private BigDecimal iva;
    
    public Prodotto(int codice, String nome, String marca, BigDecimal prezzoBase, BigDecimal iva) {
        this.codice = codice;
        this.nome = nome;
        this.marca = marca;
        this.prezzoBase = prezzoBase;
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

    // Ritorna il prezzo base (senza IVA)
    public BigDecimal getPrezzoBase() {
        return prezzoBase;
    }

    // Metodo per ottenere il prezzo finale con IVA
    public BigDecimal getPrezzo() {
        return prezzoBase.add(prezzoBase.multiply(this.iva)).setScale(2, RoundingMode.HALF_UP);
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

    public void setPrezzoBase(BigDecimal prezzoBase) {
        this.prezzoBase = prezzoBase;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    // Metodo per applicare lo sconto
    public void setDiscount() {
        BigDecimal discount = new BigDecimal(0.02); // Sconto di base del 2%
    
        if (this instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) this;
            if (smartphone.getMemoria() < 32) {
                // Se ha meno di 32GB di memoria, sconto del 5%
                discount = new BigDecimal(0.05);
            }
            BigDecimal prezzoScontato = calculateDiscount(smartphone.getPrezzoBase(), discount);
            setPrezzoBase(prezzoScontato);  
        } 
        else if (this instanceof Televisori) {
            Televisori televisore = (Televisori) this;
            if (!televisore.getIsSmart()) {
                // Se non è smart, sconto del 10%
                discount = new BigDecimal(0.1);
            }
            BigDecimal prezzoScontato = calculateDiscount(televisore.getPrezzoBase(), discount);
            setPrezzoBase(prezzoScontato);  
        }
        else if (this instanceof Cuffie) {
            Cuffie cuffie = (Cuffie) this;
            if (cuffie.getCablate()) {
                // Se sono cablate, sconto del 7%
                discount = new BigDecimal(0.07);
            }
            BigDecimal prezzoScontato = calculateDiscount(cuffie.getPrezzoBase(), discount);
            setPrezzoBase(prezzoScontato);  
        }
    }
    
    // Metodo per calcolare il prezzo scontato (sul prezzo base)
    public BigDecimal calculateDiscount (BigDecimal prezzoBase, BigDecimal discount) {
        return prezzoBase.subtract(prezzoBase.multiply(discount));
    }
}
