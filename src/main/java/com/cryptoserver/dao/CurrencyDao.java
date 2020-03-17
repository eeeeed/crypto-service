package com.cryptoserver.dao;

import com.cryptoserver.models.Currency;

public interface CurrencyDao {
	
	public Currency getCurrency(String currencyName);

}
