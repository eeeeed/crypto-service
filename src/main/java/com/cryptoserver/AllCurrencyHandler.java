package com.cryptoserver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.cryptoserver.models.CryptoPrice;
import com.cryptoserver.models.CryptoPrices;
import com.cryptoserver.models.Currency;
import com.cryptoserver.models.Symbol;
import com.cryptoserver.models.Ticker;
import com.cryptoserver.service.CurrencyService;
import com.cryptoserver.service.SymbolService;
import com.cryptoserver.service.TickerService;
import com.cryptoserver.service.impl.CurrencyServiceImpl;
import com.cryptoserver.service.impl.SymbolServiceImpl;
import com.cryptoserver.service.impl.TickerServiceImpl;

public class AllCurrencyHandler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

	private static final Logger LOG = LogManager.getLogger(AllCurrencyHandler.class);
	
	@Override
	public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
		LOG.info("received: {}", input);
		
		SymbolService symbolService = new SymbolServiceImpl();
		TickerService tickerService = new TickerServiceImpl();
		CurrencyService currencyService = new CurrencyServiceImpl();
		
		CryptoPrices returnCryptoPrices = new CryptoPrices();
		
		Collection<String> supportedSymbols = getSupportedSymbols();
		
		for (String currSymbol : supportedSymbols) {
			CryptoPrice cryptoPrice = null;
			Symbol symbol = symbolService.getSymbol(currSymbol);
			LOG.info("symbol: {}", symbol.toString());
			Ticker ticker = tickerService.getTicker(currSymbol);
			if (ticker != null) {
				LOG.info("ticker: {}", ticker.toString());
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
					returnCryptoPrices.getCurrencies().add(cryptoPrice);
				}
			}
		}
		
		return ApiGatewayResponse.builder()
				.setStatusCode(200)
				.setObjectBody(returnCryptoPrices)
				.build();
	}
	
    private Collection<String> getSupportedSymbols() {
        String supportedSymbols = System.getenv("SUPPORTED_SYMBOLS");
        Collection<String> supportedSymbolsList = new ArrayList<String>();
        if (supportedSymbols != null && !supportedSymbols.isEmpty()) {
            String [] tokens = supportedSymbols.split("\\,");
            supportedSymbolsList.addAll(Arrays.asList(tokens));
        }
        return supportedSymbolsList;
    }

}
