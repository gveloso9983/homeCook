package com.example.homecookBackend.classes.invoice; /**
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
import com.example.homecookBackend.classes.invoice_line.Invoice_lineCriteria;
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class InvoiceCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final IntegerExpression addressId;
	public final AssociationExpression address;
	public final FloatExpression total;
	public final DateExpression date;
	public final DateExpression deliveryDate;
	public final CollectionExpression invoice_lines;

	public InvoiceCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		addressId = new IntegerExpression("address.id", this);
		address = new AssociationExpression("address", this);
		total = new FloatExpression("total", this);
		date = new DateExpression("date", this);
		deliveryDate = new DateExpression("deliveryDate", this);
		invoice_lines = new CollectionExpression("ORM_Invoice_lines", this);
	}

	public InvoiceCriteria(PersistentSession session) {
		this(session.createCriteria(Invoice.class));
	}

	public InvoiceCriteria() throws PersistentException {
		this(TrabalhoPersistentManager.instance().getSession());
	}

	public AddressCriteria createAddressCriteria() {
		return new AddressCriteria(createCriteria("address"));
	}

	public Invoice_lineCriteria createInvoice_linesCriteria() {
		return new Invoice_lineCriteria(createCriteria("ORM_Invoice_lines"));
	}

	public Invoice uniqueInvoice() {
		return (Invoice) super.uniqueResult();
	}

	public Invoice[] listInvoice() {
		java.util.List list = super.list();
		return (Invoice[]) list.toArray(new Invoice[list.size()]);
	}
}

