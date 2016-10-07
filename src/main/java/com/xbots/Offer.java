package com.xbots;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "offer")
public class Offer implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private Date expiryDate;
	private double amount;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Offer(String id, String name, Date expiryDate, double amount) {
		this.name = name;
		this.id = id;
		this.expiryDate = expiryDate;
		this.amount = amount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

}
