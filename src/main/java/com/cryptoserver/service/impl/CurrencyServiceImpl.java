package com.cryptoserver.service.impl;

import com.cryptoserver.dao.CurrencyDao;
import com.cryptoserver.dao.impl.CurrencyDaoImpl;
import com.cryptoserver.models.Currency;
import com.cryptoserver.service.CurrencyService;

public class CurrencyServiceImpl implements CurrencyService {
	
	private CurrencyDao currencyDao = null;

	@Override
	public Currency getCurrency(String currencyName) {
		return getCurrencyDao().getCurrency(currencyName);
	}
	
	private CurrencyDao getCurrencyDao() {
		if (currencyDao == null) {
			currencyDao = new CurrencyDaoImpl();
		}
		return currencyDao;
	}

}
