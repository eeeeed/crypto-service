package com.cryptoserver.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ticker extends BaseModel {
	
	private String symbol;
    private String ask;
    private String bid;
    private String last;
    private String open;
    private String low;
    private String high;
    

	public String getSymbol() {
		return symbol;
	}



	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}



	public String getAsk() {
		return ask;
	}



	public void setAsk(String ask) {
		this.ask = ask;
	}



	public String getBid() {
		return bid;
	}



	public void setBid(String bid) {
		this.bid = bid;
	}



	public String getLast() {
		return last;
	}



	public void setLast(String last) {
		this.last = last;
	}



	public String getOpen() {
		return open;
	}



	public void setOpen(String open) {
		this.open = open;
	}



	public String getLow() {
		return low;
	}



	public void setLow(String low) {
		this.low = low;
	}



	public String getHigh() {
		return high;
	}



	public void setHigh(String high) {
		this.high = high;
	}



	@Override
	public String toString() {
		return super.toString(this);
	}

}
