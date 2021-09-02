package com.example.homecookBackend.classes.invoice_line; /**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 *
 * This is an automatic generated file. It will be regenerated every time
 * you generate persistence class.
 *
 * Modifying its content may cause the program not work, or your work may lost.
 */

import com.example.homecookBackend.classes.ORMConstants;
import com.example.homecookBackend.classes.invoice.Invoice;
import com.example.homecookBackend.classes.product.Product;

/**
 * Licensee: diogoferreira(Universidade do Minho)
 * License Type: Academic
 */
public class Invoice_line {
	public Invoice_line() {
	}

	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_INVOICE_LINE_PRODUCT) {
			this.product = (Product) owner;
		}

		else if (key == ORMConstants.KEY_INVOICE_LINE_INVOICE) {
			this.invoice = (Invoice) owner;
		}
	}

	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}

	};

	private int id;

	private Invoice invoice;

	private Product product;

	private int quantity;

	private boolean done;

	private void setId(int value) {
		this.id = value;
	}

	public int getId() {
		return id;
	}

	public int getORMID() {
		return getId();
	}

	public void setQuantity(int value) {
		this.quantity = value;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setDone(boolean value) {
		this.done = value;
	}

	public boolean getDone() {
		return done;
	}

	public void setProduct(Product value) {
		this.product = value;
	}

	public Product getProduct() {
		return product;
	}

	public void setInvoice(Invoice value) {
		if (invoice != null) {
			invoice.invoice_lines.remove(this);
		}
		if (value != null) {
			value.invoice_lines.add(this);
		}
	}

	public Invoice getInvoice() {
		return invoice;
	}

	/**
	 * This method is for internal use only.
	 */
	public void setORM_Invoice(Invoice value) {
		this.invoice = value;
	}

	private Invoice getORM_Invoice() {
		return invoice;
	}

	public String toString() {
		return String.valueOf(getId());
	}

}
