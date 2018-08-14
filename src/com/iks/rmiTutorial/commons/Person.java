package com.iks.rmiTutorial.commons;

import java.io.Serializable;

public class Person implements Serializable {
	
	private static final long serialVersionUID = -8723674825338760015L;

	public final String firstName;
	public final String lastName;
	public final Address address;

	public Person(String firstName, String lastName, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		return sb.append(this.firstName + " ")
				 .append(this.lastName + " ")
				 .append(this.address.toString()).toString();
	}

	public String getFullname() {
		return this.firstName + " " + this.lastName;
	}
	
}
