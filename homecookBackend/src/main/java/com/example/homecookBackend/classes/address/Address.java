package com.example.homecookBackend.classes.address;
/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 *
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 *
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: diogoferreira(Universidade do Minho)
 * License Type: Academic
 */
public class Address {
	public Address() {
	}

	private int id;

	private String street;

	private String postalCode;

	private String city;

	private void setId(int value) {
		this.id = value;
	}

	public int getId() {
		return id;
	}

	public int getORMID() {
		return getId();
	}

	public void setStreet(String value) {
		this.street = value;
	}

	public String getStreet() {
		return street;
	}

	public void setPostalCode(String value) {
		this.postalCode = value;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setCity(String value) {
		this.city = value;
	}

	public String getCity() {
		return city;
	}

	public String toString() {
		return String.valueOf(getId());
	}

}
