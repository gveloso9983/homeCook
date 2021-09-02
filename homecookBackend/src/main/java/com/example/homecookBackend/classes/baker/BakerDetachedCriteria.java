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
import java.util.List;

import com.example.homecookBackend.classes.invoice_line.Invoice_lineDetachedCriteria;
import com.example.homecookBackend.classes.product.ProductDetachedCriteria;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class BakerDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression email;
	public final StringExpression firstName;
	public final StringExpression lastName;
	public final StringExpression phoneNumber;
	public final DateExpression birthDate;
	public final StringExpression password;
	public final CollectionExpression orders;
	public final CollectionExpression products;

	public BakerDetachedCriteria() {
		super(Baker.class, BakerCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		firstName = new StringExpression("firstName", this.getDetachedCriteria());
		lastName = new StringExpression("lastName", this.getDetachedCriteria());
		phoneNumber = new StringExpression("phoneNumber", this.getDetachedCriteria());
		birthDate = new DateExpression("birthDate", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		orders = new CollectionExpression("ORM_Orders", this.getDetachedCriteria());
		products = new CollectionExpression("ORM_Products", this.getDetachedCriteria());
	}

	public BakerDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, BakerCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		firstName = new StringExpression("firstName", this.getDetachedCriteria());
		lastName = new StringExpression("lastName", this.getDetachedCriteria());
		phoneNumber = new StringExpression("phoneNumber", this.getDetachedCriteria());
		birthDate = new DateExpression("birthDate", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		orders = new CollectionExpression("ORM_Orders", this.getDetachedCriteria());
		products = new CollectionExpression("ORM_Products", this.getDetachedCriteria());
	}

	public Invoice_lineDetachedCriteria createOrdersCriteria() {
		return new Invoice_lineDetachedCriteria(createCriteria("ORM_Orders"));
	}

	public ProductDetachedCriteria createProductsCriteria() {
		return new ProductDetachedCriteria(createCriteria("ORM_Products"));
	}

	public Baker uniqueBaker(PersistentSession session) {
		return (Baker) super.createExecutableCriteria(session).uniqueResult();
	}

	public Baker[] listBaker(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Baker[]) list.toArray(new Baker[list.size()]);
	}
}

