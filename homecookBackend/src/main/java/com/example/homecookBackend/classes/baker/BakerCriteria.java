package com.example.homecookBackend.classes.baker; /**
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
import com.example.homecookBackend.classes.invoice_line.Invoice_lineCriteria;
import com.example.homecookBackend.classes.product.ProductCriteria;
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class BakerCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression email;
	public final StringExpression firstName;
	public final StringExpression lastName;
	public final StringExpression phoneNumber;
	public final DateExpression birthDate;
	public final StringExpression password;
	public final CollectionExpression orders;
	public final CollectionExpression products;

	public BakerCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		email = new StringExpression("email", this);
		firstName = new StringExpression("firstName", this);
		lastName = new StringExpression("lastName", this);
		phoneNumber = new StringExpression("phoneNumber", this);
		birthDate = new DateExpression("birthDate", this);
		password = new StringExpression("password", this);
		orders = new CollectionExpression("ORM_Orders", this);
		products = new CollectionExpression("ORM_Products", this);
	}

	public BakerCriteria(PersistentSession session) {
		this(session.createCriteria(Baker.class));
	}

	public BakerCriteria() throws PersistentException {
		this(TrabalhoPersistentManager.instance().getSession());
	}

	public Invoice_lineCriteria createOrdersCriteria() {
		return new Invoice_lineCriteria(createCriteria("ORM_Orders"));
	}

	public ProductCriteria createProductsCriteria() {
		return new ProductCriteria(createCriteria("ORM_Products"));
	}

	public Baker uniqueBaker() {
		return (Baker) super.uniqueResult();
	}

	public Baker[] listBaker() {
		java.util.List list = super.list();
		return (Baker[]) list.toArray(new Baker[list.size()]);
	}
}

