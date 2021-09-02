package com.example.homecookBackend.classes.baker; /**
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
import com.example.homecookBackend.classes.product.Product;
import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class BakerDAO {
	public static Baker loadBakerByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return loadBakerByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Baker getBakerByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return getBakerByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Baker loadBakerByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return loadBakerByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Baker getBakerByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return getBakerByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Baker loadBakerByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Baker) session.load(Baker.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Baker getBakerByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Baker) session.get(Baker.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Baker loadBakerByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Baker) session.load(Baker.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Baker getBakerByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Baker) session.get(Baker.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryBaker(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return queryBaker(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryBaker(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return queryBaker(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Baker[] listBakerByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return listBakerByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Baker[] listBakerByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return listBakerByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryBaker(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Baker as Baker");
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

	public static List queryBaker(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Baker as Baker");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Baker", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Baker[] listBakerByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryBaker(session, condition, orderBy);
			return (Baker[]) list.toArray(new Baker[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Baker[] listBakerByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryBaker(session, condition, orderBy, lockMode);
			return (Baker[]) list.toArray(new Baker[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Baker loadBakerByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return loadBakerByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Baker loadBakerByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return loadBakerByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Baker loadBakerByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Baker[] bakers = listBakerByQuery(session, condition, orderBy);
		if (bakers != null && bakers.length > 0)
			return bakers[0];
		else
			return null;
	}

	public static Baker loadBakerByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Baker[] bakers = listBakerByQuery(session, condition, orderBy, lockMode);
		if (bakers != null && bakers.length > 0)
			return bakers[0];
		else
			return null;
	}

	public static java.util.Iterator iterateBakerByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return iterateBakerByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static java.util.Iterator iterateBakerByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return iterateBakerByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static java.util.Iterator iterateBakerByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Baker as Baker");
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

	public static java.util.Iterator iterateBakerByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Baker as Baker");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Baker", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Baker createBaker() {
		return new Baker();
	}

	public static boolean save(Baker baker) throws PersistentException {
		try {
			TrabalhoPersistentManager.instance().saveObject(baker);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean delete(Baker baker) throws PersistentException {
		try {
			TrabalhoPersistentManager.instance().deleteObject(baker);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean deleteAndDissociate(Baker baker)throws PersistentException {
		try {
			Product[] lProductss = baker.products.toArray();
			for(int i = 0; i < lProductss.length; i++) {
				lProductss[i].setBaker(null);
			}
			return delete(baker);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean deleteAndDissociate(Baker baker, org.orm.PersistentSession session)throws PersistentException {
		try {
			Product[] lProductss = baker.products.toArray();
			for(int i = 0; i < lProductss.length; i++) {
				lProductss[i].setBaker(null);
			}
			try {
				session.delete(baker);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean refresh(Baker baker) throws PersistentException {
		try {
			TrabalhoPersistentManager.instance().getSession().refresh(baker);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean evict(Baker baker) throws PersistentException {
		try {
			TrabalhoPersistentManager.instance().getSession().evict(baker);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Baker loadBakerByCriteria(BakerCriteria bakerCriteria) {
		Baker[] bakers = listBakerByCriteria(bakerCriteria);
		if(bakers == null || bakers.length == 0) {
			return null;
		}
		return bakers[0];
	}

	public static Baker[] listBakerByCriteria(BakerCriteria bakerCriteria) {
		return bakerCriteria.listBaker();
	}
}
