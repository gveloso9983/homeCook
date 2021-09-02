package com.example.homecookBackend.classes.image; /**
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
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ImageCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression path;

	public ImageCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		path = new StringExpression("path", this);
	}

	public ImageCriteria(PersistentSession session) {
		this(session.createCriteria(Image.class));
	}

	public ImageCriteria() throws PersistentException {
		this(TrabalhoPersistentManager.instance().getSession());
	}

	public Image uniqueImage() {
		return (Image) super.uniqueResult();
	}

	public Image[] listImage() {
		java.util.List list = super.list();
		return (Image[]) list.toArray(new Image[list.size()]);
	}
}

