package com.example.homecookBackend.classes.cart_line; /**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 *
 * This is an automatic generated file. It will be regenerated every time
 * you generate persistence class.
 *
 * Modifying its content may cause the program not work, or your work may lost.
 */

import com.example.homecookBackend.classes.product.Product;

/**
 * Licensee: diogoferreira(Universidade do Minho)
 * License Type: Academic
 */
public class Cart_line {
	public Cart_line() {
	}

	private int id;

	private Product product;

	private int quantity;

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

	public void setProduct(Product value) {
		this.product = value;
	}

	public Product getProduct() {
		return product;
	}

	public String toString() {
		return String.valueOf(getId());
	}

}
