package org.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();

        System.out.println("");
        
        // creazione Smartphone

        Smartphone samsungSmartphone = new Smartphone(random.nextInt(99999), "Galaxy S25", "Samsung", new BigDecimal(799.99).setScale(2, RoundingMode.DOWN), new BigDecimal(0.22).setScale(2, RoundingMode.DOWN), 256, random.nextInt(99999999));
        
        System.out.println("Smartphone Samsung:");
        
        samsungSmartphone.stampaDati();


        System.out.println("");

        // creazione TV 

        Televisori hisenseTv = new Televisori(random.nextInt(99999), "Hisense 65'' 4K QLED", "Hisense", new BigDecimal(650.00).setScale(2, RoundingMode.DOWN), new BigDecimal(0.22).setScale(2, RoundingMode.DOWN), 65, true);

        System.out.println("TV Hisense: ");
        hisenseTv.stampaDati();


        System.out.println("");

        // creazione cuffie

        Cuffie airPods = new Cuffie(random.nextInt(99999), "airPods 3", "Apple", new BigDecimal(169.99).setScale(2, RoundingMode.DOWN), new BigDecimal(0.22).setScale(2, RoundingMode.DOWN), "Bianco", false);
        System.out.println("AirPods 3: ");
        airPods.stampaDati();

        System.out.println("");

    }
}
