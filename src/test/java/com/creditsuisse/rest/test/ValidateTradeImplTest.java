package com.creditsuisse.rest.test;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

import com.creditsuisse.rest.enuns.Style;
import com.creditsuisse.rest.enuns.Type;
import com.creditsuisse.rest.exceptions.BussinesException;
import com.creditsuisse.rest.model.Trade;
import com.creditsuisse.rest.service.ValidateTradeImpl;

public class ValidateTradeImplTest {

	
	ValidateTradeImpl validate = new ValidateTradeImpl();
	Trade tradeGood = new Trade();	
	
	/*
	{"customer":"PLUTO1","ccyPair":"EURUSD","type":"VanillaOption","style":"EUROPEAN","direction":"BUY","strategy":"CALL","tradeDate"
		:"2016-08-11","amount1":1000000.00,"amount2":1120000.00,"rate":1.12,"deliveryDate":"2016-08-22","expiryDate":"2016-08-19",
		"payCcy":"USD","premium":0.20,"premiumCcy":"USD","premiumType":"%USD","premiumDate":"2016-08-12","legalEntity":"CS Zurich",
		"trader":"Johann Baumfiddler"}*/
	
	protected void setUp() {
	   
		tradeGood.setCustomer("PLUTO1");
		tradeGood.setCcyPair("EURUSD");
		tradeGood.setStyle(Style.EUROPEAN);
		tradeGood.setType(Type.VANILLAOPTION);
		tradeGood.setTradeDate(LocalDate.parse("2016-08-11"));
		tradeGood.setDeliveryDate(LocalDate.parse("2016-08-22"));
		tradeGood.setExpiryDate(LocalDate.parse("2016-08-19"));
		tradeGood.setPremiumDate(LocalDate.parse("2016-08-12"));
	}
	
	@Test
	public void validateSupportedCompaniesTest() throws BussinesException {
		Trade trade = new Trade();
		trade.setCustomer("PLUTO1");
		assertTrue(validate.validateSupportedCompanies(trade));
	}
	
	 @Test(expected=BussinesException.class)
	public void validateSupportedCompaniesTestFail() throws BussinesException {
		Trade trade = new Trade();
		trade.setCustomer("PLUTO");
		validate.validateSupportedCompanies(trade);
	}
	 
	
		@Test
		public void nomWorkDayTest() throws BussinesException {
		     assertTrue(validate.nomWorkDay(tradeGood));
		}

		@Test
		public void validateDeliveryDateTest() throws BussinesException {
		     assertTrue(validate.validateDeliveryDate(tradeGood));
		}
		
		
		@Test(expected=Exception.class)
		public void validadeExerciseDateTestFail() throws BussinesException {
		 assertTrue(validate.validadeExerciseDate(tradeGood));
		}
		

		
}
