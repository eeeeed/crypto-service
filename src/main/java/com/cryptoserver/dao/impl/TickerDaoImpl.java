package com.cryptoserver.dao.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.cryptoserver.dao.TickerDao;
import com.cryptoserver.models.Ticker;
import com.cryptoserver.util.JsonUtil;

public class TickerDaoImpl implements TickerDao {

	@Override
	public Ticker getTicker(String tickerName) {
		
		if (tickerName == null || tickerName.isEmpty()) {
			return null;
		}
		
		Ticker returnTicker = null;
		try {
			String endpoint = "https://api.hitbtc.com/api/2/public/ticker/" + tickerName;
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
				
				returnTicker = (Ticker)JsonUtil.toObject(json, Ticker.class);
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return returnTicker;
	}

}
