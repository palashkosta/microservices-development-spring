package com.learning.microservices.currencyconversionservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy;
    
    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, 
        @PathVariable String to, 
        @PathVariable BigDecimal quantity) {

        CurrencyConversion conversion = currencyExchangeProxy.retrieveExcahngeValue(from, to);
        conversion.setQuantity(quantity);
        conversion.setTotalCalculatedAmount(quantity.multiply(conversion.getConversionMultiple()));

        return conversion;

    }

}
