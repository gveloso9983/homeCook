package com.example.homecookBackend.classes.address; /**
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
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class AddressDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression street;
	public final StringExpression postalCode;
	public final StringExpression city;

	public AddressDetachedCriteria() {
		super(Address.class, AddressCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		street = new StringExpression("street", this.getDetachedCriteria());
		postalCode = new StringExpression("postalCode", this.getDetachedCriteria());
		city = new StringExpression("city", this.getDetachedCriteria());
	}

	public AddressDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, AddressCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		street = new StringExpression("street", this.getDetachedCriteria());
		postalCode = new StringExpression("postalCode", this.getDetachedCriteria());
		city = new StringExpression("city", this.getDetachedCriteria());
	}

	public Address uniqueAddress(PersistentSession session) {
		return (Address) super.createExecutableCriteria(session).uniqueResult();
	}

	public Address[] listAddress(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Address[]) list.toArray(new Address[list.size()]);
	}
}

