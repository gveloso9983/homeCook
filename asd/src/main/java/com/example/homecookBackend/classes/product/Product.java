package com.example.homecookBackend.classes.product; /**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 *
 * This is an automatic generated file. It will be regenerated every time
 * you generate persistence class.
 *
 * Modifying its content may cause the program not work, or your work may lost.
 */

import com.example.homecookBackend.classes.ORMConstants;
import com.example.homecookBackend.classes.baker.Baker;
import com.example.homecookBackend.classes.category.Category;
import com.example.homecookBackend.classes.comment.CommentSetCollection;
import com.example.homecookBackend.classes.image.ImageSetCollection;

/**
 * Licensee: diogoferreira(Universidade do Minho)
 * License Type: Academic
 */
public class Product {
	public Product() {
	}

	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_PRODUCT_COMMENTS) {
			return ORM_comments;
		}
		else if (key == ORMConstants.KEY_PRODUCT_IMAGES) {
			return ORM_images;
		}

		return null;
	}

	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_PRODUCT_CATEGORY) {
			this.category = (Category) owner;
		}

		else if (key == ORMConstants.KEY_PRODUCT_BAKER) {
			this.baker = (Baker) owner;
		}
	}

	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}

		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}

	};

	private int id;

	private Baker baker;

	private Category category;

	private String name;

	private String description;

	private String ingredients;

	private float price;

	private float weight;

	private float rating;

	private int number_ratings;

	private boolean onSale;

	private java.util.Set ORM_comments = new java.util.HashSet();

	private java.util.Set ORM_images = new java.util.HashSet();

	private void setId(int value) {
		this.id = value;
	}

	public int getId() {
		return id;
	}

	public int getORMID() {
		return getId();
	}

	public void setName(String value) {
		this.name = value;
	}

	public String getName() {
		return name;
	}

	public void setDescription(String value) {
		this.description = value;
	}

	public String getDescription() {
		return description;
	}

	public void setIngredients(String value) {
		this.ingredients = value;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setPrice(float value) {
		this.price = value;
	}

	public float getPrice() {
		return price;
	}

	public void setWeight(float value) {
		this.weight = value;
	}

	public float getWeight() {
		return weight;
	}

	public void setRating(float value) {
		this.rating = value;
	}

	public float getRating() {
		return rating;
	}

	public void setNumber_ratings(int value) {
		this.number_ratings = value;
	}

	public int getNumber_ratings() {
		return number_ratings;
	}

	public void setOnSale(boolean value) {
		this.onSale = value;
	}

	public boolean getOnSale() {
		return onSale;
	}

	private void setORM_Comments(java.util.Set value) {
		this.ORM_comments = value;
	}

	private java.util.Set getORM_Comments() {
		return ORM_comments;
	}

	public final CommentSetCollection comments = new CommentSetCollection(this, _ormAdapter, ORMConstants.KEY_PRODUCT_COMMENTS, ORMConstants.KEY_MUL_ONE_TO_MANY);

	private void setORM_Images(java.util.Set value) {
		this.ORM_images = value;
	}

	private java.util.Set getORM_Images() {
		return ORM_images;
	}

	public final ImageSetCollection images = new ImageSetCollection(this, _ormAdapter, ORMConstants.KEY_PRODUCT_IMAGES, ORMConstants.KEY_MUL_ONE_TO_MANY);

	public void setCategory(Category value) {
		this.category = value;
	}

	public Category getCategory() {
		return category;
	}

	public void setBaker(Baker value) {
		if (baker != null) {
			baker.products.remove(this);
		}
		if (value != null) {
			value.products.add(this);
		}
	}

	public Baker getBaker() {
		return baker;
	}

	/**
	 * This method is for internal use only.
	 */
	public void setORM_Baker(Baker value) {
		this.baker = value;
	}

	private Baker getORM_Baker() {
		return baker;
	}

	public String toString() {
		return String.valueOf(getId());
	}

}
