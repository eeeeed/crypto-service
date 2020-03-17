package com.cryptoserver.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CryptoPrices extends BaseModel {
	
	private List<CryptoPrice> currencies;

	
	
	public List<CryptoPrice> getCurrencies() {
		if (currencies == null) {
			currencies = new ArrayList<CryptoPrice>();
		}
		return currencies;
	}

	@Override
	public String toString() {
		return super.toString(this);
	}

}
