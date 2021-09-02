package com.example.homecookBackend.classes.invoice; /**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 *
 * This is an automatic generated file. It will be regenerated every time
 * you generate persistence class.
 *
 * Modifying its content may cause the program not work, or your work may lost.
 */

import com.example.homecookBackend.classes.ORMConstants;
import com.example.homecookBackend.classes.address.Address;
import com.example.homecookBackend.classes.invoice_line.Invoice_lineSetCollection;

/**
 * Licensee: diogoferreira(Universidade do Minho)
 * License Type: Academic
 */
public class Invoice {
	public Invoice() {
	}

	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_INVOICE_INVOICE_LINES) {
			return ORM_invoice_lines;
		}

		return null;
	}

	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}

	};

	private int id;

	private Address address;

	private float total;

	private java.util.Date date;

	private java.util.Date deliveryDate;

	private java.util.Set ORM_invoice_lines = new java.util.HashSet();

	private void setId(int value) {
		this.id = value;
	}

	public int getId() {
		return id;
	}

	public int getORMID() {
		return getId();
	}

	public void setTotal(float value) {
		this.total = value;
	}

	public float getTotal() {
		return total;
	}

	public void setDate(java.util.Date value) {
		this.date = value;
	}

	public java.util.Date getDate() {
		return date;
	}

	public void setDeliveryDate(java.util.Date value) {
		this.deliveryDate = value;
	}

	public java.util.Date getDeliveryDate() {
		return deliveryDate;
	}

	private void setORM_Invoice_lines(java.util.Set value) {
		this.ORM_invoice_lines = value;
	}

	private java.util.Set getORM_Invoice_lines() {
		return ORM_invoice_lines;
	}

	public final Invoice_lineSetCollection invoice_lines = new Invoice_lineSetCollection(this, _ormAdapter, ORMConstants.KEY_INVOICE_INVOICE_LINES, ORMConstants.KEY_INVOICE_LINE_INVOICE, ORMConstants.KEY_MUL_ONE_TO_MANY);

	public void setAddress(Address value) {
		this.address = value;
	}

	public Address getAddress() {
		return address;
	}

	public String toString() {
		return String.valueOf(getId());
	}

}
