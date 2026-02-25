package dealerDAO;

import java.util.List;
import dealerPD.Car;
import jakarta.persistence.*;

public class CarDAO {

	public static void addCar(Car car) {
		EntityManager em = emDAO.getEM();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(car);
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) tx.rollback();
			throw new RuntimeException(e);
		} finally {
			em.close();
		}
	}
		
	public static void saveCar(Car car) {
		EntityManager em = emDAO.getEM();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(car);
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) tx.rollback();
			throw new RuntimeException(e);
		} finally {
			em.close();
		}
	}

	public static List<Car> listCar() {
		EntityManager em = emDAO.getEM();
		try {
			TypedQuery<Car> query = em.createQuery("SELECT car FROM car car", Car.class);
			return query.getResultList();
		} finally {
			em.close();
		}
	}

	public static Car findCarById(int id) {
		EntityManager em = emDAO.getEM();
		try {
			return em.find(Car.class, new Long(id));
		} finally {
			em.close();
		}
	}
	
	public static void removeCar(Car car) {
		EntityManager em = emDAO.getEM();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Car mergedCar = em.merge(car);
			em.remove(mergedCar);
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) tx.rollback();
			throw new RuntimeException(e);
		} finally {
			em.close();
		}
	}
}
