package com.creditsuisse.rest.dto;

import java.time.LocalDate;

import com.creditsuisse.rest.enuns.Direction;
import com.creditsuisse.rest.enuns.Style;
import com.creditsuisse.rest.enuns.Type;
import com.creditsuisse.rest.exceptions.BussinesException;
import com.creditsuisse.rest.model.Trade;


/**
 * @author AL Solucoes
 * Class created to bind Json to Object 
 */
public class TradeDto {

	private String customer;
    
    private Double amount1;
    private Double amount2;
    private Double rate;
    
    private String tradeDate;    
    
    private String trader;
    private String legalEntity;
    
    private String ccyPair;
    private String valueDate;
    
    private Style style;
	private Type type;
	private Direction direction;
    
    private String strategy;
    private String deliveryDate;
    private String expiryDate;
    private String payCcy;
    private String premium;
    private String premiumType;
    private String premiumDate;
    private String premiumCcy;
    
    private String excerciseStartDate;
    
    
        
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public Type getType() {
		return type;
	}
	
	public void setType(String type) {
		try {
			this.type =  Enum.valueOf(Type.class, type.toUpperCase());
		} catch (Exception e) {
			this.type = null;
		}
	}
	public Direction getDirection() {
		return direction;
	}
	
	public void setDirection(String direction) {
		try {
			this.direction =  Enum.valueOf(Direction.class, direction.toUpperCase());
		} catch (Exception e) {
			this.direction = null;
		}
	}
	
	public Double getAmount1() {
		return amount1;
	}
	public void setAmount1(Double amount1) {
		this.amount1 = amount1;
	}
	public Double getAmount2() {
		return amount2;
	}
	public void setAmount2(Double amount2) {
		this.amount2 = amount2;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}

	public LocalDate getTradeDate() {
		if(tradeDate!=null)
  		   return LocalDate.parse(tradeDate);
		
		return null;
	}
	
	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}
	public String getTrader() {
		return trader;
	}
	public void setTrader(String trader) {
		this.trader = trader;
	}
	public String getLegalEntity() {
		return legalEntity;
	}
	public void setLegalEntity(String legalEntity) {
		this.legalEntity = legalEntity;
	}
	public String getCcyPair() {
		return ccyPair;
	}
	public void setCcyPair(String ccyPair) {
		this.ccyPair = ccyPair;
	}

	public LocalDate getValueDate() {
		if(valueDate != null) {
			return LocalDate.parse(valueDate);
		}
		return null;
	}
	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}
	
	
	public Style getStyle() {
		return style;
	}
	
	public void setStyle(String style) {
		try {
			this.style =  Enum.valueOf(Style.class, style.toUpperCase());
		} catch (Exception e) {
			this.style = null;
		}
		
	}
	public String getStrategy() {
		return strategy;
	}
	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}
	public LocalDate getDeliveryDate() {
		if(deliveryDate != null) {
			return LocalDate.parse(deliveryDate);
		}
		return null;
		
	}
	
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
	public LocalDate getExpiryDate() {
		
		if(expiryDate != null) {
			return LocalDate.parse(expiryDate);
		}
		return null;
		
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getPayCcy() {
		return payCcy;
	}
	public void setPayCcy(String payCcy) {
		this.payCcy = payCcy;
	}
	public String getPremium() {
		return premium;
	}
	public void setPremium(String premium) {
		this.premium = premium;
	}
	public String getPremiumType() {
		return premiumType;
	}
	public void setPremiumType(String premiumType) {
		this.premiumType = premiumType;
	}
	public LocalDate getPremiumDate() {
		if(premiumDate != null) {
			return LocalDate.parse(premiumDate);
		}
		return null;
	}

	public void setPremiumDate(String premiumDate) {
		this.premiumDate = premiumDate;
	}
	

	public String getPremiumCcy() {
		return premiumCcy;
	}
	public void setPremiumCcy(String premiumCcy) {
		this.premiumCcy = premiumCcy;
	}
	
	public LocalDate getExcerciseStartDate() {
		if(excerciseStartDate != null) {
			return LocalDate.parse(excerciseStartDate);
		}
		return null;
	}
	
	public void setExcerciseStartDate(String excerciseStartDate) {
		this.excerciseStartDate = excerciseStartDate;
	}
	public Trade getTrade() throws BussinesException {
		
		Trade trade = new Trade();
	try {	
			trade.setAmount1(amount1);
			trade.setAmount2(amount2);
			trade.setCcyPair(ccyPair);
			trade.setCustomer(customer);		
			trade.setDirection(direction);
			trade.setStyle(style);
			trade.setLegalEntity(legalEntity);
			trade.setRate(rate);
			trade.setTradeDate(getTradeDate());
			trade.setTrader(trader);
			trade.setType(type);
			trade.setValueDate(getValueDate());
			trade.setStrategy(strategy);
			trade.setDeliveryDate(getDeliveryDate());
			trade.setExpiryDate(getExpiryDate());
			trade.setPayCcy(payCcy);  
			trade.setPremium(premium);   
			trade.setPremiumType(premiumType);
			trade.setPremiumDate(getPremiumDate());
			trade.setPremiumCcy(premiumCcy);
			trade.setExcerciseStartDate(getExcerciseStartDate());   
	}catch (Exception e) {
		throw new BussinesException("Erro in parser DTO to Object ", e);
	}   
		
		return trade;
	}
	
	
	@Override
	public String toString() {
		return "TradeDto [customer=" + customer + ", amount1=" + amount1 + ", amount2=" + amount2 + ", rate=" + rate
				+ ", tradeDate=" + tradeDate + ", trader=" + trader + ", legalEntity=" + legalEntity + ", ccyPair="
				+ ccyPair + ", valueDate=" + valueDate + ", style=" + style + ", type=" + type + ", direction="
				+ direction + ", strategy=" + strategy + ", deliveryDate=" + deliveryDate + ", expiryDate=" + expiryDate
				+ ", payCcy=" + payCcy + ", premium=" + premium + ", premiumType=" + premiumType + ", premiumDate="
				+ premiumDate + ", premiumCcy=" + premiumCcy + ", excerciseStartDate=" + excerciseStartDate + "]";
	}

	
	
	
	
	
	
	

	
	
}
