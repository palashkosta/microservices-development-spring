package com.learning.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @Autowired
    private Environment environment;
    
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExcahnge retrieveExcahngeValue(
        @PathVariable String from, 
        @PathVariable String to) {

            logger.info("retrieve exchange value - called with {} to {}", from , to);

            // CurrencyExcahnge currencyExcahnge = new CurrencyExcahnge(1000L, from, to, BigDecimal.valueOf(50));
            CurrencyExcahnge currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);
            String port = environment.getProperty("local.server.port");
            currencyExchange.setEnvironment(port);
            return currencyExchange;

    }

}
