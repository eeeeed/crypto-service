package com.cryptoserver.service;

import com.cryptoserver.models.Currency;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public interface CurrencyService {

	public Currency getCurrency(String currencyName);
}
