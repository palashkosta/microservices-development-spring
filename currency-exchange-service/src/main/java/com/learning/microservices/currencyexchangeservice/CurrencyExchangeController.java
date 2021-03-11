package com.learning.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @Autowired
    private Environment environment;
    
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExcahnge retrieveExcahngeValue(
        @PathVariable String from, 
        @PathVariable String to) {

            // CurrencyExcahnge currencyExcahnge = new CurrencyExcahnge(1000L, from, to, BigDecimal.valueOf(50));
            CurrencyExcahnge currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);
            String port = environment.getProperty("local.server.port");
            currencyExchange.setEnvironment(port);
            return currencyExchange;

    }

}
