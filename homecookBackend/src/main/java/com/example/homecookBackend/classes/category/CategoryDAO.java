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
import com.example.homecookBackend.classes.TrabalhoPersistentManager;
import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class CategoryDAO {
	public static Category loadCategoryByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return loadCategoryByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Category getCategoryByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return getCategoryByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Category loadCategoryByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return loadCategoryByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Category getCategoryByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return getCategoryByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Category loadCategoryByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Category) session.load(Category.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Category getCategoryByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Category) session.get(Category.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Category loadCategoryByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Category) session.load(Category.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Category getCategoryByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Category) session.get(Category.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryCategory(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return queryCategory(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryCategory(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return queryCategory(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Category[] listCategoryByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return listCategoryByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Category[] listCategoryByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return listCategoryByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryCategory(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Category as Category");
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

	public static List queryCategory(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Category as Category");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Category", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Category[] listCategoryByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryCategory(session, condition, orderBy);
			return (Category[]) list.toArray(new Category[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Category[] listCategoryByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryCategory(session, condition, orderBy, lockMode);
			return (Category[]) list.toArray(new Category[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Category loadCategoryByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return loadCategoryByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Category loadCategoryByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return loadCategoryByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Category loadCategoryByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Category[] categorys = listCategoryByQuery(session, condition, orderBy);
		if (categorys != null && categorys.length > 0)
			return categorys[0];
		else
			return null;
	}

	public static Category loadCategoryByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Category[] categorys = listCategoryByQuery(session, condition, orderBy, lockMode);
		if (categorys != null && categorys.length > 0)
			return categorys[0];
		else
			return null;
	}

	public static java.util.Iterator iterateCategoryByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return iterateCategoryByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static java.util.Iterator iterateCategoryByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return iterateCategoryByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static java.util.Iterator iterateCategoryByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Category as Category");
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

	public static java.util.Iterator iterateCategoryByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Category as Category");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Category", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Category createCategory() {
		return new Category();
	}

	public static boolean save(Category category) throws PersistentException {
		try {
			TrabalhoPersistentManager.instance().saveObject(category);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean delete(Category category) throws PersistentException {
		try {
			TrabalhoPersistentManager.instance().deleteObject(category);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean refresh(Category category) throws PersistentException {
		try {
			TrabalhoPersistentManager.instance().getSession().refresh(category);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean evict(Category category) throws PersistentException {
		try {
			TrabalhoPersistentManager.instance().getSession().evict(category);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Category loadCategoryByCriteria(CategoryCriteria categoryCriteria) {
		Category[] categorys = listCategoryByCriteria(categoryCriteria);
		if(categorys == null || categorys.length == 0) {
			return null;
		}
		return categorys[0];
	}

	public static Category[] listCategoryByCriteria(CategoryCriteria categoryCriteria) {
		return categoryCriteria.listCategory();
	}
}
