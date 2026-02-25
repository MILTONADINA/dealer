package dealerDAO;

import java.util.List;
import dealerPD.Dealer;
import jakarta.persistence.*;

public class DealerDAO {

	public static void addDealer(Dealer dealer) {
		EntityManager em = emDAO.getEM();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(dealer);
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) tx.rollback();
			throw new RuntimeException(e);
		} finally {
			em.close();
		}
	}
		
	public static void saveDealer(Dealer dealer) {
		EntityManager em = emDAO.getEM();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(dealer);
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) tx.rollback();
			throw new RuntimeException(e);
		} finally {
			em.close();
		}
	}

	public static List<Dealer> listDealer() {
		EntityManager em = emDAO.getEM();
		try {
			TypedQuery<Dealer> query = em.createQuery("SELECT dealer FROM dealer dealer", Dealer.class);
			return query.getResultList();
		} finally {
			em.close();
		}
	}

	public static Dealer findDealerById(int id) {
		EntityManager em = emDAO.getEM();
		try {
			return em.find(Dealer.class, Long.valueOf(id));
		} finally {
			em.close();
		}
	}
	
	public static void removeDealer(Dealer dealer) {
		EntityManager em = emDAO.getEM();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Dealer mergedDealer = em.merge(dealer);
			em.remove(mergedDealer);
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) tx.rollback();
			throw new RuntimeException(e);
		} finally {
			em.close();
		}
	}
}
