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
import com.example.homecookBackend.classes.TrabalhoPersistentManager;
import com.example.homecookBackend.classes.baker.BakerCriteria;
import com.example.homecookBackend.classes.category.CategoryCriteria;
import com.example.homecookBackend.classes.comment.CommentCriteria;
import com.example.homecookBackend.classes.image.ImageCriteria;
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ProductCriteria extends AbstractORMCriteria {
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

	public ProductCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		bakerId = new IntegerExpression("baker.id", this);
		baker = new AssociationExpression("baker", this);
		categoryId = new IntegerExpression("category.id", this);
		category = new AssociationExpression("category", this);
		name = new StringExpression("name", this);
		description = new StringExpression("description", this);
		ingredients = new StringExpression("ingredients", this);
		price = new FloatExpression("price", this);
		weight = new FloatExpression("weight", this);
		rating = new FloatExpression("rating", this);
		number_ratings = new IntegerExpression("number_ratings", this);
		onSale = new BooleanExpression("onSale", this);
		comments = new CollectionExpression("ORM_Comments", this);
		images = new CollectionExpression("ORM_Images", this);
	}

	public ProductCriteria(PersistentSession session) {
		this(session.createCriteria(Product.class));
	}

	public ProductCriteria() throws PersistentException {
		this(TrabalhoPersistentManager.instance().getSession());
	}

	public BakerCriteria createBakerCriteria() {
		return new BakerCriteria(createCriteria("baker"));
	}

	public CategoryCriteria createCategoryCriteria() {
		return new CategoryCriteria(createCriteria("category"));
	}

	public CommentCriteria createCommentsCriteria() {
		return new CommentCriteria(createCriteria("ORM_Comments"));
	}

	public ImageCriteria createImagesCriteria() {
		return new ImageCriteria(createCriteria("ORM_Images"));
	}

	public Product uniqueProduct() {
		return (Product) super.uniqueResult();
	}

	public Product[] listProduct() {
		java.util.List list = super.list();
		return (Product[]) list.toArray(new Product[list.size()]);
	}
}

