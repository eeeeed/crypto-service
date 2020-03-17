package com.cryptoserver.dao;

import com.cryptoserver.models.Ticker;

public interface TickerDao {

	public Ticker getTicker(String tickerName);
}
