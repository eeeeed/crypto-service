package com.cryptoserver.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Symbol extends BaseModel {
	
	private String id;
    private String baseCurrency;
    private String feeCurrency;
    

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getBaseCurrency() {
		return baseCurrency;
	}



	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
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
