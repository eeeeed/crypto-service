package com.cryptoserver.service.impl;

import com.cryptoserver.dao.TickerDao;
import com.cryptoserver.dao.impl.TickerDaoImpl;
import com.cryptoserver.models.Ticker;
import com.cryptoserver.service.TickerService;

public class TickerServiceImpl implements TickerService {

	
	private TickerDao tickerDao = null;

	@Override
	public Ticker getTicker(String tickerName) {
		return getTickerDao().getTicker(tickerName);
	}
	
	private TickerDao getTickerDao() {
		if (tickerDao == null) {
			tickerDao = new TickerDaoImpl();
		}
		return tickerDao;
	}

}
