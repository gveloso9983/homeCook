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
import com.example.homecookBackend.classes.TrabalhoPersistentManager;
import com.example.homecookBackend.classes.invoice.InvoiceCriteria;
import com.example.homecookBackend.classes.product.ProductCriteria;
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Invoice_lineCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final IntegerExpression invoiceId;
	public final AssociationExpression invoice;
	public final IntegerExpression productId;
	public final AssociationExpression product;
	public final IntegerExpression quantity;
	public final BooleanExpression done;

	public Invoice_lineCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		invoiceId = new IntegerExpression("invoice.id", this);
		invoice = new AssociationExpression("invoice", this);
		productId = new IntegerExpression("product.id", this);
		product = new AssociationExpression("product", this);
		quantity = new IntegerExpression("quantity", this);
		done = new BooleanExpression("done", this);
	}

	public Invoice_lineCriteria(PersistentSession session) {
		this(session.createCriteria(Invoice_line.class));
	}

	public Invoice_lineCriteria() throws PersistentException {
		this(TrabalhoPersistentManager.instance().getSession());
	}

	public InvoiceCriteria createInvoiceCriteria() {
		return new InvoiceCriteria(createCriteria("invoice"));
	}

	public ProductCriteria createProductCriteria() {
		return new ProductCriteria(createCriteria("product"));
	}

	public Invoice_line uniqueInvoice_line() {
		return (Invoice_line) super.uniqueResult();
	}

	public Invoice_line[] listInvoice_line() {
		java.util.List list = super.list();
		return (Invoice_line[]) list.toArray(new Invoice_line[list.size()]);
	}
}

