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
import java.util.List;

import com.example.homecookBackend.classes.product.ProductDetachedCriteria;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Cart_lineDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final IntegerExpression productId;
	public final AssociationExpression product;
	public final IntegerExpression quantity;

	public Cart_lineDetachedCriteria() {
		super(Cart_line.class, Cart_lineCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		productId = new IntegerExpression("product.id", this.getDetachedCriteria());
		product = new AssociationExpression("product", this.getDetachedCriteria());
		quantity = new IntegerExpression("quantity", this.getDetachedCriteria());
	}

	public Cart_lineDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, Cart_lineCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		productId = new IntegerExpression("product.id", this.getDetachedCriteria());
		product = new AssociationExpression("product", this.getDetachedCriteria());
		quantity = new IntegerExpression("quantity", this.getDetachedCriteria());
	}

	public ProductDetachedCriteria createProductCriteria() {
		return new ProductDetachedCriteria(createCriteria("product"));
	}

	public Cart_line uniqueCart_line(PersistentSession session) {
		return (Cart_line) super.createExecutableCriteria(session).uniqueResult();
	}

	public Cart_line[] listCart_line(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Cart_line[]) list.toArray(new Cart_line[list.size()]);
	}
}

