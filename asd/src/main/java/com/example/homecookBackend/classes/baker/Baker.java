package com.example.homecookBackend.classes.baker; /**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 *
 * This is an automatic generated file. It will be regenerated every time
 * you generate persistence class.
 *
 * Modifying its content may cause the program not work, or your work may lost.
 */

import com.example.homecookBackend.classes.ORMConstants;
import com.example.homecookBackend.classes.invoice_line.Invoice_lineSetCollection;
import com.example.homecookBackend.classes.product.ProductSetCollection;

/**
 * Licensee: diogoferreira(Universidade do Minho)
 * License Type: Academic
 */
public class Baker {
	public Baker() {
	}

	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_BAKER_ORDERS) {
			return ORM_orders;
		}
		else if (key == ORMConstants.KEY_BAKER_PRODUCTS) {
			return ORM_products;
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

	private java.util.Set ORM_orders = new java.util.HashSet();

	private java.util.Set ORM_products = new java.util.HashSet();

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

	private void setORM_Orders(java.util.Set value) {
		this.ORM_orders = value;
	}

	private java.util.Set getORM_Orders() {
		return ORM_orders;
	}

	public final Invoice_lineSetCollection orders = new Invoice_lineSetCollection(this, _ormAdapter, ORMConstants.KEY_BAKER_ORDERS, ORMConstants.KEY_MUL_ONE_TO_MANY);

	private void setORM_Products(java.util.Set value) {
		this.ORM_products = value;
	}

	private java.util.Set getORM_Products() {
		return ORM_products;
	}

	public final ProductSetCollection products = new ProductSetCollection(this, _ormAdapter, ORMConstants.KEY_BAKER_PRODUCTS, ORMConstants.KEY_PRODUCT_BAKER, ORMConstants.KEY_MUL_ONE_TO_MANY);

	public String toString() {
		return String.valueOf(getId());
	}

}
