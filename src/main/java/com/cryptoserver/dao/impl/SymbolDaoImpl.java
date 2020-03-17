package com.cryptoserver.dao.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.cryptoserver.dao.SymbolDao;
import com.cryptoserver.models.Symbol;
import com.cryptoserver.util.JsonUtil;

public class SymbolDaoImpl implements SymbolDao {

	@Override
	public Symbol getSymbol(String symbolName) {

		if (symbolName == null || symbolName.isEmpty()) {
			return null;
		}
		
		Symbol returnSymbol = null;
		try {
			String endpoint = "https://api.hitbtc.com/api/2/public/symbol/" + symbolName;
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
				
				returnSymbol = (Symbol)JsonUtil.toObject(json, Symbol.class);
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return returnSymbol;
	}

}
