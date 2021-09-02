package com.example.homecookBackend.classes.image; /**
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
public class Image {
	public Image() {
	}

	private int id;

	private String path;

	private void setId(int value) {
		this.id = value;
	}

	public int getId() {
		return id;
	}

	public int getORMID() {
		return getId();
	}

	public void setPath(String value) {
		this.path = value;
	}

	public String getPath() {
		return path;
	}

	public String toString() {
		return String.valueOf(getId());
	}

}
