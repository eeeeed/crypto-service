package com.cryptoserver.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Currency extends BaseModel {

	
	private String id;
    private String fullName;
    
    
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



	@Override
	public String toString() {
		return super.toString(this);
	}

}
