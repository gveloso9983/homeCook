package com.example.homecookBackend.classes.comment; /**
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

import com.example.homecookBackend.classes.client.ClientDetachedCriteria;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class CommentDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final IntegerExpression clientId;
	public final AssociationExpression client;
	public final FloatExpression score;
	public final DateExpression date;
	public final StringExpression comment;

	public CommentDetachedCriteria() {
		super(Comment.class, CommentCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		clientId = new IntegerExpression("client.id", this.getDetachedCriteria());
		client = new AssociationExpression("client", this.getDetachedCriteria());
		score = new FloatExpression("score", this.getDetachedCriteria());
		date = new DateExpression("date", this.getDetachedCriteria());
		comment = new StringExpression("comment", this.getDetachedCriteria());
	}

	public CommentDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, CommentCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		clientId = new IntegerExpression("client.id", this.getDetachedCriteria());
		client = new AssociationExpression("client", this.getDetachedCriteria());
		score = new FloatExpression("score", this.getDetachedCriteria());
		date = new DateExpression("date", this.getDetachedCriteria());
		comment = new StringExpression("comment", this.getDetachedCriteria());
	}

	public ClientDetachedCriteria createClientCriteria() {
		return new ClientDetachedCriteria(createCriteria("client"));
	}

	public Comment uniqueComment(PersistentSession session) {
		return (Comment) super.createExecutableCriteria(session).uniqueResult();
	}

	public Comment[] listComment(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Comment[]) list.toArray(new Comment[list.size()]);
	}
}

