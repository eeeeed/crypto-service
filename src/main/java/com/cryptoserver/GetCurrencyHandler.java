package com.cryptoserver;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.cryptoserver.models.CryptoPrice;
import com.cryptoserver.models.Currency;
import com.cryptoserver.models.Symbol;
import com.cryptoserver.models.Ticker;
import com.cryptoserver.service.CurrencyService;
import com.cryptoserver.service.SymbolService;
import com.cryptoserver.service.TickerService;
import com.cryptoserver.service.impl.CurrencyServiceImpl;
import com.cryptoserver.service.impl.SymbolServiceImpl;
import com.cryptoserver.service.impl.TickerServiceImpl;

public class GetCurrencyHandler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

	private static final Logger LOG = LogManager.getLogger(AllCurrencyHandler.class);

	@Override
	public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
		LOG.info("received: {}", input);
		
		SymbolService symbolService = new SymbolServiceImpl();
		
		Map<String, String> pathParam = (Map<String, String>)input.get("pathParameters");
		String symbolParam = pathParam.get("symbol");
		
		Symbol symbol = symbolService.getSymbol(symbolParam);
		
		CryptoPrice cryptoPrice = null;
		if (symbol != null) {
			LOG.info("symbol: {}", symbol.toString());
			TickerService tickerService = new TickerServiceImpl();
			Ticker ticker = tickerService.getTicker(symbolParam);
			if (ticker != null) {
				LOG.info("ticker: {}", ticker.toString());
				CurrencyService currencyService = new CurrencyServiceImpl();
				Currency currency = currencyService.getCurrency(symbol.getBaseCurrency());
				if (currency != null) {
					LOG.info("currency: {}", currency.toString());
					cryptoPrice = new CryptoPrice();
					cryptoPrice.setId(symbol.getBaseCurrency());
					cryptoPrice.setFullName(currency.getFullName());
					cryptoPrice.setAsk(ticker.getAsk());
					cryptoPrice.setBid(ticker.getBid());
					cryptoPrice.setLast(ticker.getLast());
					cryptoPrice.setOpen(ticker.getOpen());
					cryptoPrice.setLow(ticker.getLow());
					cryptoPrice.setHigh(ticker.getHigh());
					cryptoPrice.setFeeCurrency(symbol.getFeeCurrency());
					LOG.info("cryptoPrice: {}", cryptoPrice);
				}
			}
		}
		
		if (cryptoPrice == null) {
			return ApiGatewayResponse.builder()
					.setStatusCode(404)
					.setObjectBody("Symbol [" + symbolParam + "] not found")
					.build();
		}
		
		return ApiGatewayResponse.builder()
				.setStatusCode(200)
				.setObjectBody(cryptoPrice)
				.build();
	}
}
