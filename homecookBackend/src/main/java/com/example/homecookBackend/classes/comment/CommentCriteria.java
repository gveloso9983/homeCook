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
import com.example.homecookBackend.classes.TrabalhoPersistentManager;
import com.example.homecookBackend.classes.client.ClientCriteria;
import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class CommentCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final IntegerExpression clientId;
	public final AssociationExpression client;
	public final FloatExpression score;
	public final DateExpression date;
	public final StringExpression comment;

	public CommentCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		clientId = new IntegerExpression("client.id", this);
		client = new AssociationExpression("client", this);
		score = new FloatExpression("score", this);
		date = new DateExpression("date", this);
		comment = new StringExpression("comment", this);
	}

	public CommentCriteria(PersistentSession session) {
		this(session.createCriteria(Comment.class));
	}

	public CommentCriteria() throws PersistentException {
		this(TrabalhoPersistentManager.instance().getSession());
	}

	public ClientCriteria createClientCriteria() {
		return new ClientCriteria(createCriteria("client"));
	}

	public Comment uniqueComment() {
		return (Comment) super.uniqueResult();
	}

	public Comment[] listComment() {
		java.util.List list = super.list();
		return (Comment[]) list.toArray(new Comment[list.size()]);
	}
}

