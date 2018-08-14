package com.iks.rmiTutorial.commons;

import java.io.Serializable;

public class Address implements Serializable{

	private static final long serialVersionUID = -4165462625321240944L;

	public final String street;
	public final String number;
	public final String zipCode;
	public final String city;

	public Address(String street, String number, String zipCode, String city) {
		this.street = street;
		this.number = number;
		this.zipCode = zipCode;
		this.city = city;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		return sb.append("{")
				 .append(street + " " + number + ", ")
				 .append(zipCode + " " + city)
				 .append("}").toString();
	}
	
	
}
