package com.creditsuisse.rest.model;


import java.time.LocalDate;

import com.creditsuisse.rest.enuns.Direction;
import com.creditsuisse.rest.enuns.Style;
import com.creditsuisse.rest.enuns.Type;

/**
 *
 * @author Gustavo Ledo
 */
public class Trade {
    
 	private String customer;
    
 	private Type type;
    private Direction direction;
    private Style style; 
    
    private Double amount1;
    private Double amount2;
    private Double rate;
    
    private LocalDate tradeDate;    
    
    private String trader;
    private String legalEntity;
    
    private String ccyPair;
    private LocalDate valueDate;
        
    private String strategy;
    private LocalDate deliveryDate;
    private LocalDate expiryDate;
    private String payCcy;
    private String premium;
    private String premiumType;
    private LocalDate premiumDate;
    private String premiumCcy;
    private LocalDate excerciseStartDate;
    
    
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
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
		return tradeDate;
	}
	public void setTradeDate(LocalDate tradeDate) {
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
		return valueDate;
	}
	public void setValueDate(LocalDate valueDate) {
		this.valueDate = valueDate;
	}
	
	
	public String getStrategy() {
		return strategy;
	}
	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}
	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
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
		return premiumDate;
	}
	public void setPremiumDate(LocalDate premiumDate) {
		this.premiumDate = premiumDate;
	}
	public String getPremiumCcy() {
		return premiumCcy;
	}
	public void setPremiumCcy(String premiumCcy) {
		this.premiumCcy = premiumCcy;
	}
	
	public Style getStyle() {
		return style;
	}
	
	public void setStyle(Style style) {
		this.style = style;
	}
	
	
	public LocalDate getExcerciseStartDate() {
		return excerciseStartDate;
	}
	public void setExcerciseStartDate(LocalDate excerciseStartDate) {
		this.excerciseStartDate = excerciseStartDate;
	}
	@Override
	public String toString() {
		return "Trade [customer=" + customer + ", type=" + type + ", direction=" + direction + ", amount1=" + amount1
				+ ", amount2=" + amount2 + ", rate=" + rate + ", tradeDate=" + tradeDate + ", trader=" + trader
				+ ", legalEntity=" + legalEntity + ", ccyPair=" + ccyPair + ", valueDate=" + valueDate + ", strategy="
				+ strategy + ", deliveryDate=" + deliveryDate + ", expiryDate=" + expiryDate + ", payCcy=" + payCcy
				+ ", premium=" + premium + ", premiumType=" + premiumType + ", premiumDate=" + premiumDate
				+ ", premiumCcy=" + premiumCcy + "]";
	}
	
	

   
    


    
    
    
    
}
