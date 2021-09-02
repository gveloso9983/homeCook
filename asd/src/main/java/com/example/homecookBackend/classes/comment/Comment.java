package com.example.homecookBackend.classes.comment; /**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 *
 * This is an automatic generated file. It will be regenerated every time
 * you generate persistence class.
 *
 * Modifying its content may cause the program not work, or your work may lost.
 */

import com.example.homecookBackend.classes.ORMConstants;
import com.example.homecookBackend.classes.client.Client;

/**
 * Licensee: diogoferreira(Universidade do Minho)
 * License Type: Academic
 */
public class Comment {
	public Comment() {
	}

	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_COMMENT_CLIENT) {
			this.client = (Client) owner;
		}
	}

	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}

	};

	private int id;

	private Client client;

	private float score;

	private java.util.Date date;

	private String comment;

	public void setScore(float value) {
		this.score = value;
	}

	public float getScore() {
		return score;
	}

	public void setDate(java.util.Date value) {
		this.date = value;
	}

	public java.util.Date getDate() {
		return date;
	}

	public void setComment(String value) {
		this.comment = value;
	}

	public String getComment() {
		return comment;
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

	public void setClient(Client value) {
		this.client = value;
	}

	public Client getClient() {
		return client;
	}

	public String toString() {
		return String.valueOf(getId());
	}

}
