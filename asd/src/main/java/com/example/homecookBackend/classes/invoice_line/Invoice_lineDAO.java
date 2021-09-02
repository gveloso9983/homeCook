package com.example.homecookBackend.classes.invoice_line; /**
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

public class Invoice_lineDAO {
	public static Invoice_line loadInvoice_lineByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return loadInvoice_lineByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Invoice_line getInvoice_lineByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return getInvoice_lineByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Invoice_line loadInvoice_lineByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return loadInvoice_lineByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Invoice_line getInvoice_lineByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return getInvoice_lineByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Invoice_line loadInvoice_lineByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Invoice_line) session.load(Invoice_line.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Invoice_line getInvoice_lineByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Invoice_line) session.get(Invoice_line.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Invoice_line loadInvoice_lineByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Invoice_line) session.load(Invoice_line.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Invoice_line getInvoice_lineByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Invoice_line) session.get(Invoice_line.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryInvoice_line(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return queryInvoice_line(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryInvoice_line(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return queryInvoice_line(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Invoice_line[] listInvoice_lineByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return listInvoice_lineByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Invoice_line[] listInvoice_lineByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return listInvoice_lineByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static List queryInvoice_line(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Invoice_line as Invoice_line");
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

	public static List queryInvoice_line(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Invoice_line as Invoice_line");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Invoice_line", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Invoice_line[] listInvoice_lineByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryInvoice_line(session, condition, orderBy);
			return (Invoice_line[]) list.toArray(new Invoice_line[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Invoice_line[] listInvoice_lineByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryInvoice_line(session, condition, orderBy, lockMode);
			return (Invoice_line[]) list.toArray(new Invoice_line[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Invoice_line loadInvoice_lineByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return loadInvoice_lineByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Invoice_line loadInvoice_lineByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return loadInvoice_lineByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Invoice_line loadInvoice_lineByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Invoice_line[] invoice_lines = listInvoice_lineByQuery(session, condition, orderBy);
		if (invoice_lines != null && invoice_lines.length > 0)
			return invoice_lines[0];
		else
			return null;
	}

	public static Invoice_line loadInvoice_lineByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Invoice_line[] invoice_lines = listInvoice_lineByQuery(session, condition, orderBy, lockMode);
		if (invoice_lines != null && invoice_lines.length > 0)
			return invoice_lines[0];
		else
			return null;
	}

	public static java.util.Iterator iterateInvoice_lineByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return iterateInvoice_lineByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static java.util.Iterator iterateInvoice_lineByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrabalhoPersistentManager.instance().getSession();
			return iterateInvoice_lineByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static java.util.Iterator iterateInvoice_lineByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Invoice_line as Invoice_line");
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

	public static java.util.Iterator iterateInvoice_lineByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From Invoice_line as Invoice_line");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Invoice_line", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Invoice_line createInvoice_line() {
		return new Invoice_line();
	}

	public static boolean save(Invoice_line invoice_line) throws PersistentException {
		try {
			TrabalhoPersistentManager.instance().saveObject(invoice_line);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean delete(Invoice_line invoice_line) throws PersistentException {
		try {
			TrabalhoPersistentManager.instance().deleteObject(invoice_line);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean deleteAndDissociate(Invoice_line invoice_line)throws PersistentException {
		try {
			if (invoice_line.getInvoice() != null) {
				invoice_line.getInvoice().invoice_lines.remove(invoice_line);
			}

			return delete(invoice_line);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean deleteAndDissociate(Invoice_line invoice_line, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (invoice_line.getInvoice() != null) {
				invoice_line.getInvoice().invoice_lines.remove(invoice_line);
			}

			try {
				session.delete(invoice_line);
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

	public static boolean refresh(Invoice_line invoice_line) throws PersistentException {
		try {
			TrabalhoPersistentManager.instance().getSession().refresh(invoice_line);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static boolean evict(Invoice_line invoice_line) throws PersistentException {
		try {
			TrabalhoPersistentManager.instance().getSession().evict(invoice_line);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}

	public static Invoice_line loadInvoice_lineByCriteria(Invoice_lineCriteria invoice_lineCriteria) {
		Invoice_line[] invoice_lines = listInvoice_lineByCriteria(invoice_lineCriteria);
		if(invoice_lines == null || invoice_lines.length == 0) {
			return null;
		}
		return invoice_lines[0];
	}

	public static Invoice_line[] listInvoice_lineByCriteria(Invoice_lineCriteria invoice_lineCriteria) {
		return invoice_lineCriteria.listInvoice_line();
	}
}
