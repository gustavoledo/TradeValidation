package com.creditsuisse.rest.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import com.creditsuisse.rest.exceptions.BussinesException;

public class CurrencyValidate {
	
	public static boolean validadedCurrency(String currency) throws BussinesException {
		
		HttpURLConnection conn = null;
		try {

			URL url = new URL(
					"http://api.fixer.io/latest?base=" + currency);
		    conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new BussinesException("Failed to validate	 currency " + currency + "HTTP error code : "
						+ conn.getResponseCode());
			}
			
			return true;

		} catch (IOException e) {
			throw new BussinesException(" Error URL", e);
	
		}finally {
		  	conn.disconnect();
		}

	}
	
		
		
		
	}
	
