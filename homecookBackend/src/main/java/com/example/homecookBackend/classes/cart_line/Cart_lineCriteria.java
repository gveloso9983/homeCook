package com.example.homecookBackend.classes.cart_line; /**
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
import com.example.homecookBackend.classes.product.ProductCriteria;
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Cart_lineCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final IntegerExpression productId;
	public final AssociationExpression product;
	public final IntegerExpression quantity;

	public Cart_lineCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		productId = new IntegerExpression("product.id", this);
		product = new AssociationExpression("product", this);
		quantity = new IntegerExpression("quantity", this);
	}

	public Cart_lineCriteria(PersistentSession session) {
		this(session.createCriteria(Cart_line.class));
	}

	public Cart_lineCriteria() throws PersistentException {
		this(TrabalhoPersistentManager.instance().getSession());
	}

	public ProductCriteria createProductCriteria() {
		return new ProductCriteria(createCriteria("product"));
	}

	public Cart_line uniqueCart_line() {
		return (Cart_line) super.uniqueResult();
	}

	public Cart_line[] listCart_line() {
		java.util.List list = super.list();
		return (Cart_line[]) list.toArray(new Cart_line[list.size()]);
	}
}

