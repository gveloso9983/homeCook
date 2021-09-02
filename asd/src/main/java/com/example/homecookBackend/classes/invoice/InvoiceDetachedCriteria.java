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
import java.util.List;

import com.example.homecookBackend.classes.address.AddressDetachedCriteria;
import com.example.homecookBackend.classes.invoice_line.Invoice_lineDetachedCriteria;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class InvoiceDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final IntegerExpression addressId;
	public final AssociationExpression address;
	public final FloatExpression total;
	public final DateExpression date;
	public final DateExpression deliveryDate;
	public final CollectionExpression invoice_lines;

	public InvoiceDetachedCriteria() {
		super(Invoice.class, InvoiceCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		addressId = new IntegerExpression("address.id", this.getDetachedCriteria());
		address = new AssociationExpression("address", this.getDetachedCriteria());
		total = new FloatExpression("total", this.getDetachedCriteria());
		date = new DateExpression("date", this.getDetachedCriteria());
		deliveryDate = new DateExpression("deliveryDate", this.getDetachedCriteria());
		invoice_lines = new CollectionExpression("ORM_Invoice_lines", this.getDetachedCriteria());
	}

	public InvoiceDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, InvoiceCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		addressId = new IntegerExpression("address.id", this.getDetachedCriteria());
		address = new AssociationExpression("address", this.getDetachedCriteria());
		total = new FloatExpression("total", this.getDetachedCriteria());
		date = new DateExpression("date", this.getDetachedCriteria());
		deliveryDate = new DateExpression("deliveryDate", this.getDetachedCriteria());
		invoice_lines = new CollectionExpression("ORM_Invoice_lines", this.getDetachedCriteria());
	}

	public AddressDetachedCriteria createAddressCriteria() {
		return new AddressDetachedCriteria(createCriteria("address"));
	}

	public Invoice_lineDetachedCriteria createInvoice_linesCriteria() {
		return new Invoice_lineDetachedCriteria(createCriteria("ORM_Invoice_lines"));
	}

	public Invoice uniqueInvoice(PersistentSession session) {
		return (Invoice) super.createExecutableCriteria(session).uniqueResult();
	}

	public Invoice[] listInvoice(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Invoice[]) list.toArray(new Invoice[list.size()]);
	}
}

