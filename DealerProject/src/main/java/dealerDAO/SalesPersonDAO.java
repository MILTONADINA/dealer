package dealerDAO;

import java.util.List;
import dealerPD.SalesPerson;
import jakarta.persistence.*;

public class SalesPersonDAO {

	public static void addsalesPerson(SalesPerson salesPerson) {
		EntityManager em = emDAO.getEM();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(salesPerson);
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive())
				tx.rollback();
			throw new RuntimeException(e);
		} finally {
			em.close();
		}
	}

	public static void savesalesPerson(SalesPerson salesPerson) {
		EntityManager em = emDAO.getEM();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(salesPerson);
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive())
				tx.rollback();
			throw new RuntimeException(e);
		} finally {
			em.close();
		}
	}

	public static List<SalesPerson> listsalesPerson() {
		EntityManager em = emDAO.getEM();
		try {
			TypedQuery<SalesPerson> query = em.createQuery("SELECT salesPerson FROM salesperson salesPerson",
					SalesPerson.class);
			return query.getResultList();
		} finally {
			em.close();
		}
	}

	public static SalesPerson findsalesPersonById(int id) {
		EntityManager em = emDAO.getEM();
		try {
			return em.find(SalesPerson.class, Long.valueOf(id));
		} finally {
			em.close();
		}
	}

	public static void removesalesPerson(SalesPerson salesPerson) {
		EntityManager em = emDAO.getEM();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			SalesPerson mergedSalesPerson = em.merge(salesPerson);
			em.remove(mergedSalesPerson);
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive())
				tx.rollback();
			throw new RuntimeException(e);
		} finally {
			em.close();
		}
	}
}
