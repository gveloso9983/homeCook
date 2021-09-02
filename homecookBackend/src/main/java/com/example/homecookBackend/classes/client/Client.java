package com.example.homecookBackend.classes.client; /**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 *
 * This is an automatic generated file. It will be regenerated every time
 * you generate persistence class.
 *
 * Modifying its content may cause the program not work, or your work may lost.
 */

import com.example.homecookBackend.classes.ORMConstants;
import com.example.homecookBackend.classes.address.AddressSetCollection;
import com.example.homecookBackend.classes.cart_line.Cart_lineSetCollection;
import com.example.homecookBackend.classes.invoice.InvoiceSetCollection;

/**
 * Licensee: diogoferreira(Universidade do Minho)
 * License Type: Academic
 */
public class Client {
	public Client() {
	}

	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_CLIENT_INVOICES) {
			return ORM_invoices;
		}
		else if (key == ORMConstants.KEY_CLIENT_SHOPPING_CART) {
			return ORM_shopping_cart;
		}
		else if (key == ORMConstants.KEY_CLIENT_ADDRESSES) {
			return ORM_addresses;
		}

		return null;
	}

	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}

	};

	private int id;

	private String email;

	private String firstName;

	private String lastName;

	private String phoneNumber;

	private java.util.Date birthDate;

	private String password;

	private java.util.Set ORM_invoices = new java.util.HashSet();

	private java.util.Set ORM_shopping_cart = new java.util.HashSet();

	private java.util.Set ORM_addresses = new java.util.HashSet();

	public void setEmail(String value) {
		this.email = value;
	}

	public String getEmail() {
		return email;
	}

	public void setFirstName(String value) {
		this.firstName = value;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String value) {
		this.lastName = value;
	}

	public String getLastName() {
		return lastName;
	}

	public void setPhoneNumber(String value) {
		this.phoneNumber = value;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setBirthDate(java.util.Date value) {
		this.birthDate = value;
	}

	public java.util.Date getBirthDate() {
		return birthDate;
	}

	public void setPassword(String value) {
		this.password = value;
	}

	public String getPassword() {
		return password;
	}

	private void setId(int value) {
		this.id = value;
	}

	public int getId() {
		return id;
	}

	public int getORMID() {
		return getId();
	}

	private void setORM_Invoices(java.util.Set value) {
		this.ORM_invoices = value;
	}

	private java.util.Set getORM_Invoices() {
		return ORM_invoices;
	}

	public final InvoiceSetCollection invoices = new InvoiceSetCollection(this, _ormAdapter, ORMConstants.KEY_CLIENT_INVOICES, ORMConstants.KEY_MUL_ONE_TO_MANY);

	private void setORM_Shopping_cart(java.util.Set value) {
		this.ORM_shopping_cart = value;
	}

	private java.util.Set getORM_Shopping_cart() {
		return ORM_shopping_cart;
	}

	public final Cart_lineSetCollection shopping_cart = new Cart_lineSetCollection(this, _ormAdapter, ORMConstants.KEY_CLIENT_SHOPPING_CART, ORMConstants.KEY_MUL_ONE_TO_MANY);

	private void setORM_Addresses(java.util.Set value) {
		this.ORM_addresses = value;
	}

	private java.util.Set getORM_Addresses() {
		return ORM_addresses;
	}

	public final AddressSetCollection addresses = new AddressSetCollection(this, _ormAdapter, ORMConstants.KEY_CLIENT_ADDRESSES, ORMConstants.KEY_MUL_ONE_TO_MANY);

	public String toString() {
		return String.valueOf(getId());
	}

}
