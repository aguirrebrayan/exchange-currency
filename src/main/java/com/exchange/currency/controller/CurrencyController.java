package com.exchange.currency.controller;

import com.exchange.currency.model.Currency;
import com.exchange.currency.service.CurrencyService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/exchange")
@RequiredArgsConstructor
public class CurrencyController {

        @Autowired
        CurrencyService currencyService;
        @PostMapping()
        ResponseEntity calculateAmount(@RequestParam("amount") double amount,
                                              @RequestParam("origen") String origen,
                                              @RequestParam("destino") String destino,
                                              @RequestParam("tipoDeCambio") double tipoDeCambio){
                Currency currency = new Currency();
                currency.setAmount(amount);
                currency.setOrigen(origen);
                currency.setDestino(destino);
                currency.setTipoDeCambio(tipoDeCambio);
                currency.setAmountWithExchange(tipoDeCambio*amount);
                currencyService.createOperation(currency);
                return new ResponseEntity(currencyService.createOperation(currency), HttpStatus.CREATED);
        }
        @GetMapping()
        ResponseEntity getAll(){
                return new ResponseEntity(currencyService.getAll(), HttpStatus.OK);
        }
}
