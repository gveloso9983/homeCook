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
import com.example.homecookBackend.classes.TrabalhoPersistentManager;
import com.example.homecookBackend.classes.address.AddressCriteria;
import com.example.homecookBackend.classes.cart_line.Cart_lineCriteria;
import com.example.homecookBackend.classes.invoice.InvoiceCriteria;
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ClientCriteria extends AbstractORMCriteria {
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

	public ClientCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		email = new StringExpression("email", this);
		firstName = new StringExpression("firstName", this);
		lastName = new StringExpression("lastName", this);
		phoneNumber = new StringExpression("phoneNumber", this);
		birthDate = new DateExpression("birthDate", this);
		password = new StringExpression("password", this);
		invoices = new CollectionExpression("ORM_Invoices", this);
		shopping_cart = new CollectionExpression("ORM_Shopping_cart", this);
		addresses = new CollectionExpression("ORM_Addresses", this);
	}

	public ClientCriteria(PersistentSession session) {
		this(session.createCriteria(Client.class));
	}

	public ClientCriteria() throws PersistentException {
		this(TrabalhoPersistentManager.instance().getSession());
	}

	public InvoiceCriteria createInvoicesCriteria() {
		return new InvoiceCriteria(createCriteria("ORM_Invoices"));
	}

	public Cart_lineCriteria createShopping_cartCriteria() {
		return new Cart_lineCriteria(createCriteria("ORM_Shopping_cart"));
	}

	public AddressCriteria createAddressesCriteria() {
		return new AddressCriteria(createCriteria("ORM_Addresses"));
	}

	public Client uniqueClient() {
		return (Client) super.uniqueResult();
	}

	public Client[] listClient() {
		java.util.List list = super.list();
		return (Client[]) list.toArray(new Client[list.size()]);
	}
}

