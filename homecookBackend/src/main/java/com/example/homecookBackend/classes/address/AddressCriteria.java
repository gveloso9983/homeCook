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
import com.example.homecookBackend.classes.TrabalhoPersistentManager;
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class AddressCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression street;
	public final StringExpression postalCode;
	public final StringExpression city;

	public AddressCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		street = new StringExpression("street", this);
		postalCode = new StringExpression("postalCode", this);
		city = new StringExpression("city", this);
	}

	public AddressCriteria(PersistentSession session) {
		this(session.createCriteria(Address.class));
	}

	public AddressCriteria() throws PersistentException {
		this(TrabalhoPersistentManager.instance().getSession());
	}

	public Address uniqueAddress() {
		return (Address) super.uniqueResult();
	}

	public Address[] listAddress() {
		java.util.List list = super.list();
		return (Address[]) list.toArray(new Address[list.size()]);
	}
}

