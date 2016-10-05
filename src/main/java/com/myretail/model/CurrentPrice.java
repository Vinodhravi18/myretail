package com.myretail.model;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class CurrentPrice {

	private BigDecimal value;
	private String currency;
	
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
}
