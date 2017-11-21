package com.creditsuisse.rest.model;

public class BaseRate {

	//	{"base":"EUR","date":"2017-11-17","rates":{"USD":1.1795}}
	
	private String base;
    private String date;
    //private String rates;
	private Rates rates;
	
    
    public String getBase() {
		return base;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	
	public Rates getRates() {
		return rates;
	}
	public void setRates(Rates rates) {
		this.rates = rates;
	}
	public void setBase(String base) {
		this.base = base;
	}
	@Override
	public String toString() {
		return "BaseRate [base=" + base + ", date=" + date + ", rates=" + rates + "]";
	}

	

	
	
	
	
}
