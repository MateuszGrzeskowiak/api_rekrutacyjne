package org.example.apirekrutacyjne;

import lombok.Data;

import java.util.List;

@Data
public class ExchangeRates {
private String table;
private String currency;
private String code;
private List<Rate> rates;
}
