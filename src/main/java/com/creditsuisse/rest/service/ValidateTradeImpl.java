package com.creditsuisse.rest.service;

import java.util.ArrayList;
import java.util.List;

import com.creditsuisse.rest.enuns.Style;
import com.creditsuisse.rest.enuns.Type;
import com.creditsuisse.rest.exceptions.BussinesException;
import com.creditsuisse.rest.model.Trade;


/**
 * @author Gustavo Ledo
 *
 */
public class ValidateTradeImpl implements ValidateTrade {

	
		
	/**
	 * @param trade
	 * @return
	 * @throws BussinesException
	 * value date cannot be before trade date.
	 * validate the value date against the product type
	 */
	public boolean validateTradeDate(Trade trade) throws BussinesException {
		      
		if(trade.getType().equals(Type.SPOT) || trade.getType().equals(Type.FORWARD)){
		    if( !(trade.getValueDate() != null && trade.getTradeDate() != null)) {
		    	 throw new BussinesException("value date is Null.");
		    }         
			
		    if(!trade.getValueDate().isBefore(trade.getTradeDate())) {
		    	 throw new BussinesException("Value date before Trade date.");
		    }
		}
		
 	   return true;
		
	}


	/**
	 * @param trade
	 * @return
	 * @throws BussinesException
	 *  American option style will have in addition the excerciseStartDate, 
	 *  which has to be after the trade date but before the expiry date
	 */
	public boolean validadeExerciseDate(Trade trade) throws BussinesException {
		if(trade.getType().equals(Type.VANILLAOPTION) && trade.getStyle() == null) {
			 throw new BussinesException("Json format invalid, STYLE is null.");
		}
		if(trade.getType().equals(Type.VANILLAOPTION) &&  trade.getStyle().equals(Style.AMERICAN) &&
			   trade.getExcerciseStartDate().isBefore(trade.getTradeDate()) &&
			   trade.getExcerciseStartDate().isAfter(trade.getExpiryDate())) {
		 
		   throw new BussinesException("Excercise Start Date invalid.");
	   } 
		
		return true;
	}
	
	
	
	/**
	 * @param trade
	 * @return
	 * @throws BussinesException
	 * expiry date and premium date shall be before delivery date
	 */
	public boolean validateDeliveryDate(Trade trade)throws BussinesException {
		
		if(trade.getExpiryDate() != null && trade.getDeliveryDate() != null &&
				trade.getPremiumDate() != null &&
				trade.getExpiryDate().isAfter(trade.getDeliveryDate()) &&
				trade.getPremiumDate().isAfter(trade.getDeliveryDate())) {
			throw new BussinesException("Delivery date invalid.");
		}
				
		return true;
	}
	
 

	/**
	 * @param trade
	 * @return
	 * @throws BussinesException
	 * if the counterparty (Customer) is one of the supported ones
	 */
	@Override
	public boolean validateSupportedCompanies(Trade trade)throws BussinesException {
		if(SupportedCompanies.validateSuportedCompanies(trade.getCustomer())){
			return true;
		}else {
			throw new BussinesException("Invalid Company");
		}
	}
	
    
	/**
	 * @param trade
	 * @return
	 * @throws BussinesException
	 * Validate os non work day
	 * Validade Currency Valid
	 */
	public boolean nomWorkDay(Trade trade)throws BussinesException {
		if(trade.getValueDate() != null){
			 
			 DayCurrencyValidate currencyValidate = new DayCurrencyValidate();
			 if(currencyValidate.IsNomWorkdayAndCurrencyValid(trade)) {
				 return true;
			 }else {
				 throw new BussinesException("Value date is non work day.");
				 
			 }
			}
		return true;
	}


	@Override
	public List<String> validarAllRules(Trade trade) {
	    List<String> erros = new ArrayList();
	    
		try {
		
			validateTradeDate(trade);
			
	   } catch (BussinesException e) {
		    erros.add(e.getMessage());
	   }        
		 
		
	try {
			
		validadeExerciseDate(trade);
			
	   } catch (BussinesException e) {
		    erros.add(e.getMessage());
	   }       
		
	try {
		
		validateDeliveryDate(trade);
			
	   } catch (BussinesException e) {
		    erros.add(e.getMessage());
	   } 
			
		try {
			
			validateSupportedCompanies(trade);
				
		   } catch (BussinesException e) {
			    erros.add(e.getMessage());
		   } 
	     try {
			
		        nomWorkDay(trade);
				
		   } catch (BussinesException e) {
			    erros.add(e.getMessage());
		   } 
			
		return erros;
	}
	
	
}
