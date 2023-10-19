package com.exchange.currency.service;

import com.exchange.currency.model.Currency;
import com.exchange.currency.repository.CurrencyRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    @Autowired
    private CurrencyRepository currencyRepository;
    @Override
    public Currency createOperation(Currency currency){
        return currencyRepository.save(currency);
    }
    @Override
    public Currency getOperationById(Long id){
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        return optionalCurrency.get();
    }
    @Override
    public List<Currency> getAll(){
        return currencyRepository.findAll();
    }
}
