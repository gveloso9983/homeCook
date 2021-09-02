package com.example.homecookBackend.classes.client; /**
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

import com.example.homecookBackend.classes.address.AddressDetachedCriteria;
import com.example.homecookBackend.classes.cart_line.Cart_lineDetachedCriteria;
import com.example.homecookBackend.classes.invoice.InvoiceDetachedCriteria;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ClientDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression email;
	public final StringExpression firstName;
	public final StringExpression lastName;
	public final StringExpression phoneNumber;
	public final DateExpression birthDate;
	public final StringExpression password;
	public final CollectionExpression invoices;
	public final CollectionExpression shopping_cart;
	public final CollectionExpression addresses;

	public ClientDetachedCriteria() {
		super(Client.class, ClientCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		firstName = new StringExpression("firstName", this.getDetachedCriteria());
		lastName = new StringExpression("lastName", this.getDetachedCriteria());
		phoneNumber = new StringExpression("phoneNumber", this.getDetachedCriteria());
		birthDate = new DateExpression("birthDate", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		invoices = new CollectionExpression("ORM_Invoices", this.getDetachedCriteria());
		shopping_cart = new CollectionExpression("ORM_Shopping_cart", this.getDetachedCriteria());
		addresses = new CollectionExpression("ORM_Addresses", this.getDetachedCriteria());
	}

	public ClientDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, ClientCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		firstName = new StringExpression("firstName", this.getDetachedCriteria());
		lastName = new StringExpression("lastName", this.getDetachedCriteria());
		phoneNumber = new StringExpression("phoneNumber", this.getDetachedCriteria());
		birthDate = new DateExpression("birthDate", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		invoices = new CollectionExpression("ORM_Invoices", this.getDetachedCriteria());
		shopping_cart = new CollectionExpression("ORM_Shopping_cart", this.getDetachedCriteria());
		addresses = new CollectionExpression("ORM_Addresses", this.getDetachedCriteria());
	}

	public InvoiceDetachedCriteria createInvoicesCriteria() {
		return new InvoiceDetachedCriteria(createCriteria("ORM_Invoices"));
	}

	public Cart_lineDetachedCriteria createShopping_cartCriteria() {
		return new Cart_lineDetachedCriteria(createCriteria("ORM_Shopping_cart"));
	}

	public AddressDetachedCriteria createAddressesCriteria() {
		return new AddressDetachedCriteria(createCriteria("ORM_Addresses"));
	}

	public Client uniqueClient(PersistentSession session) {
		return (Client) super.createExecutableCriteria(session).uniqueResult();
	}

	public Client[] listClient(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Client[]) list.toArray(new Client[list.size()]);
	}
}

