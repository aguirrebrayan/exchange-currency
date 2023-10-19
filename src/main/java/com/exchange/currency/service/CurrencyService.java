package com.exchange.currency.service;

import com.exchange.currency.model.Currency;
import java.util.List;
public interface CurrencyService {
    Currency createOperation(Currency currency);
    Currency getOperationById(Long id);
    List<Currency> getAll();
}
