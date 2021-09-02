package com.example.homecookBackend.classes.invoice_line; /**
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

import com.example.homecookBackend.classes.invoice.InvoiceDetachedCriteria;
import com.example.homecookBackend.classes.product.ProductDetachedCriteria;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Invoice_lineDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final IntegerExpression invoiceId;
	public final AssociationExpression invoice;
	public final IntegerExpression productId;
	public final AssociationExpression product;
	public final IntegerExpression quantity;
	public final BooleanExpression done;

	public Invoice_lineDetachedCriteria() {
		super(Invoice_line.class, Invoice_lineCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		invoiceId = new IntegerExpression("invoice.id", this.getDetachedCriteria());
		invoice = new AssociationExpression("invoice", this.getDetachedCriteria());
		productId = new IntegerExpression("product.id", this.getDetachedCriteria());
		product = new AssociationExpression("product", this.getDetachedCriteria());
		quantity = new IntegerExpression("quantity", this.getDetachedCriteria());
		done = new BooleanExpression("done", this.getDetachedCriteria());
	}

	public Invoice_lineDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, Invoice_lineCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		invoiceId = new IntegerExpression("invoice.id", this.getDetachedCriteria());
		invoice = new AssociationExpression("invoice", this.getDetachedCriteria());
		productId = new IntegerExpression("product.id", this.getDetachedCriteria());
		product = new AssociationExpression("product", this.getDetachedCriteria());
		quantity = new IntegerExpression("quantity", this.getDetachedCriteria());
		done = new BooleanExpression("done", this.getDetachedCriteria());
	}

	public InvoiceDetachedCriteria createInvoiceCriteria() {
		return new InvoiceDetachedCriteria(createCriteria("invoice"));
	}

	public ProductDetachedCriteria createProductCriteria() {
		return new ProductDetachedCriteria(createCriteria("product"));
	}

	public Invoice_line uniqueInvoice_line(PersistentSession session) {
		return (Invoice_line) super.createExecutableCriteria(session).uniqueResult();
	}

	public Invoice_line[] listInvoice_line(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Invoice_line[]) list.toArray(new Invoice_line[list.size()]);
	}
}

