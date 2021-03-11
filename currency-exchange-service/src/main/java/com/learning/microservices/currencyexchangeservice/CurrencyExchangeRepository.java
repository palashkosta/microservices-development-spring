package com.learning.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExcahnge, Long> {
    CurrencyExcahnge findByFromAndTo(String from, String to);
}
