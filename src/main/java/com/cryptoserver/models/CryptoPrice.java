package com.cryptoserver.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CryptoPrice extends BaseModel  {
	
	private String id;
    private String fullName;
    private String ask;
    private String bid;
    private String last;
    private String open;
    private String low;
    private String high;
    private String feeCurrency;

    
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getFullName() {
		return fullName;
	}



	public void setFullName(String fullName) {
		this.fullName = fullName;
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



	public String getFeeCurrency() {
		return feeCurrency;
	}



	public void setFeeCurrency(String feeCurrency) {
		this.feeCurrency = feeCurrency;
	}



	@Override
	public String toString() {
		return super.toString(this);
	}

}
