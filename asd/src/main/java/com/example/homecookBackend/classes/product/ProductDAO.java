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
import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class ProductDAO {
	public static Product loadProductByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return loadProductByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Product getProductByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return getProductByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Product loadProductByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return loadProductByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Product getProductByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return getProductByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Product loadProductByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Product) session.load(Product.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Product getProductByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Product) session.get(Product.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Product loadProductByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Product) session.load(Product.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Product getProductByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Product) session.get(Product.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryProduct(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return queryProduct(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryProduct(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return queryProduct(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Product[] listProductByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return listProductByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Product[] listProductByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return listProductByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryProduct(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Product as Product");
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

	public static List queryProduct(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Product as Product");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Product", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Product[] listProductByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryProduct(session, condition, orderBy);
			return (Product[]) list.toArray(new Product[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Product[] listProductByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryProduct(session, condition, orderBy, lockMode);
			return (Product[]) list.toArray(new Product[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Product loadProductByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return loadProductByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Product loadProductByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return loadProductByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Product loadProductByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Product[] products = listProductByQuery(session, condition, orderBy);
		if (products != null && products.length > 0)
			return products[0];
		else
			return null;
	}

	public static Product loadProductByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Product[] products = listProductByQuery(session, condition, orderBy, lockMode);
		if (products != null && products.length > 0)
			return products[0];
		else
			return null;
	}

	public static java.util.Iterator iterateProductByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return iterateProductByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static java.util.Iterator iterateProductByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return iterateProductByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static java.util.Iterator iterateProductByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Product as Product");
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

	public static java.util.Iterator iterateProductByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Product as Product");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Product", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Product createProduct() {
		return new Product();
	}

	public static boolean save(Product product) throws PersistentException {
		try {
			TrabalhoPersistentManager.instance().saveObject(product);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean delete(Product product) throws PersistentException {
		try {
			TrabalhoPersistentManager.instance().deleteObject(product);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean deleteAndDissociate(Product product)throws PersistentException {
		try {
			if (product.getBaker() != null) {
				product.getBaker().products.remove(product);
			}

			return delete(product);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean deleteAndDissociate(Product product, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (product.getBaker() != null) {
				product.getBaker().products.remove(product);
			}

			try {
				session.delete(product);
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

	public static boolean refresh(Product product) throws PersistentException {
		try {
			TrabalhoPersistentManager.instance().getSession().refresh(product);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean evict(Product product) throws PersistentException {
		try {
			TrabalhoPersistentManager.instance().getSession().evict(product);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Product loadProductByCriteria(ProductCriteria productCriteria) {
		Product[] products = listProductByCriteria(productCriteria);
		if(products == null || products.length == 0) {
			return null;
		}
		return products[0];
	}

	public static Product[] listProductByCriteria(ProductCriteria productCriteria) {
		return productCriteria.listProduct();
	}
}
