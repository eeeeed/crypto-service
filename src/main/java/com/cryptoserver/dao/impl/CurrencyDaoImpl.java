package com.cryptoserver.dao.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.cryptoserver.dao.CurrencyDao;
import com.cryptoserver.models.Currency;
import com.cryptoserver.util.JsonUtil;

public class CurrencyDaoImpl implements CurrencyDao {

	@Override
	public Currency getCurrency(String currencyName) {
		
		if (currencyName == null || currencyName.isEmpty()) {
			return null;
		}
		
		Currency returnCurrency = null;
		try {
			String endpoint = "https://api.hitbtc.com/api/2/public/currency/" + currencyName;
			URL url = new URL(endpoint);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			System.out.println("GET Response Code: " + responseCode);

			if (responseCode == 200) {
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}

				String json = response.toString();
				
				returnCurrency = (Currency)JsonUtil.toObject(json, Currency.class);
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return returnCurrency;
	}

}
