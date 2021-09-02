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
import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class CommentDAO {
	public static Comment loadCommentByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return loadCommentByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Comment getCommentByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return getCommentByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Comment loadCommentByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return loadCommentByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Comment getCommentByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return getCommentByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Comment loadCommentByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Comment) session.load(Comment.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Comment getCommentByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Comment) session.get(Comment.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Comment loadCommentByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Comment) session.load(Comment.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Comment getCommentByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Comment) session.get(Comment.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryComment(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return queryComment(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryComment(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return queryComment(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Comment[] listCommentByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return listCommentByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Comment[] listCommentByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return listCommentByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryComment(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Comment as Comment");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryComment(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Comment as Comment");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Comment", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Comment[] listCommentByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryComment(session, condition, orderBy);
			return (Comment[]) list.toArray(new Comment[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Comment[] listCommentByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryComment(session, condition, orderBy, lockMode);
			return (Comment[]) list.toArray(new Comment[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Comment loadCommentByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return loadCommentByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Comment loadCommentByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return loadCommentByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Comment loadCommentByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Comment[] comments = listCommentByQuery(session, condition, orderBy);
		if (comments != null && comments.length > 0)
			return comments[0];
		else
			return null;
	}

	public static Comment loadCommentByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Comment[] comments = listCommentByQuery(session, condition, orderBy, lockMode);
		if (comments != null && comments.length > 0)
			return comments[0];
		else
			return null;
	}

	public static java.util.Iterator iterateCommentByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return iterateCommentByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static java.util.Iterator iterateCommentByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return iterateCommentByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static java.util.Iterator iterateCommentByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Comment as Comment");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static java.util.Iterator iterateCommentByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Comment as Comment");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Comment", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Comment createComment() {
		return new Comment();
	}

	public static boolean save(Comment comment) throws PersistentException {
		try {
			TrabalhoPersistentManager.instance().saveObject(comment);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean delete(Comment comment) throws PersistentException {
		try {
			TrabalhoPersistentManager.instance().deleteObject(comment);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean refresh(Comment comment) throws PersistentException {
		try {
			TrabalhoPersistentManager.instance().getSession().refresh(comment);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean evict(Comment comment) throws PersistentException {
		try {
			TrabalhoPersistentManager.instance().getSession().evict(comment);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Comment loadCommentByCriteria(CommentCriteria commentCriteria) {
		Comment[] comments = listCommentByCriteria(commentCriteria);
		if(comments == null || comments.length == 0) {
			return null;
		}
		return comments[0];
	}

	public static Comment[] listCommentByCriteria(CommentCriteria commentCriteria) {
		return commentCriteria.listComment();
	}
}
