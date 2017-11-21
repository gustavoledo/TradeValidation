package com.creditsuisse.rest.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;

import com.creditsuisse.rest.exceptions.BussinesException;
import com.creditsuisse.rest.model.BaseRate;
import com.creditsuisse.rest.model.Trade;
import com.google.gson.Gson;

public class DayCurrencyValidate {

	//http://api.fixer.io/2016-05-20?base=EUR&symbols=USD
	
private static final int FIM_BASE = 3;
private static final int INIT_TARGET = 3;
private static final int END_TARGET = 6;
private static final int MAX_TAM_CCYPAIR = 6;

public boolean IsNomWorkdayAndCurrencyValid(Trade trade) throws BussinesException {
		
		 LocalDate data =  trade.getValueDate();
		 String ccyPair = trade.getCcyPair();
		 String base = null;
		 String target = null;
		 String url = null;
		 
		 if(ccyPair != null && ccyPair.length() == MAX_TAM_CCYPAIR) {
			
			 base   = ccyPair.substring(0,FIM_BASE);
			 target = ccyPair.substring(INIT_TARGET,END_TARGET);
			 
			 try {
				 CurrencyValidate.validadedCurrency(base);	
				 CurrencyValidate.validadedCurrency(target);	
			} catch (BussinesException e) {
				throw new BussinesException(e.getMessage(),e);
			}
				 
			 url = "http://api.fixer.io/" + data +"?base="+ base + "&symbols=" + target;
			 return data.equals(getWorkDay(url));
			 
		 }else {
			 throw new BussinesException("invalid Currency");
		 }
	}
	
		
private LocalDate getWorkDay(String textUrl) throws BussinesException {
	
	HttpURLConnection conn = null;
	try {

		URL url = new URL(textUrl);
	    conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-Type", "application/json");

		if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
			throw new BussinesException("Failed to validate	non work day: "
					+ conn.getResponseCode());
		}
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));


			if(br!= null) {
				String output = br.readLine();
		    	Gson gson = new Gson();
		    	BaseRate rate = gson.fromJson(output, BaseRate.class);
		    	if(rate!= null) {
		    	   	return  LocalDate.parse(rate.getDate());
		    	}
			}	
			
			return null;
          
	} catch (IOException e) {
		throw new BussinesException(" Error URL", e);

	}finally {
	  	conn.disconnect();
	}

}

	
	
	
}
