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
import com.example.homecookBackend.classes.TrabalhoPersistentManager;
import org.orm.*;

public class ImageSetCollection extends org.orm.util.ORMSet {
	public ImageSetCollection(Object owner, org.orm.util.ORMAdapter adapter, int ownerKey, int targetKey, int collType) {
		super(owner, adapter, ownerKey, targetKey, true, collType);
	}

	public ImageSetCollection(Object owner, org.orm.util.ORMAdapter adapter, int ownerKey, int collType) {
		super(owner, adapter, ownerKey, -1, false, collType);
	}

	/**
	 * Return an iterator over the persistent objects
	 * @return The persistent objects iterator
	 */
	public java.util.Iterator getIterator() {
		return super.getIterator(_ownerAdapter);
	}

	/**
	 * Add the specified persistent object to ORMSet
	 * @param value the persistent object
	 */
	public void add(Image value) {
		if (value != null) {
			super.add(value, null);
		}
	}

	/**
	 * Remove the specified persistent object from ORMSet
	 * @param value the persistent object
	 */
	public void remove(Image value) {
		super.remove(value, null);
	}

	/**
	 * Return true if ORMSet contains the specified persistent object
	 * @param value the persistent object
	 * @return True if this contains the specified persistent object
	 */
	public boolean contains(Image value) {
		return super.contains(value);
	}

	/**
	 * Return an array containing all of the persistent objects in ORMSet
	 * @return The persistent objects array
	 */
	public Image[] toArray() {
		return (Image[]) super.toArray(new Image[size()]);
	}

	/**
	 * Return an sorted array containing all of the persistent objects in ORMSet
	 * @param propertyName Name of the property for sorting:<ul>
	 * <li>id</li>
	 * <li>path</li>
	 * </ul>
	 * @return The persistent objects sorted array
	 */
	public Image[] toArray(String propertyName) {
		return toArray(propertyName, true);
	}

	/**
	 * Return an sorted array containing all of the persistent objects in ORMSet
	 * @param propertyName Name of the property for sorting:<ul>
	 * <li>id</li>
	 * <li>path</li>
	 * </ul>
	 * @param ascending true for ascending, false for descending
	 * @return The persistent objects sorted array
	 */
	public Image[] toArray(String propertyName, boolean ascending) {
		return (Image[]) super.toArray(new Image[size()], propertyName, ascending);
	}

	protected PersistentManager getPersistentManager() throws PersistentException {
		return TrabalhoPersistentManager.instance();
	}

}

