package com.example.homecookBackend.classes.product; /**
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

import com.example.homecookBackend.classes.baker.BakerDetachedCriteria;
import com.example.homecookBackend.classes.category.CategoryDetachedCriteria;
import com.example.homecookBackend.classes.comment.CommentDetachedCriteria;
import com.example.homecookBackend.classes.image.ImageDetachedCriteria;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ProductDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final IntegerExpression bakerId;
	public final AssociationExpression baker;
	public final IntegerExpression categoryId;
	public final AssociationExpression category;
	public final StringExpression name;
	public final StringExpression description;
	public final StringExpression ingredients;
	public final FloatExpression price;
	public final FloatExpression weight;
	public final FloatExpression rating;
	public final IntegerExpression number_ratings;
	public final BooleanExpression onSale;
	public final CollectionExpression comments;
	public final CollectionExpression images;

	public ProductDetachedCriteria() {
		super(Product.class, ProductCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		bakerId = new IntegerExpression("baker.id", this.getDetachedCriteria());
		baker = new AssociationExpression("baker", this.getDetachedCriteria());
		categoryId = new IntegerExpression("category.id", this.getDetachedCriteria());
		category = new AssociationExpression("category", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
		ingredients = new StringExpression("ingredients", this.getDetachedCriteria());
		price = new FloatExpression("price", this.getDetachedCriteria());
		weight = new FloatExpression("weight", this.getDetachedCriteria());
		rating = new FloatExpression("rating", this.getDetachedCriteria());
		number_ratings = new IntegerExpression("number_ratings", this.getDetachedCriteria());
		onSale = new BooleanExpression("onSale", this.getDetachedCriteria());
		comments = new CollectionExpression("ORM_Comments", this.getDetachedCriteria());
		images = new CollectionExpression("ORM_Images", this.getDetachedCriteria());
	}

	public ProductDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, ProductCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		bakerId = new IntegerExpression("baker.id", this.getDetachedCriteria());
		baker = new AssociationExpression("baker", this.getDetachedCriteria());
		categoryId = new IntegerExpression("category.id", this.getDetachedCriteria());
		category = new AssociationExpression("category", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
		ingredients = new StringExpression("ingredients", this.getDetachedCriteria());
		price = new FloatExpression("price", this.getDetachedCriteria());
		weight = new FloatExpression("weight", this.getDetachedCriteria());
		rating = new FloatExpression("rating", this.getDetachedCriteria());
		number_ratings = new IntegerExpression("number_ratings", this.getDetachedCriteria());
		onSale = new BooleanExpression("onSale", this.getDetachedCriteria());
		comments = new CollectionExpression("ORM_Comments", this.getDetachedCriteria());
		images = new CollectionExpression("ORM_Images", this.getDetachedCriteria());
	}

	public BakerDetachedCriteria createBakerCriteria() {
		return new BakerDetachedCriteria(createCriteria("baker"));
	}

	public CategoryDetachedCriteria createCategoryCriteria() {
		return new CategoryDetachedCriteria(createCriteria("category"));
	}

	public CommentDetachedCriteria createCommentsCriteria() {
		return new CommentDetachedCriteria(createCriteria("ORM_Comments"));
	}

	public ImageDetachedCriteria createImagesCriteria() {
		return new ImageDetachedCriteria(createCriteria("ORM_Images"));
	}

	public Product uniqueProduct(PersistentSession session) {
		return (Product) super.createExecutableCriteria(session).uniqueResult();
	}

	public Product[] listProduct(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Product[]) list.toArray(new Product[list.size()]);
	}
}

