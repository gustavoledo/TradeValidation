package com.creditsuisse.rest.service;

import java.util.List;

import com.creditsuisse.rest.exceptions.BussinesException;
import com.creditsuisse.rest.model.Trade;

public interface ValidateTrade {

	 boolean validateTradeDate(Trade trade) throws BussinesException;
	
	 boolean validadeExerciseDate(Trade trade) throws BussinesException;
	
	 boolean validateDeliveryDate(Trade trade)throws BussinesException;
	
	 boolean validateSupportedCompanies(Trade trade)throws BussinesException;
	
	 List<String> validarAllRules(Trade trade);
	
}	
