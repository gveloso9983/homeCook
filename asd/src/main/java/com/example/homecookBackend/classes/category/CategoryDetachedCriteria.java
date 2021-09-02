package com.example.homecookBackend.classes.category; /**
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
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class CategoryDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression name;

	public CategoryDetachedCriteria() {
		super(Category.class, CategoryCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
	}

	public CategoryDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, CategoryCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
	}

	public Category uniqueCategory(PersistentSession session) {
		return (Category) super.createExecutableCriteria(session).uniqueResult();
	}

	public Category[] listCategory(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Category[]) list.toArray(new Category[list.size()]);
	}
}

