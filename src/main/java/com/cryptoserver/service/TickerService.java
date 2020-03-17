package com.cryptoserver.service;

import com.cryptoserver.models.Ticker;

public interface TickerService {

	public Ticker getTicker(String tickerName);
}
