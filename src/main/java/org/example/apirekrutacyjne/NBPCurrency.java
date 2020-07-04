package org.example.apirekrutacyjne;

import java.util.Optional;

public enum NBPCurrency {
    AMERICAN_DOLAR("USD"),
    RUSSIAN_RUBE("RUB"),
    EURO("EUR");

    private String shortName;

    NBPCurrency(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }

    public static Optional<NBPCurrency> parse(String input){
        if (input.toUpperCase().contains("DOLAR")){
            System.out.println("Wybrana waluta: dolar");
            return Optional.of(NBPCurrency.AMERICAN_DOLAR);
        }else if (input.toUpperCase().contains("RUBEL")){
            System.out.println("Wybrana waluta: rubel");
            return Optional.of(NBPCurrency.RUSSIAN_RUBE);
        }else if (input.toUpperCase().contains("EURO")){
            System.out.println("Wybrana waluta: euro");
            return Optional.of(NBPCurrency.EURO);
        }
        return Optional.empty();
    }
}
